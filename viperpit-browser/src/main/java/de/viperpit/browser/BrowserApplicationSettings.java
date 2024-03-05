package de.viperpit.browser;

import java.util.Properties;

public record BrowserApplicationSettings(String url, int x, int y, int width, int height) {
	public BrowserApplicationSettings(Properties properties) {
		this( //
				properties.getProperty("url", "http://localhost:8080/#/cpd"), //
				Integer.valueOf(properties.getProperty("x", "0")), //
				Integer.valueOf(properties.getProperty("y", "0")), //
				Integer.valueOf(properties.getProperty("width", "600")), //
				Integer.valueOf(properties.getProperty("height", "800")) //
		);
	}
}
