package de.viperpit.generator

import com.google.common.collect.Lists
import java.io.File
import org.slf4j.LoggerFactory

import static com.google.common.base.Charsets.UTF_8
import static de.viperpit.generator.GeneratorUtils.write

class LayoutGenerator {

	static val LOGGER = LoggerFactory.getLogger(LayoutGenerator)

	def run(File metadataPath) throws Exception {
		LOGGER.info("Running the Generator.")
		val cockpit = new Cockpit('''«metadataPath.absolutePath»/cockpit.json''')
		if (cockpit !== null) {
			LOGGER.info("Found Cockpit file and loading configuration entries.")
			generateLayout(metadataPath, cockpit)
			LOGGER.info("Generator has finished successfully.")
		} else {
			LOGGER.error("Key file could not be loaded")
		}
	}

	private def generateLayout(File path, Cockpit cockpit) {
		val layout = new Layout
		layout.consoleRowSets = cockpit.consoles.map [
			val consoleRowSet = new ConsoleRowSet
			consoleRowSet.console = id
			consoleRowSet.consoleRows = Lists.partition(panels, 2).map [ panels |
				val consoleRow = new ConsoleRow
				consoleRow.panelRowSets = panels.map [
					val panelRowSet = new PanelRowSet
					panelRowSet.panel = id
					panelRowSet.panelRows = Lists.partition(groups, 2).map [ groups |
						val panelRow = new PanelRow
						panelRow.groups = groups.map[id].toList
						panelRow
					]
					panelRowSet
				].toList
				consoleRow
			]
			consoleRowSet
		].toList
		write(layout.toString, new File(path, '''layout.json'''.toString), UTF_8)
	}

}
