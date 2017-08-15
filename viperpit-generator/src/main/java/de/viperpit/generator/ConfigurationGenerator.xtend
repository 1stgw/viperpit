package de.viperpit.generator

import com.google.common.base.CharMatcher
import de.viperpit.agent.keys.KeyFile
import de.viperpit.agent.keys.KeyFile.KeyCodeLine
import java.io.File
import java.io.FileReader
import java.util.ArrayList
import java.util.Map
import java.util.Properties
import org.slf4j.LoggerFactory

import static com.google.common.base.CharMatcher.JAVA_LETTER_OR_DIGIT
import static com.google.common.base.CharMatcher.JAVA_LOWER_CASE
import static com.google.common.base.CharMatcher.WHITESPACE
import static com.google.common.base.Charsets.UTF_8
import static com.google.common.base.Optional.fromNullable
import static com.google.common.base.Splitter.on
import static com.google.common.base.Strings.commonPrefix
import static com.google.common.io.Files.write

class ConfigurationGenerator {

	static val LOGGER = LoggerFactory.getLogger(ConfigurationGenerator)

	def run(File metadataPath) throws Exception {
		val keyFile = new File('''«metadataPath.absolutePath»/full.key''')
		if (keyFile !== null && keyFile.exists) {
			val roles = newHashMap
			val roleFile = new File('''«metadataPath.absolutePath»/role.properties''')
			if (roleFile.exists) {
				LOGGER.info("Loading role file.")
				val properties = new Properties
				properties.load(new FileReader(roleFile))
				properties.forEach [
					roles.put($0.toString, $1.toString)
				]
			}
			val states = newHashMap
			val stateFile = new File('''«metadataPath.absolutePath»/state.properties''')
			if (stateFile.exists) {
				LOGGER.info("Loading state file.")
				val properties = new Properties
				properties.load(new FileReader(stateFile))
				properties.forEach [
					val triState = on(',').trimResults.split($1.toString)
					states.put($0.toString -> "ramp", Boolean.valueOf(triState.get(0)))
					states.put($0.toString -> "ground", Boolean.valueOf(triState.get(1)))
					states.put($0.toString -> "air", Boolean.valueOf(triState.get(2)))
				]
			}
			LOGGER.info("Found key file and loading key file entries.")
			val keyCodeLines = new KeyFile(keyFile).keyCodeLines
			LOGGER.info("Running the Generator.")
			generateConfiguration(metadataPath, roles, states, keyCodeLines.values)
			LOGGER.info("Generator has finished successfully.")
		} else {
			LOGGER.error("Key file could not be loaded")
		}
	}

	private def generateConfiguration(File path, Map<String, String> roles, Map<Pair<String, String>, Boolean> states,
		Iterable<KeyCodeLine> keyCodeLines) {
		val actions = keyCodeLines.map [
			val groupAndLabel = getGroupAndLabel(keyCodeLines)
			val group = groupAndLabel.key
			val label = groupAndLabel.value
			val relatedCallbacks = toRelated(groupAndLabel, keyCodeLines).map[description.toPathName].toList
			val style = switch (group) {
				case label !== null && label.equals("Push"): "button"
				case label !== null && label.equals("Hold"): "button"
				case group.endsWith("Button"): "button"
				case group.contains("Switch") && label !== null && label.startsWith("Cycle"): "button"
				case group.contains("Switch") && label !== null && label.startsWith("Toggle"): "button"
				case group.contains("Switch") && label !== null && label.startsWith("Tog."): "button"
				case group.contains("Switch") && label !== null && label.startsWith("Step"): "button"
				case group.contains("Switch"): "switch"
				case group.contains("Knob"): "knob"
				case group.contains("Handle") && label !== null && label.startsWith("Toggle"): "button"
				case group.endsWith("Handle"): "handle"
				case group.contains("Wheel"): "wheel"
				case group.endsWith("Rotary"): "rotary"
				case group.endsWith("Rocker"): "rocker"
				default: "button"
			}
			val role = roles.get(callback)
			val switchStyles = #["switch", "handle"]
			val type = switch (style) {
				case switchStyles.contains(style) && relatedCallbacks.empty:
					"button"
				case style == "knob" && JAVA_LOWER_CASE.matchesNoneOf(label) && role != "left" && role != "right":
					"switch"
				case style == "knob":
					"button"
				case switchStyles.contains(style):
					"switch"
				default:
					"button"
			}
			val action = new Action
			action.id = description.toPathName
			action.clazz = description.toClassName
			action.callback = callback
			if (!relatedCallbacks.empty) {
				action.relatedActions = relatedCallbacks
			}
			action.description = description
			action.category = category
			action.section = section
			action.group = group
			action.style = style
			if (role !== null) {
				action.role = role
			}
			action.type = type
			if (type == "switch") {
				val state = new State
				state.ramp = fromNullable(states.get(callback -> "ramp")).or(role == "off")
				state.ground = fromNullable(states.get(callback -> "ground")).or(role == "on")
				state.air = fromNullable(states.get(callback -> "air")).or(role == "on")
				action.state = state
			}
			action
		]
		val configuration = new Configuration
		configuration.actions = actions.toList
		write(configuration.toString, new File(path, '''configuration.json'''.toString), UTF_8)
	}

	private def getGroupAndLabel(KeyCodeLine it, Iterable<KeyCodeLine> keyCodeLines) {
		val separator = ' - '
		val lastIndex = description.lastIndexOf(separator)
		if (lastIndex !== -1) {
			val group = description.substring(0, lastIndex).trim
			val label = description.substring(lastIndex + separator.length, description.length).trim
			return group -> label
		}
		return description -> null
	}

	private def toClassName(String it) {
		var name = it
		name = CharMatcher.is('.').removeFrom(name)
		name = CharMatcher.is('_').replaceFrom(name, 'z')
		val tokens = new ArrayList(on(JAVA_LETTER_OR_DIGIT.negate).trimResults.splitToList(name))
		'''«tokens.map[toLowerCase.toFirstUpper].join»'''.toString
	}

	private def toPathName(String category) {
		val tokens = new ArrayList(on(WHITESPACE).trimResults.splitToList(category))
		JAVA_LETTER_OR_DIGIT.retainFrom('''«tokens.map[toLowerCase].join»'''.toString)
	}

	private def toRelated(KeyCodeLine it, Pair<String, String> groupAndLabel, Iterable<KeyCodeLine> keyCodeLines) {
		if (groupAndLabel.value === null) {
			return emptyList
		}
		return keyCodeLines.filter [ other |
			callback != other.callback &&
				commonPrefix(description, other.description).length >= groupAndLabel.key.length
		]
	}

}
