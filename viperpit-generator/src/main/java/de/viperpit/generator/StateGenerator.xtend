package de.viperpit.generator

import de.viperpit.agent.keys.KeyFile
import de.viperpit.agent.keys.KeyFile.KeyCodeLine
import java.io.File
import java.util.ArrayList
import java.util.Set
import org.slf4j.LoggerFactory

import static com.google.common.base.CharMatcher.javaLetterOrDigit
import static com.google.common.base.CharMatcher.whitespace
import static com.google.common.base.Charsets.UTF_8
import static com.google.common.base.Splitter.on
import static com.google.common.base.Strings.commonPrefix
import static de.viperpit.generator.GeneratorUtils.createFilter
import static de.viperpit.generator.GeneratorUtils.write

class StateGenerator {

	static val LOGGER = LoggerFactory.getLogger(StateGenerator)

	static final Set<String> ON_AT_RAMP = #{
		"SimAuxComBackup",
		"SimTACANAATR",
		"SimLEFAuto",
		"SimTrimAPNORSimMasterFuelOnM",
		"SimLightsSteady",
		"AFCanopyOpen",
		"SimSeatOff"
	}

	static final Set<String> OFF_AT_RAMP = #{
		"SimMasterFuelOff",
		"SimBupUhfBoth",
		"AFCanopyClose",
		"SimSeatOn",
		"SimEWSModeStby",
		"SimINSNav"
	}

	static final Set<String> ALWAYS_ON = #{
		"SimAltFlapsNorm",
		"SimTrimAPNORM",
		"SimMasterFuelOn",
		"SimFuelDoorClose",
		"SimEpuAuto",
		"SimAVTRSwitchOff",
		"SimJfsStart_Off",
		"SimEngContPri",
		"SimAud1Com1Sql",
		"SimAud1Com2Sql",
		"SimBupUhfPreset",
		"SimEwsJettOff",
		"SimEWSProgOne",
		"SimHookUp",
		"SimGndJettOff",
		"SimParkingBrakeOff",
		"SimCATIII",
		"SimLandingLightOff",
		"SimRFNorm",
		"SimLaserArmOff",
		"SimSafeMasterArm",
		"SimRightAPMid",
		"SimLeftAPMid",
		"SimDriftCOOff",
		"SimHSINav",
		"SimFuelSwitchNorm",
		"SimFuelTransNorm",
		"SimScalesVAH",
		"SimRALTOFF",
		"SimPitchLadderATTFPM",
		"SimHUDDEDOff",
		"SimReticleOff",
		"SimHUDVelocityCAS",
		"SimHUDAltAuto",
		"SimHUDBrtDay",
		"SimInteriorLight",
		"SimInstrumentLight",
		"SimVMSOn"
	}

	static final Set<String> ALWAYS_OFF = #{
		"SimMasterFuelOff",
		"SimFuelDoorOpen",
		"SimEpuOn",
		"SimEpuOff",
		"SimAVTRSwitchOn",
		"SimBupUhfMain",
		"SimEwsJettOn",
		"SimGndJettOn",
		"SimParkingBrakeOn",
		"SimArmMasterArm",
		"SimDriftCOOn",
		"SimRALTON",
		"SimScalesOff",
		"SimPitchLadderOff",
		"SimINSNorm"
	}

	def run(File metadataPath) throws Exception {
		val file = new File('''«metadataPath.absolutePath»/full.key''')
		if (file !== null && file.exists) {
			LOGGER.info("Found key file and loading key file entries.")
			val keyFile = new KeyFile(file, UTF_8)
			LOGGER.info("Running the Generator.")
			val filter = createFilter(metadataPath)
			generateRoles(metadataPath, keyFile, filter)
			generateStates(metadataPath, keyFile, filter)
			LOGGER.info("Generator has finished successfully.")
		} else {
			LOGGER.error("Key files could not be loaded")
		}
	}

	private def generateRoles(File path, KeyFile keyFile, (String)=>boolean filter) {
		val keyCodeLines = keyFile.keyCodeLines.filter [
			filter.apply($1.callback)
		]
		write('''
			«FOR it : keyCodeLines.values»
				«callback»=«toRole»
			«ENDFOR»
		''', new File(path, '''role.properties'''.toString), UTF_8)
	}

	private def generateStates(File path, KeyFile keyFile, (String)=>boolean filter) {
		val keyCodeLines = keyFile.keyCodeLines.filter [
			filter.apply($1.callback)
		]
		write('''
			«FOR it : keyCodeLines.values.filter[
				val style = toStyle(it, keyCodeLines.values)
				style == "switch" || style == "knob"
			]»
				«val role = toRole»
				«IF ALWAYS_ON.contains(callback)»
					«callback»=true,true,true
				«ELSEIF ALWAYS_OFF.contains(callback)»
					«callback»=false,false,false
				«ELSEIF ON_AT_RAMP.contains(callback)»
					«callback»=true,false,false
				«ELSEIF OFF_AT_RAMP.contains(callback)»
					«callback»=false,true,true
				«ELSEIF role == "off"»
					«callback»=true,false,false
				«ELSEIF role == "on"»
					«callback»=false,true,true
				«ELSE»
					«callback»=false,false,false
				«ENDIF»
			«ENDFOR»
		''', new File(path, '''state.properties'''.toString), UTF_8)
	}

	private def toRole(KeyCodeLine it) {
		switch (description) {
			case description === null: "none"
			case description.endsWith(" IFF OUT"): "none"
			case description.endsWith(" IFF IN"): "none"
			case description.endsWith(" ON"): "on"
			case description.endsWith(" On"): "on"
			case description.endsWith(" OFF"): "off"
			case description.endsWith(" Off"): "off"
			case description.endsWith(" ENABLE"): "on"
			case description.endsWith(" DISABLE"): "off"
			case description.endsWith(" OPEN"): "on"
			case description.endsWith(" CLOSE"): "off"
			case description.endsWith(" OUT"): "off"
			case description.endsWith(" OPR"): "on"
			case description.endsWith(" MAIN"): "on"
			case description.endsWith(" NORM"): "on"
			case description.endsWith(" DOWN"): "down"
			case description.endsWith(" Down"): "down"
			case description.endsWith(" DN"): "down"
			case description.endsWith(" DECR"): "down"
			case description.endsWith(" Decr"): "down"
			case description.endsWith(" Decr."): "down"
			case description.endsWith(" Decrease"): "down"
			case description.endsWith(" UP"): "up"
			case description.endsWith(" Up"): "up"
			case description.contains(" INCR"): "up"
			case description.endsWith(" Incr"): "up"
			case description.endsWith(" Incr."): "up"
			case description.endsWith(" Increase"): "up"
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
			callback != other.callback && commonPrefix(description, other.description).length >= groupAndLabel.key.length
		]
	}

	private def toPathName(String category) {
		val tokens = new ArrayList(on(whitespace).trimResults.splitToList(category))
		javaLetterOrDigit.retainFrom('''«tokens.map[toLowerCase].join»'''.toString)
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
			case group.contains("Knob") && #{"up", "down", "left", "right"}.contains(role): "button"
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
