package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.jna.platform.DesktopWindow;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.WinDef;

import de.viperpit.agent.data.ScreenshotUtil;

@Component
public class ScreenshotProvider {

	private static final Logger LOGGER = getLogger(ScreenshotProvider.class);

	private final String processFilePath;

	private final String windowName;

	private BufferedImage lastScreenshot;

	public ScreenshotProvider( //
			@Value("${local.cpd.path}") String processFilePath, //
			@Value("${local.cpd.window}") String windowName //
	) {
		this.processFilePath = processFilePath;
		this.windowName = windowName;
		LOGGER.info("Using window " + windowName + " on path " + processFilePath);
	}

	public BufferedImage getScreenshot() {
		return this.lastScreenshot;
	}

	public boolean isRequiresUpdate() {
		try {
			// We're gonna find and reuse the cached window if possible
			WinDef.HWND hwnd = this.findWindow();
			if (hwnd == null) {
				return false;
			}

			// Get the screenshot
			BufferedImage screenshot = ScreenshotUtil.getScreenshot(hwnd);
			if (screenshot == null) {
				return false;
			}

			// We want to be conservative with messaging, so we only send new screenshots if
			// necessary
			boolean requiresUpdate = requiresUpdate(screenshot);

			if (!requiresUpdate) {
				return false;
			}

			// Cache the latest screenshot
			this.lastScreenshot = screenshot;

			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	private WinDef.HWND findWindow() {
		try {
			List<DesktopWindow> windows = WindowUtils.getAllWindows(false);
			for (DesktopWindow currentWindow : windows) {
				if (!currentWindow.getFilePath().equals(processFilePath)) {
					continue;
				}
				if (!"*".equals(windowName) && !currentWindow.getTitle().equals(windowName)) {
					continue;
				}
				Rectangle locAndSize = currentWindow.getLocAndSize();
				if (locAndSize.height <= 0 && locAndSize.width <= 0) {
					continue;
				}
				return currentWindow.getHWND();
			}
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		}
		return null;
	}

	private boolean requiresUpdate(BufferedImage nextScreenshot) {
		if (nextScreenshot == null) {
			return false;
		}
		BufferedImage lastScreenshot = this.lastScreenshot;
		if (lastScreenshot == null) {
			return true;
		}
		if (nextScreenshot.getWidth() == lastScreenshot.getWidth()
				&& nextScreenshot.getHeight() == lastScreenshot.getHeight()) {
			for (int x = 0; x < nextScreenshot.getWidth(); x++) {
				for (int y = 0; y < nextScreenshot.getHeight(); y++) {
					if (nextScreenshot.getRGB(x, y) != lastScreenshot.getRGB(x, y)) {
						return true;
					}
				}
			}
		} else {
			return true;
		}
		return false;
	}
}