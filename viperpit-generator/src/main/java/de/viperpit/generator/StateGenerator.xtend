package de.viperpit.generator

import de.viperpit.agent.keys.KeyFile
import de.viperpit.agent.keys.KeyFile.KeyCodeLine
import java.io.File
import java.util.ArrayList
import org.slf4j.LoggerFactory

import static com.google.common.base.CharMatcher.JAVA_LETTER_OR_DIGIT
import static com.google.common.base.CharMatcher.WHITESPACE
import static com.google.common.base.Charsets.UTF_8
import static com.google.common.base.Splitter.on
import static com.google.common.base.Strings.commonPrefix
import static com.google.common.io.Files.write

class StateGenerator {

	static val LOGGER = LoggerFactory.getLogger(StateGenerator)

	def run(File metadataPath) throws Exception {
		val file = new File('''«metadataPath.absolutePath»/full.key''')
		if (file !== null && file.exists) {
			LOGGER.info("Found key file and loading key file entries.")
			val keyFile = new KeyFile(file)
			LOGGER.info("Running the Generator.")
			generateRoles(metadataPath, keyFile)
			generateStates(metadataPath, keyFile)
			LOGGER.info("Generator has finished successfully.")
		} else {
			LOGGER.error("Key files could not be loaded")
		}
	}

	private def generateRoles(File path, KeyFile keyFile) {
		val keyCodeLines = keyFile.keyCodeLines
		write('''
			«FOR it : keyCodeLines.values»
				«callback»=«toRole»
			«ENDFOR»
		''', new File(path, '''role.properties'''.toString), UTF_8)
	}

	private def generateStates(File path, KeyFile keyFile) {
		val keyCodeLines = keyFile.keyCodeLines
		write('''
			«FOR it : keyCodeLines.values.filter[
				val style = toStyle(it, keyCodeLines.values)
				style == "switch" || style == "knob"
			]»
				«val role = toRole»
				«IF role == "on"»
					«callback»=false,true,true
				«ELSEIF role == "off"»
					«callback»=true,false,false
				«ELSE»
					«callback»=false,false,false
				«ENDIF»
			«ENDFOR»
		''', new File(path, '''state.properties'''.toString), UTF_8)
	}

	private def toRole(KeyCodeLine it) {
		switch (description) {
			case description === null: "none"
			case description.endsWith(" ON"): "on"
			case description.endsWith(" On"): "on"
			case description.endsWith(" OFF"): "off"
			case description.endsWith(" Off"): "off"
			case description.endsWith(" ENABLE"): "on"
			case description.endsWith(" DISABLE"): "off"
			case description.endsWith(" OPEN"): "on"
			case description.endsWith(" CLOSE"): "off"
			case description.endsWith(" OPR"): "on"
			case description.endsWith(" MAIN"): "on"
			case description.endsWith(" NORM"): "on"
			case description.endsWith(" UP"): "up"
			case description.endsWith(" Up"): "up"
			case description.endsWith(" DOWN"): "down"
			case description.endsWith(" Down"): "down"
			case description.endsWith(" DN"): "down"
			case description.contains(" INCR"): "up"
			case description.endsWith(" Incr."): "up"
			case description.endsWith(" Increase"): "up"
			case description.endsWith(" DECR"): "down"
			case description.endsWith(" Decr."): "down"
			case description.endsWith(" Decrease"): "down"
			case description.endsWith(" Left"): "left"
			case description.endsWith(" L"): "left"
			case description.endsWith(" R"): "right"
			case description.endsWith(" Right"): "right"
			default: "none"
		}
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

	private def toPathName(String category) {
		val tokens = new ArrayList(on(WHITESPACE).trimResults.splitToList(category))
		JAVA_LETTER_OR_DIGIT.retainFrom('''«tokens.map[toLowerCase].join»'''.toString)
	}

	private def toStyle(KeyCodeLine it, Iterable<KeyCodeLine> keyCodeLines) {
		val groupAndLabel = getGroupAndLabel(keyCodeLines)
		val group = groupAndLabel.key
		val label = groupAndLabel.value
		val role = toRole
		val relatedCallbacks = toRelated(groupAndLabel, keyCodeLines).map[description.toPathName].toList
		return switch (group) {
			case label !== null && label.equals("Push"): "button"
			case label !== null && label.equals("Hold"): "button"
			case group.endsWith("Button"): "button"
			case group.contains("Switch") && label !== null && label.startsWith("Cycle"): "button"
			case group.contains("Switch") && label !== null && label.startsWith("Toggle"): "button"
			case group.contains("Switch") && label !== null && label.startsWith("Tog."): "button"
			case group.contains("Switch") && label !== null && label.startsWith("Step"): "button"
			case group.contains("Switch") && relatedCallbacks.empty: "button"
			case group.contains("Switch"): "switch"
			case group.contains("Knob") && #{"up", "down", "left", "right"}.contains(role) : "button"
			case group.contains("Knob"): "knob"
			case group.contains("Handle") && label !== null && label.startsWith("Toggle"): "button"
			case group.endsWith("Handle"): "handle"
			case group.contains("Wheel"): "wheel"
			case group.endsWith("Rotary"): "rotary"
			case group.endsWith("Rocker"): "rocker"
			default: "button"
		}
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

}
