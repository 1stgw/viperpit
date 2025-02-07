package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/services/cpd")
public class CenterPedestalDisplayController {

	private static final Logger LOGGER = getLogger(CenterPedestalDisplayController.class);

	@Autowired
	private ScreenshotProvider screenshotProvider;

	@GetMapping(path = "/image", produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody ResponseEntity<ByteArrayResource> getImage() {
		try {
			BufferedImage screenshot = screenshotProvider.getScreenshot();
			if (screenshot == null) {
				return ResponseEntity.noContent().build();
			}

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(screenshot, "png", byteArrayOutputStream);
			byteArrayOutputStream.close();

			long version = screenshot.hashCode();
			return ResponseEntity.ok()//
					.eTag(Long.toString(version)) //
					.body(new ByteArrayResource(byteArrayOutputStream.toByteArray())); //
		} catch (Exception exception) {
			LOGGER.error("An error occurred while converting the screenshot", exception);
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping(path = "/image-url", produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody ResponseEntity<String> getImageAsDataUrl() {
		ResponseEntity<ByteArrayResource> responseEntity = getImage();

		ByteArrayResource byteArrayResource = responseEntity.getBody();

		if (byteArrayResource == null) {
			return ResponseEntity.internalServerError().build();
		}

		String encodedString = Base64.getEncoder().encodeToString(byteArrayResource.getByteArray());

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("data:");
		stringBuilder.append("image/png");
		stringBuilder.append(";base64,");
		stringBuilder.append(encodedString);

		String dataUrl = stringBuilder.toString();

		long version = dataUrl.hashCode();
		return ResponseEntity.ok()//
				.eTag(Long.toString(version)) //
				.body(dataUrl); //
	}

	@GetMapping(value = "/is-image-ready", produces = "text/event-stream")
	public SseEmitter isImageReady() {
		SseEmitter emitter = new SseEmitter(Long.valueOf(0));

		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

		executor.scheduleAtFixedRate(() -> {
			try {
				if (!screenshotProvider.isRequiresUpdate()) {
					return;
				}

				emitter.send("image-is-ready");
			} catch (IOException exception) {
				LOGGER.error("An error occurred while sending the screenshot update notice.", exception);
				emitter.complete();
				executor.shutdown();
			}
		}, 0, 100, TimeUnit.MILLISECONDS);

		emitter.onCompletion(executor::shutdown);
		emitter.onTimeout(() -> {
			LOGGER.error("A timeout occurred, completing Emitter.");
			emitter.complete();
			executor.shutdown();
		});
		
		
		try {
			emitter.send("emitter-is-ready");
		} catch (IOException exception) {
			LOGGER.error("An error occurred while sending the screenshot update notice.", exception);
		}

		return emitter;
	}
}