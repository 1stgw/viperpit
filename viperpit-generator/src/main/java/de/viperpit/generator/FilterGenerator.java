package de.viperpit.generator;

import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Objects.equal;
import static com.google.common.collect.Maps.filterKeys;
import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.io.Files.asCharSink;
import static java.lang.System.lineSeparator;
import static java.util.Comparator.comparing;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.viperpit.agent.keys.KeyFile;

@SuppressWarnings("all")
public class FilterGenerator {
	private static Logger LOGGER = LoggerFactory.getLogger(FilterGenerator.class);

	public void run(File metadataPath) throws Exception {
		var fileWithAllCallbacks = new File(metadataPath.getAbsolutePath() + "/full.key");
		var fileWithCockpitCallbacks = new File(metadataPath.getAbsolutePath() + "/pitbuilder.key");
		if (fileWithAllCallbacks != null //
				&& fileWithAllCallbacks.exists() //
				&& fileWithCockpitCallbacks != null //
				&& fileWithCockpitCallbacks.exists()) {
			LOGGER.info("Found key files and loading key file entries.");
			LOGGER.info("Running the Generator.");
			this.generateFilter( //
					metadataPath, //
					new KeyFile(fileWithAllCallbacks, UTF_8), //
					new KeyFile(fileWithCockpitCallbacks, UTF_8) //
			);
			LOGGER.info("Generator has finished successfully.");
		} else {
			LOGGER.error("Key files could not be loaded");
		}
	}

	private void generateFilter(File path, KeyFile keyFileWithAllCallbacks, KeyFile keyFileWithCockpitCallbacks) {
		// Collection initialization
		Set<String> excludedFromFilters = newHashSet("SimThrottleIdleDetent");
		var keyCodeLinesWithAllCallbacks = filterKeys(keyFileWithAllCallbacks.getKeyCodeLines(), key -> {
			return !excludedFromFilters.contains(key);
		}) //
				.values() //
				.stream() //
				.sorted(comparing(it -> it.getCallback())) //
				.toList(); //
		var keyCodeLinesWithCockpitCallbacks = filterKeys(keyFileWithCockpitCallbacks.getKeyCodeLines(), key -> {
			return !excludedFromFilters.contains(key);
		}) //
				.values() //
				.stream() //
				.sorted(comparing(it -> it.getCallback())) //
				.toList(); //
		var overlappingKeys = newHashSet(keyFileWithAllCallbacks.getKeyCodeLines().keySet());
		overlappingKeys.removeAll(keyFileWithCockpitCallbacks.getKeyCodeLines().keySet());

		// Generator Template
		var stringBuilder = new StringBuilder();
		stringBuilder.append("# These keys are not relevant for a cockpit");
		stringBuilder.append(lineSeparator());
		overlappingKeys.stream().sorted().forEach(overlappingKey -> {
			stringBuilder.append(overlappingKey);
			stringBuilder.append("=no_cockpit");
			stringBuilder.append(lineSeparator());
		});
		stringBuilder.append(lineSeparator());
		stringBuilder.append("# These keys have no key binding");
		stringBuilder.append(lineSeparator());
		keyCodeLinesWithCockpitCallbacks.stream().filter(it -> {
			return !it.hasKey();
		}).forEach(keyCodeLine -> {
			stringBuilder.append(keyCodeLine.getCallback());
			stringBuilder.append("=no_binding");
			stringBuilder.append(lineSeparator());
		});
		stringBuilder.append(lineSeparator());
		stringBuilder.append("# These keys are on the Stick");
		stringBuilder.append(lineSeparator());
		keyCodeLinesWithAllCallbacks.stream().filter(it -> {
			return equal(it.getSection(), "FLIGHT STICK");
		}).forEach(keyCodeLine -> {
			stringBuilder.append(keyCodeLine.getCallback());
			stringBuilder.append("=stick");
			stringBuilder.append(lineSeparator());
		});
		stringBuilder.append(lineSeparator());
		stringBuilder.append("# These keys are on the Throttle");
		stringBuilder.append(lineSeparator());
		keyCodeLinesWithAllCallbacks.stream().filter(it -> {
			return equal(it.getSection(), "THROTTLE QUADRANT SYSTEM");
		}).forEach(keyCodeLine -> {
			stringBuilder.append(keyCodeLine.getCallback());
			stringBuilder.append("=throttle");
			stringBuilder.append(lineSeparator());
		});
		stringBuilder.append(lineSeparator());
		stringBuilder.append("# These keys are on the Left MFD");
		stringBuilder.append(lineSeparator());
		keyCodeLinesWithAllCallbacks.stream().filter(it -> {
			return equal(it.getSection(), "LEFT MFD");
		}).forEach(keyCodeLine -> {
			stringBuilder.append(keyCodeLine.getCallback());
			stringBuilder.append("=mfd");
			stringBuilder.append(lineSeparator());
		});
		stringBuilder.append(lineSeparator());
		stringBuilder.append("# These keys are on the Right MFD");
		stringBuilder.append(lineSeparator());
		keyCodeLinesWithAllCallbacks.stream().filter(it -> {
			return equal(it.getSection(), "RIGHT MFD");
		}).forEach(keyCodeLine -> {
			stringBuilder.append(keyCodeLine.getCallback());
			stringBuilder.append("=mfd");
			stringBuilder.append(lineSeparator());
		});
		stringBuilder.append(lineSeparator());
		stringBuilder.append("# These keys are on the ICP");
		stringBuilder.append(lineSeparator());
		keyCodeLinesWithAllCallbacks.stream().filter(it -> {
			return equal(it.getSection(), "ICP");
		}).forEach(keyCodeLine -> {
			stringBuilder.append(keyCodeLine.getCallback());
			stringBuilder.append("=icp");
			stringBuilder.append(lineSeparator());
		});
		stringBuilder.append(lineSeparator());
		stringBuilder.append("# These keys are Toggle keys and only meant for convenience purposes");
		stringBuilder.append(lineSeparator());
		keyCodeLinesWithAllCallbacks.stream().filter(it -> {
			return it.getDescription().endsWith(" - Toggle");
		}).forEach(keyCodeLine -> {
			stringBuilder.append(keyCodeLine.getCallback());
			stringBuilder.append("=toggle");
			stringBuilder.append(lineSeparator());
		});
		write(stringBuilder, new File(path, "filter.properties"), UTF_8);
	}

	public static void write(CharSequence charSequence, File file, Charset charset) {
		try {
			asCharSink(file, charset).write(charSequence);
		} catch (Throwable _e) {
			throw new RuntimeException(_e);
		}
	}
}
