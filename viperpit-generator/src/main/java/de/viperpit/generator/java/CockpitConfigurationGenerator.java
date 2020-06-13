package de.viperpit.generator.java;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
import static com.fasterxml.jackson.core.JsonEncoding.UTF8;
import static com.google.common.base.CharMatcher.javaLowerCase;
import static com.google.common.base.Charsets.UTF_8;
import static com.google.common.base.Objects.equal;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Multimaps.index;
import static com.google.common.collect.Sets.newHashSet;
import static de.viperpit.generator.java.DefaultStateConfigurations.StateType.AIR;
import static de.viperpit.generator.java.DefaultStateConfigurations.StateType.RAMP;
import static de.viperpit.generator.java.DefaultStateConfigurations.StateType.TAXI;
import static de.viperpit.generator.java.KeyCodeLineNames.toCapitalizedName;
import static de.viperpit.generator.java.KeyCodeLineNames.toGroupAndLabel;
import static de.viperpit.generator.java.KeyCodeLineNames.toId;
import static de.viperpit.generator.java.KeyCodeLineNames.toLabel;
import static de.viperpit.generator.java.KeyCodeLineNames.toName;
import static de.viperpit.generator.java.KeyCodeLineNames.toRelated;
import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toList;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;

import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Objects;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import de.viperpit.agent.keys.KeyFile;
import de.viperpit.agent.keys.KeyFile.KeyCodeLine;
import de.viperpit.generator.java.DefaultStateConfigurations.DefaultStateConfiguration;

public class CockpitConfigurationGenerator {

	private static final Set<String> GROUP_SUFFIXES = newHashSet( //
			"Button", //
			"Switch", //
			"Knob", //
			"Handle", //
			"Wheel", //
			"Rotary", //
			"Rocker" //
	);

	private static final Logger LOGGER = getLogger(CockpitConfigurationGenerator.class);

	private static final Set<String> STATES_ALWAYS_OFF = unmodifiableSet(newHashSet( //
			"SimMasterFuelOff", //
			"SimFuelDoorOpen", //
			"SimEpuOn", //
			"SimEpuOff", //
			"SimAVTRSwitchOn", //
			"SimBupUhfMain", //
			"SimEwsJettOn", //
			"SimGndJettOn", //
			"SimParkingBrakeOn", //
			"SimArmMasterArm", //
			"SimDriftCOOn", //
			"SimRALTON", //
			"SimScalesOff", //
			"SimPitchLadderOff", //
			"SimINSNorm" //
	));

	private static final Set<String> STATES_ALWAYS_ON = unmodifiableSet(newHashSet( //
			"SimAltFlapsNorm", //
			"SimTrimAPNORM", //
			"SimMasterFuelOn", //
			"SimFuelDoorClose", //
			"SimEpuAuto", //
			"SimAVTRSwitchOff", //
			"SimJfsStart_Off", //
			"SimEngContPri", //
			"SimAud1Com1Sql", //
			"SimAud1Com2Sql", //
			"SimBupUhfPreset", //
			"SimEwsJettOff", //
			"SimEWSProgOne", //
			"SimHookUp", "SimGndJettOff", //
			"SimParkingBrakeOff", //
			"SimCATIII", //
			"SimLandingLightOff", //
			"SimRFNorm", //
			"SimLaserArmOff", //
			"SimSafeMasterArm", //
			"SimRightAPMid", //
			"SimLeftAPMid", //
			"SimDriftCOOff", //
			"SimHSINav", //
			"SimFuelSwitchNorm", //
			"SimFuelTransNorm", //
			"SimScalesVAH", //
			"SimRALTOFF", //
			"SimPitchLadderATTFPM", //
			"SimHUDDEDOff", //
			"SimReticleOff", //
			"SimHUDVelocityCAS", //
			"SimHUDAltAuto", //
			"SimHUDBrtDay", //
			"SimInteriorLight", //
			"SimInstrumentLight", //
			"SimVMSOn" //
	));

	private static final Set<String> STATES_OFF_AT_RAMP = unmodifiableSet(newHashSet( //
			"SimMasterFuelOff", //
			"SimBupUhfBoth", //
			"AFCanopyClose", //
			"SimSeatOn", //
			"SimEWSModeStby", //
			"SimINSNav" //
	));

	private static final Set<String> STATES_ON_AT_RAMP = unmodifiableSet(newHashSet( //
			"SimAuxComBackup", //
			"SimTACANAATR", //
			"SimLEFAuto", //
			"SimTrimAPNORSimMasterFuelOnM", //
			"SimLightsSteady", //
			"AFCanopyOpen", //
			"SimSeatOff" //
	));

	private RoleConfigurations generateRoles(Collection<KeyCodeLine> keyCodeLines) {
		var collection = new ArrayList<RoleConfiguration>();
		keyCodeLines.forEach(keyCodeLine -> {
			var groupAndLabel = toGroupAndLabel(keyCodeLine);
			var group = groupAndLabel.first();
			var label = groupAndLabel.second();
			var relatedCallbacks = toRelated(keyCodeLine, groupAndLabel, keyCodeLines) //
					.stream() //
					.map(relatedKeyCodeLine -> toId(relatedKeyCodeLine)) //
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
			collection.add(new RoleConfiguration( //
					keyCodeLine.getCallback(), //
					toRole(keyCodeLine), //
					style, //
					relatedCallbacks //
			));
		});
		return new RoleConfigurations(collection);
	}

	private DefaultStateConfigurations generateStates(Collection<KeyCodeLine> keyCodeLines,
			RoleConfigurations roleConfigurations) {
		var collection = new ArrayList<DefaultStateConfiguration>();
		keyCodeLines.stream().filter(keyCodeLine -> {
			String style = roleConfigurations.getRoleConfiguration(keyCodeLine.getCallback()).getStyle();
			return equal(style, "switch") || equal(style, "knob");
		}).forEach(keyCodeLine -> {
			String role = roleConfigurations.getRoleConfiguration(keyCodeLine.getCallback()).getRole();
			String callback = keyCodeLine.getCallback();
			if (STATES_ALWAYS_ON.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, true));
				collection.add(new DefaultStateConfiguration(callback, TAXI, true));
				collection.add(new DefaultStateConfiguration(callback, AIR, true));
			} else if (STATES_ALWAYS_OFF.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			} else if (STATES_ON_AT_RAMP.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, true));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			} else if (STATES_OFF_AT_RAMP.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, true));
				collection.add(new DefaultStateConfiguration(callback, AIR, true));
			} else if (Objects.equal(role, "off")) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, true));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			} else if (Objects.equal(role, "on")) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, true));
				collection.add(new DefaultStateConfiguration(callback, AIR, true));
			} else {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			}
		});
		return new DefaultStateConfigurations(collection);
	}

	@SuppressWarnings("deprecation")
	public void run(File metadataPath, String cockpitId, String cockpitLabel) throws Exception {
		var keyFile = new File(metadataPath.getAbsolutePath(), "full.key");
		if (keyFile == null || !keyFile.exists()) {
			LOGGER.error("Key file could not be loaded");
			return;
		}
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
		LOGGER.info("Generating roles.");
		var roleConfigurations = generateRoles(keyCodeLines);
		LOGGER.info("Generating states.");
		var defaultStateConfigurations = generateStates(keyCodeLines, roleConfigurations);
		LOGGER.info("Running the Generator.");
		Multimap<String, ControlConfiguration> controlConfigurationsByGroup = LinkedHashMultimap.create();
		keyCodeLines //
				.stream() //
				.forEach(keyCodeLine -> {
					String callback = keyCodeLine.getCallback();
					var id = toId(keyCodeLine);
					var groupAndLabel = toGroupAndLabel(keyCodeLine);
					var group = groupAndLabel.first();
					var label = groupAndLabel.second();
					var roleConfiguration = roleConfigurations.getRoleConfiguration(callback);
					var style = roleConfiguration.getStyle();
					var relatedCallbacks = roleConfiguration.getRelatedCallbacks();
					var switchStyles = newArrayList("switch", "handle");
					var type = "button";
					if (switchStyles.contains(style) && relatedCallbacks.isEmpty()) {
						type = "button";
					} else if (style.equals("knob") && javaLowerCase().matchesNoneOf(label) && roleConfiguration != null
							&& !roleConfiguration.getRole().equals("left")
							&& !roleConfiguration.getRole().equals("right")) {
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
							roleConfiguration.getRole(), //
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
		writeObject(new File(metadataPath, "configuration.json"), new CockpitConfiguration( //
				cockpitId, //
				cockpitLabel, //
				consoleConfigurations.values() //
		));
	}

	private String toRole(KeyCodeLine keyCodeLine) {
		String description = keyCodeLine.getDescription();
		if (description == null) {
			return "none";
		} else if (description.endsWith(" IFF OUT")) {
			return "none";
		} else if (description.endsWith(" IFF IN")) {
			return "none";
		} else if (description.endsWith(" ON")) {
			return "on";
		} else if (description.endsWith(" On")) {
			return "on";
		} else if (description.endsWith(" OFF")) {
			return "off";
		} else if (description.endsWith(" Off")) {
			return "off";
		} else if (description.endsWith(" ENABLE")) {
			return "on";
		} else if (description.endsWith(" DISABLE")) {
			return "off";
		} else if (description.endsWith(" OPEN")) {
			return "on";
		} else if (description.endsWith(" CLOSE")) {
			return "off";
		} else if (description.endsWith(" OUT")) {
			return "off";
		} else if (description.endsWith(" OPR")) {
			return "on";
		} else if (description.endsWith(" MAIN")) {
			return "on";
		} else if (description.endsWith(" NORM")) {
			return "on";
		} else if (description.endsWith(" DOWN")) {
			return "down";
		} else if (description.endsWith(" Down")) {
			return "down";
		} else if (description.endsWith(" DN")) {
			return "down";
		} else if (description.endsWith(" DECR")) {
			return "decrease";
		} else if (description.endsWith(" Decr")) {
			return "decrease";
		} else if (description.endsWith(" Decr.")) {
			return "decrease";
		} else if (description.endsWith(" Decrease")) {
			return "decrease";
		} else if (description.endsWith(" UP")) {
			return "up";
		} else if (description.endsWith(" Up")) {
			return "up";
		} else if (description.contains(" INCR")) {
			return "up";
		} else if (description.endsWith(" Incr")) {
			return "increase";
		} else if (description.endsWith(" Incr.")) {
			return "increase";
		} else if (description.endsWith(" Increase")) {
			return "increase";
		} else if (description.endsWith(" Left")) {
			return "left";
		} else if (description.endsWith(" L")) {
			return "left";
		} else if (description.endsWith(" R")) {
			return "right";
		} else if (description.endsWith(" Right")) {
			return "right";
		} else {
			return "none";
		}
	}

	private void writeObject(File file, Object object) throws IOException {
		var objectMapper = new ObjectMapper();
		objectMapper.setVisibility(FIELD, ANY);
		JsonGenerator jsonGenerator = new JsonFactoryBuilder() //
				.build() //
				.createGenerator(file, UTF8) //
				.setCodec(objectMapper) //
				.useDefaultPrettyPrinter();
		jsonGenerator.writeObject(object);
	}

}