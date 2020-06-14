package de.viperpit.generator;

import static com.google.common.base.CharMatcher.javaLowerCase;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Multimaps.index;
import static com.google.common.collect.Sets.newHashSet;
import static de.viperpit.generator.JsonFileWriter.writeObject;
import static de.viperpit.generator.KeyCodeLineNames.toCapitalizedName;
import static de.viperpit.generator.KeyCodeLineNames.toGroupAndLabel;
import static de.viperpit.generator.KeyCodeLineNames.toId;
import static de.viperpit.generator.KeyCodeLineNames.toLabel;
import static de.viperpit.generator.KeyCodeLineNames.toName;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import de.viperpit.agent.keys.KeyFile.KeyCodeLine;

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

	@SuppressWarnings("deprecation")
	public CockpitConfiguration run( //
			File target, //
			Collection<KeyCodeLine> keyCodeLines, //
			RoleConfigurations roleConfigurations, //
			DefaultStateConfigurations defaultStateConfigurations, //
			String cockpitId, //
			String cockpitLabel) throws Exception {
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
					var switchStyles = newArrayList("switch", "handle");
					var type = "button";
					if (switchStyles.contains(style) && !roleConfiguration.hasRelatedCallbacks()) {
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
							defaultStateConfigurations.isStateful(keyCodeLine.getCallback()) //
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
		writeObject(new File(target, "configuration_" + cockpitId + ".json"), cockpitConfiguration);
		return cockpitConfiguration;
	}

}