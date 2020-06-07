package de.viperpit.generator;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.core.JsonEncoding.UTF8;
import static com.google.common.base.CharMatcher.is;
import static com.google.common.base.CharMatcher.javaLetterOrDigit;
import static com.google.common.base.CharMatcher.javaLowerCase;
import static com.google.common.base.CharMatcher.whitespace;
import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Splitter.on;
import static com.google.common.base.Strings.commonPrefix;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Multimaps.index;
import static com.google.common.collect.Sets.newHashSet;
import static de.viperpit.generator.DefaultStateConfigurations.StateType.AIR;
import static de.viperpit.generator.DefaultStateConfigurations.StateType.RAMP;
import static de.viperpit.generator.DefaultStateConfigurations.StateType.TAXI;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.eclipse.xtext.xbase.lib.StringExtensions.toFirstLower;
import static org.eclipse.xtext.xbase.lib.StringExtensions.toFirstUpper;
import static org.springframework.util.StringUtils.capitalize;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import de.viperpit.agent.keys.KeyFile;
import de.viperpit.agent.keys.KeyFile.KeyCodeLine;
import de.viperpit.commons.cockpit.Pair;

public class CockpitConfigurationGenerator {

	private static final Set<String> GROUP_SUFFIXES = newHashSet("Button", "Switch", "Knob", "Handle", "Wheel",
			"Rotary", "Rocker");

	private static final Logger LOGGER = LoggerFactory.getLogger(CockpitConfigurationGenerator.class);

	@SuppressWarnings("deprecation")
	public CockpitConfiguration run(File metadataPath, String cockpitId, String cockpitLabel) throws Exception {
		var keyFile = new File(metadataPath.getAbsolutePath(), "full.key");
		if (keyFile == null || !keyFile.exists()) {
			LOGGER.error("Key file could not be loaded");
			return null;
		}
		LOGGER.info("Loading role file.");
		var roleFile = new File(metadataPath.getAbsolutePath(), "role.properties");
		RoleConfigurations roleConfigurations = RoleConfigurations.read(roleFile);
		LOGGER.info("Loading state file.");
		var stateFile = new File(metadataPath.getAbsolutePath(), "state.properties");
		DefaultStateConfigurations defaultStateConfigurations = DefaultStateConfigurations.read(stateFile);
		LOGGER.info("Loading filter file.");
		var filterFile = new File(metadataPath.getAbsolutePath(), "filter.properties");
		FilterConfigurations filterConfigurations = FilterConfigurations.read(filterFile);
		LOGGER.info("Found key file and loading key file entries.");
		var keyCodeLines = new KeyFile(keyFile, UTF_8) //
				.getKeyCodeLines() //
				.values() //
				.stream() //
				.filter(keyCodeLine -> filterConfigurations.isIncluded(keyCodeLine.getCallback())) //
				.collect(toList());
		LOGGER.info("Running the Generator.");
		Multimap<String, ControlConfiguration> controlConfigurationsByGroup = LinkedHashMultimap.create();
		keyCodeLines //
				.stream() //
				.forEach(keyCodeLine -> {
					String callback = keyCodeLine.getCallback();
					var id = toId(keyCodeLine.getDescription());
					var groupAndLabel = toGroupAndLabel(keyCodeLine);
					var group = groupAndLabel.first();
					var label = groupAndLabel.second();
					var relatedCallbacks = toRelated(keyCodeLine, groupAndLabel, keyCodeLines) //
							.stream() //
							.map(relatedKeyCodeLine -> toId(relatedKeyCodeLine.getDescription())) //
							.collect(Collectors.toList()); //
					var style = "button";
					if (label != null && label.equals("Push")) {
						style = "button";
					} else if (label != null && label.equals("Hold")) {
						style = "button";
					} else if (group.endsWith("Button")) {
						style = "button";
					} else if (group.contains("Switch") && label != null && label.startsWith("Cycle")) {
						style = "button";
					} else if (group.contains("Switch") && label != null && label.startsWith("Toggle")) {
						style = "button";
					} else if (group.contains("Switch") && label != null && label.startsWith("Tog.")) {
						style = "button";
					} else if (group.contains("Switch") && label != null && label.startsWith("Step")) {
						style = "button";
					} else if (group.contains("Switch") && relatedCallbacks.isEmpty()) {
						style = "button";
					} else if (group.contains("Handle") && label != null && label.startsWith("Toggle")) {
						style = "button";
					} else if (group.contains("Switch")) {
						style = "switch";
					} else if (group.contains("Knob")) {
						style = "knob";
					} else if (group.endsWith("Handle")) {
						style = "handle";
					} else if (group.contains("Wheel")) {
						style = "wheel";
					} else if (group.endsWith("Rotary")) {
						style = "rotary";
					} else if (group.endsWith("Rocker")) {
						style = "rocker";
					}
					var role = roleConfigurations.getRoleConfiguration(callback);
					var switchStyles = newArrayList("switch", "handle");
					var type = "button";
					if (switchStyles.contains(style) && relatedCallbacks.isEmpty()) {
						type = "button";
					} else if (style.equals("knob") && javaLowerCase().matchesNoneOf(label) && role != null
							&& !role.role().equals("left") && !role.role().equals("right")) {
						type = "switch";
					} else if (style.equals("knob")) {
						type = "button";
					} else if (switchStyles.contains(style)) {
						type = "switch";
					}
					var controlConfiguration = new ControlConfiguration( //
							id, //
							callback, //
							toLabel(keyCodeLine), //
							keyCodeLine.getDescription(), //
							style, //
							role.role(), //
							type, //
							defaultStateConfigurations.getDefaultValue(callback, RAMP), //
							defaultStateConfigurations.getDefaultValue(callback, TAXI), //
							defaultStateConfigurations.getDefaultValue(callback, AIR) //
					);
					controlConfigurationsByGroup.put(group, controlConfiguration);
				});

		var controlGroupConfigurations = new LinkedHashMap<String, ControlGroupConfiguration>();
		Multimap<String, ControlGroupConfiguration> controlGroupConfigurationsBySection = LinkedHashMultimap.create();
		var keyCodeLinesByGroup = index(keyCodeLines, keyCodeLine -> toGroupAndLabel(keyCodeLine).first());
		for (var keyCodeLineByGroup : keyCodeLinesByGroup.entries()) {
			var keyCodeLine = keyCodeLineByGroup.getValue();
			var id = keyCodeLineByGroup.getKey();
			var firstIndexToken = ": ";
			if (id.indexOf(firstIndexToken) < 0) {
				firstIndexToken = "-";
			}
			var firstIndex = id.indexOf(firstIndexToken);
			var lastIndexToken = GROUP_SUFFIXES.stream().filter(suffix -> id.endsWith(suffix)).findFirst();
			var lastIndex = (lastIndexToken.isEmpty()) ? id.length() : id.lastIndexOf(lastIndexToken.get());
			var label = toCapitalizedName(id.substring(firstIndex + 1, lastIndex).trim());
			var controlGroupConfiguration = controlGroupConfigurations.get(id);
			if (controlGroupConfiguration == null) {
				controlGroupConfiguration = new ControlGroupConfiguration( //
						id, //
						label, //
						defaultStateConfigurations.isStateful(keyCodeLine.getCallback()),
						controlConfigurationsByGroup.get(id) //
				);
				controlGroupConfigurations.put(id, controlGroupConfiguration);
				controlGroupConfigurationsBySection.put(keyCodeLine.getSection(), controlGroupConfiguration);
			}
		}
		var panelConfigurations = new LinkedHashMap<String, PanelConfiguration>();
		Multimap<String, PanelConfiguration> panelConfigurationsByCategory = LinkedHashMultimap.create();
		var keyCodeLinesBySection = index(keyCodeLines, keyCodeLine -> keyCodeLine.getSection());
		for (var keyCodeLineBySection : keyCodeLinesBySection.entries()) {
			var keyCodeLine = keyCodeLineBySection.getValue();
			var section = keyCodeLineBySection.getKey();
			var id = toId(section);
			var label = toName(section);
			var panelConfiguration = panelConfigurations.get(id);
			if (panelConfiguration == null) {
				panelConfiguration = new PanelConfiguration( //
						id, //
						label, //
						controlGroupConfigurationsBySection.get(section) //
				);
				panelConfigurations.put(id, panelConfiguration);
				panelConfigurationsByCategory.put(keyCodeLine.getCategory(), panelConfiguration);
			}
		}
		var consoleConfigurations = new LinkedHashMap<String, ConsoleConfiguration>();
		var keyCodeLinesByCategory = index(keyCodeLines, keyCodeLine -> keyCodeLine.getCategory());
		for (Entry<String, KeyCodeLine> keyCodeLineByCategory : keyCodeLinesByCategory.entries()) {
			var category = keyCodeLineByCategory.getKey();
			var id = toId(category);
			var label = toName(category);
			var consoleConfiguration = consoleConfigurations.get(id);
			if (consoleConfiguration == null) {
				consoleConfiguration = new ConsoleConfiguration( //
						id, //
						label, //
						panelConfigurationsByCategory.get(category) //
				);
			}
			consoleConfigurations.put(id, consoleConfiguration);
		}
		var cockpitConfiguration = new CockpitConfiguration( //
				cockpitId, //
				cockpitLabel, //
				consoleConfigurations.values() //
		);
		var file = new File(metadataPath, "configuration.json");
		var objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, ANY);
		new JsonFactoryBuilder() //
				.build() //
				.createGenerator(file, UTF8) //
				.setCodec(objectMapper) //
				.useDefaultPrettyPrinter() //
				.writeObject(cockpitConfiguration);
		return cockpitConfiguration;
	}

	private String toCapitalizedName(String string) {
		var tokens = new ArrayList<>(on(whitespace()).trimResults().splitToList(string));
		return tokens.stream().map(token -> capitalize(token.toLowerCase())).collect(joining(" "));
	}

	@SuppressWarnings("deprecation")
	private String toClassName(String string) {
		var name = string;
		name = is('.').removeFrom(name);
		name = is('_').replaceFrom(name, 'z');
		var tokens = new ArrayList<>(on(javaLetterOrDigit().negate()).trimResults().splitToList(name));
		return tokens.stream().map(token -> toFirstUpper(token.toLowerCase())).collect(joining());
	}

	private Pair<String, String> toGroupAndLabel(KeyCodeLine keyCodeLine) {
		var separator = " - ";
		var description = keyCodeLine.getDescription();
		var lastIndex = description.lastIndexOf(separator);
		if (lastIndex != -1) {
			var group = description.substring(0, lastIndex).trim();
			var label = description.substring(lastIndex + separator.length(), description.length()).trim();
			return new Pair<>(group, label);
		}
		return new Pair<>(description, null);
	}

	private String toId(String string) {
		return toFirstLower(toClassName(string));
	}

	private String toLabel(KeyCodeLine keyCodeLine) {
		var lastIndexToken = '-';
		String description = keyCodeLine.getDescription();
		if (description.lastIndexOf(lastIndexToken) < 0) {
			lastIndexToken = ':';
		}
		return description.substring(description.lastIndexOf(lastIndexToken) + 1, description.length()).trim();
	}

	private String toName(String string) {
		var tokens = new ArrayList<>(on(whitespace()).omitEmptyStrings().trimResults().splitToList(string));
		return tokens.stream().collect(joining(" "));
	}

	private Collection<KeyCodeLine> toRelated(KeyCodeLine keyCodeLine, Pair<String, String> groupAndLabel,
			Collection<KeyCodeLine> keyCodeLines) {
		if (groupAndLabel.value() == null) {
			return emptyList();
		}
		return keyCodeLines.stream().filter(otherKeyCodeLine -> {
			if (keyCodeLine.getCallback().equals(otherKeyCodeLine.getCallback())) {
				return false;
			}
			return commonPrefix(keyCodeLine.getDescription(), otherKeyCodeLine.getDescription())
					.length() >= groupAndLabel.first().length();
		}).collect(toList());
	}

}