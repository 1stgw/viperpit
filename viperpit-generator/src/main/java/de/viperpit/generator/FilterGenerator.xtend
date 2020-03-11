package de.viperpit.generator

import de.viperpit.agent.keys.KeyFile
import java.io.File
import java.util.HashSet
import org.slf4j.LoggerFactory

import static com.google.common.base.Charsets.UTF_8
import static de.viperpit.generator.GeneratorUtils.write

class FilterGenerator {

	static val LOGGER = LoggerFactory.getLogger(FilterGenerator)

	def run(File metadataPath) throws Exception {
		val fileWithAllCallbacks = new File('''«metadataPath.absolutePath»/full.key''')
		val fileWithCockpitCallbacks = new File('''«metadataPath.absolutePath»/pitbuilder.key''')
		if (fileWithAllCallbacks !== null && fileWithAllCallbacks.exists && fileWithCockpitCallbacks !== null && fileWithCockpitCallbacks.exists) {
			LOGGER.info("Found key files and loading key file entries.")
			val keyFileWithAllCallbacks = new KeyFile(fileWithAllCallbacks, UTF_8)
			val keyFileWithCockpitCallbacks = new KeyFile(fileWithCockpitCallbacks, UTF_8)
			LOGGER.info("Running the Generator.")
			generateFilter(metadataPath, keyFileWithAllCallbacks, keyFileWithCockpitCallbacks)
			LOGGER.info("Generator has finished successfully.")
		} else {
			LOGGER.error("Key files could not be loaded")
		}
	}

	private def generateFilter(File path, KeyFile keyFileWithAllCallbacks, KeyFile keyFileWithCockpitCallbacks) {
		val keyCodeLinesWithAllCallbacks = keyFileWithAllCallbacks.keyCodeLines
		val keyCodeLinesWithCockpitCallbacks = keyFileWithCockpitCallbacks.keyCodeLines
		val overlappingKeys = new HashSet(keyCodeLinesWithAllCallbacks.keySet)
		overlappingKeys.removeAll(keyCodeLinesWithCockpitCallbacks.keySet)
		write('''
			# These keys are not relevant for a cockpit
			«FOR it : overlappingKeys.sort»
				«it»=no_cockpit
			«ENDFOR»
			
			# These keys have no key binding
			«FOR it : keyCodeLinesWithCockpitCallbacks.values.filter[!hasKey].sortBy[callback]»
				«callback»=no_binding
			«ENDFOR»
			
			# These keys are on the Stick
			«FOR it : keyCodeLinesWithAllCallbacks.values.filter[section == "FLIGHT STICK"].sortBy[callback]»
				«callback»=stick
			«ENDFOR»
			
			# These keys are on the Throttle
			«FOR it : keyCodeLinesWithAllCallbacks.values.filter[section == "THROTTLE QUADRANT SYSTEM"].sortBy[callback]»
				«callback»=throttle
			«ENDFOR»
			
			# These keys are on the Left MFD
			«FOR it : keyCodeLinesWithAllCallbacks.values.filter[section == "LEFT MFD"].sortBy[callback]»
				«callback»=mfd
			«ENDFOR»
			
			# These keys are on the Right MFD
			«FOR it : keyCodeLinesWithAllCallbacks.values.filter[section == "RIGHT MFD"].sortBy[callback]»
				«callback»=mfd
			«ENDFOR»
			
			# These keys are on the ICP
			«FOR it : keyCodeLinesWithAllCallbacks.values.filter[section == "ICP"].sortBy[callback]»
				«callback»=icp
			«ENDFOR»
			
			# These keys are Toggle keys and only meant for convenience purposes
			«FOR it : keyCodeLinesWithAllCallbacks.values.filter[description.endsWith(" - Toggle")].sortBy[callback]»
				«callback»=toggle
			«ENDFOR»
		''', new File(path, '''filter.properties'''.toString), UTF_8)
	}

}
