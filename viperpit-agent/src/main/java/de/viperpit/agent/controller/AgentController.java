package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import de.viperpit.agent.keys.KeyDispatcherService;
import de.viperpit.agent.model.StateChangeEvent;
import de.viperpit.agent.model.TriggerStateChangeEvent;

@Controller
public class AgentController implements ApplicationListener<ApplicationEvent> {

	private static final String APP_STATES_TRIGGER_STATE_CHANGE = "/cockpit/states/triggerStateChange";

	private static final Logger LOGGER = getLogger(AgentController.class);

	private static final String TOPIC_STATES_UPDATE = "/topic/cockpit/states/update";

	private static final String CPD_IMAGES_UPDATE = "/topic/cpd/images/update";

	@Autowired
	private KeyDispatcherService keyDispatcherService;

	@Autowired
	private ScreenshotProvider screenshotProvider;

	@Autowired
	private SimpMessagingTemplate template;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		LOGGER.debug(event.toString());
	}

	@MessageMapping(APP_STATES_TRIGGER_STATE_CHANGE)
	@SendTo(TOPIC_STATES_UPDATE)
	public StateChangeEvent onStatesToggle(TriggerStateChangeEvent triggerStateChangeEvent) {
		if (triggerStateChangeEvent == null) {
			return null;
		}
		String callback = triggerStateChangeEvent.getCallback();
		if (callback == null) {
			return null;
		}

		if (triggerStateChangeEvent.isStart()) {
			keyDispatcherService.keyDown(callback);
		} else {
			keyDispatcherService.keyUp(callback);
		}
		return null;
	}

	@Scheduled(fixedDelay = 100)
	public void onCpdImagesUpdate() {
		try {
			BufferedImage screenshot = screenshotProvider.getUpdatedScreenshot();
			if (screenshot == null) {
				return;
			}

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ImageIO.write(screenshot, "png", byteArrayOutputStream);
			byteArrayOutputStream.close();

			byte[] data = byteArrayOutputStream.toByteArray();

			String encodedString = Base64.getEncoder().encodeToString(data);

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("data:");
			stringBuilder.append("image/png");
			stringBuilder.append(";base64,");
			stringBuilder.append(encodedString);

			template.convertAndSend(CPD_IMAGES_UPDATE, stringBuilder.toString());
		} catch (Exception exception) {
			LOGGER.error("An error occurred while converting the screenshot", exception);
		}
	}

}