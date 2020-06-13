package de.viperpit.generator.java;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(MainGenerator.class);

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			throw new IllegalArgumentException("One Path parameters have to be set (<workspace>).");
		}
		run(args, "f16", "F-16");
		run(args, "f35", "F-35");
	}

	private static void run(String[] args, String id, String label) throws Exception {
		LOGGER.info("Running the Generator for " + label + "...");
		LOGGER.info("Running the Filter Generator...");
		File source = toPath(args[0] + "/viperpit-generator/src/main/resources/" + id);
		LOGGER.info("Running the Filter Generator...");
		new FilterGenerator().run(source);
		LOGGER.info("Running the Cockpit Configuration Generator...");
		new CockpitConfigurationGenerator().run(source, id, label);
	}

	private static File toPath(String pathArgument) {
		if (pathArgument == null || pathArgument.isBlank()) {
			throw new IllegalArgumentException("Path is not set or empty.");
		}
		File path = new File(pathArgument);
		if (path.exists() && !path.isDirectory()) {
			throw new IllegalArgumentException("Path is not a directory.");
		}
		path.mkdirs();
		return path;
	}

}
