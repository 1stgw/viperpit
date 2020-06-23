package de.viperpit.generator;

import static com.google.common.base.Charsets.UTF_8;
import static java.util.stream.Collectors.toList;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.viperpit.agent.keys.KeyFile;

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
		var source = toPath(args[0] + "/viperpit-generator/src/main/resources/" + id);
		LOGGER.info("Running the Filter Generator...");
		new FilterGenerator().run(source);
		var filterConfigurations = FilterConfigurations.read(new File(source, "filter.properties"));
		LOGGER.info("Loading the Key file...");
		var keyFile = new File(source.getAbsolutePath(), "full.key");
		if (keyFile == null || !keyFile.exists()) {
			LOGGER.error("Key file could not be loaded");
			return;
		}
		LOGGER.info("Found key file and loading key file entries.");
		var keyCodeLines = new KeyFile(keyFile, UTF_8) //
				.getKeyCodeLines() //
				.values() //
				.stream() //
				.filter(keyCodeLine -> filterConfigurations.isIncluded(keyCodeLine.getCallback())) //
				.collect(toList());
		var targetForAgentJavaFiles = toPath(args[0] + "/viperpit-agent/src/main/java/");
		var targetForAgentResourceFiles = toPath(args[0] + "/viperpit-agent/src/main/resources/");
		LOGGER.info("Running the Role Configuration Generator...");
		var roleConfigurations = new RoleConfigurationsGenerator().run( //
				targetForAgentResourceFiles, //
				keyCodeLines, //
				filterConfigurations);
		LOGGER.info("Running the State Configuration Generator...");
		var defaultStateConfigurations = new DefaultStateConfigurationsGenerator().run( //
				targetForAgentResourceFiles, //
				keyCodeLines, //
				roleConfigurations);
		LOGGER.info("Running the Cockpit Configuration Generator...");
		var targetForWebApplicationResourceFiles = toPath(args[0] + "/viperpit-web/src/data/");
		var cockpitConfiguration = new CockpitConfigurationGenerator().run( //
				targetForWebApplicationResourceFiles, //
				keyCodeLines, //
				roleConfigurations, //
				defaultStateConfigurations, //
				id, //
				label);
		LOGGER.info("Running the Code Generator...");
		new WebApplicationGenerator().run( //
				targetForAgentJavaFiles, //
				cockpitConfiguration);
		LOGGER.info("Generator has finished successfully.");
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
