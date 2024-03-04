package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.awt.image.BufferedImage;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.sun.jna.platform.DesktopWindow;
import com.sun.jna.platform.WindowUtils;
import com.sun.jna.platform.win32.WinDef;

import de.viperpit.agent.data.ScreenshotUtil;

@Component
public class ScreenshotProvider {

	private static final Logger LOGGER = getLogger(ScreenshotProvider.class);

	private final String filePath;

	private final String windowTitle;

	private BufferedImage lastScreenshot;

	private WinDef.HWND lastWindow;

	public ScreenshotProvider() {
		this.filePath = "C:\\Program Files (x86)\\PSUdp\\PSUdp.exe";
		this.windowTitle = "HSI";
	}

	public ScreenshotProvider(String filePath, String windowTitle) {
		this.filePath = filePath;
		this.windowTitle = windowTitle;
	}

	public BufferedImage getUpdatedScreenshot() {
		WinDef.HWND hwnd = this.findWindow();

		BufferedImage screenshot = ScreenshotUtil.getScreenshot(hwnd);
		if (screenshot == null) {
			System.out.println("Failed to capture screenshot.");
			return null;
		}

		boolean requiresUpdate = requiresUpdate(screenshot);
		this.lastScreenshot = screenshot;

		if (!requiresUpdate) {
			return null;
		}

		return screenshot;
	}

	private WinDef.HWND findWindow() {
		List<DesktopWindow> windows = WindowUtils.getAllWindows(false);

		WinDef.HWND hwnd = this.lastWindow;
		if (hwnd != null) {
			return this.lastWindow;
		}

		for (DesktopWindow currentWindow : windows) {
			if (!currentWindow.getFilePath().equals(filePath)) {
				continue;
			}
			if (currentWindow.getTitle().equals(windowTitle)) {
				hwnd = currentWindow.getHWND();
			}
		}

		if (hwnd == null) {
			LOGGER.info("Window not found.");
			return null;
		}

		this.lastWindow = hwnd;

		return hwnd;
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