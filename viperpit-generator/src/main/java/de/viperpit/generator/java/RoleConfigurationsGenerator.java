package de.viperpit.generator.java;

import static de.viperpit.generator.java.KeyCodeLineNames.toGroupAndLabel;
import static de.viperpit.generator.java.KeyCodeLineNames.toId;
import static de.viperpit.generator.java.KeyCodeLineNames.toRelated;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.slf4j.Logger;

import de.viperpit.agent.keys.KeyFile.KeyCodeLine;

public class RoleConfigurationsGenerator {

	private static final Logger LOGGER = getLogger(RoleConfigurationsGenerator.class);

	public RoleConfigurations run( //
			File metadataPath, //
			Collection<KeyCodeLine> keyCodeLines, //
			FilterConfigurations filterConfigurations) throws Exception {
		LOGGER.info("Generating roles.");
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
					relatedCallbacks.isEmpty() ? null : relatedCallbacks //
			));
		});
		return new RoleConfigurations(collection);
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

}