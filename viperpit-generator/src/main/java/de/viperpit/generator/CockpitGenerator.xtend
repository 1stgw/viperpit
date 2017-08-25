package de.viperpit.generator

import com.google.common.base.CharMatcher
import java.io.File
import java.io.FileReader
import java.util.ArrayList
import java.util.LinkedHashSet
import java.util.Properties
import java.util.function.Predicate
import org.eclipse.xtend.lib.annotations.Data
import org.slf4j.LoggerFactory

import static com.google.common.base.CharMatcher.JAVA_LETTER_OR_DIGIT
import static com.google.common.base.CharMatcher.WHITESPACE
import static com.google.common.base.Charsets.UTF_8
import static com.google.common.base.Splitter.on
import static com.google.common.io.Files.write

class CockpitGenerator {

	@Data private static class GroupDef {
		String name
		String description
		String label
		String category
		String section
		String type
		Iterable<Action> actions
	}

	static val LOGGER = LoggerFactory.getLogger(CockpitGenerator)

	def run(File metadataPath) throws Exception {
		LOGGER.info("Running the Generator.")
		val configuration = new Configuration('''«metadataPath.absolutePath»/configuration.json''')
		if (configuration !== null) {
			LOGGER.info("Found configuration file and loading configuration entries.")
			var filter = [String it|true]
			val filterFile = new File('''«metadataPath.absolutePath»/filter.properties''')
			if (filterFile.exists) {
				LOGGER.info("Loading filter file.")
				val properties = new Properties
				properties.load(new FileReader(filterFile))
				filter = [String it|!properties.containsKey(it)]
			}
			generateCockpit(metadataPath, filter, configuration)
			LOGGER.info("Generator has finished successfully.")
		} else {
			LOGGER.error("Key file could not be loaded")
		}
	}

	private def generateCockpit(File path, Predicate<String> filter, Configuration it) {
		val groups = toGroups(filter)
		val categories = new LinkedHashSet(groups.map[category].toList.reverseView)
		val groupedBySection = groups.groupBy[section]
		val sections = [ String category |
			new LinkedHashSet(groups.filter[it.category == category].map[section].toList)
		]
		val cockpit = new Cockpit
		cockpit.consoles = categories.map [
			val console = new Console
			console.id = toPathName
			console.clazz = toClassName
			console.name = toName
			console.panels = sections.apply(it).map [
				val panel = new Panel
				panel.id = toPathName
				panel.clazz = toClassName
				panel.name = it
				panel.groups = groupedBySection.get(it).map [
					val groupDefinition = it
					val group = new Group
					group.id = name
					group.clazz = name.toClassName
					group.description = description
					if (actions.size > 1) {
						group.label = label
					}
					group.type = type
					group.controls = actions.map [
						val control = new Control
						control.id = id
						control.clazz = clazz
						control.callback = callback
						control.description = description
						if (groupDefinition.actions.size > 1) {
							control.label = label
						} else {
							control.label = groupDefinition.label
						}
						control.role = role
						control
					].toList
					group
				]
				panel
			].toList
			console
		].toList
		write(cockpit.toString, new File(path, '''cockpit.json'''.toString), UTF_8)
	}

	private def getLabel(Action it) {
		var lastIndexToken = '-'
		if (description.lastIndexOf(lastIndexToken) < 0) {
			lastIndexToken = ':'
		}
		description.substring(description.lastIndexOf(lastIndexToken) + 1, description.length).trim
	}

	private def toGroups(Configuration configuration, Predicate<String> filter) {
		val key = [ String it |
			JAVA_LETTER_OR_DIGIT.or(CharMatcher.anyOf("_.")).retainFrom(on(WHITESPACE).trimResults.split(it).map [
				toLowerCase.toFirstUpper
			].join('')).toFirstLower
		]
		val groups = newLinkedHashMap
		configuration.actions.filter[filter.test(callback)].groupBy[group].forEach [ name, actions |
			val suffixes = #{"Button", "Switch", "Knob", "Handle", "Wheel", "Rotary", "Rocker"}
			val extension action = actions.head
			var firstIndexToken = ': '
			if (group.indexOf(firstIndexToken) < 0) {
				firstIndexToken = '-'
			}
			val firstIndex = group.indexOf(firstIndexToken)

			val lastIndexToken = suffixes.findFirst[group.endsWith(it)]
			val lastIndex = if(lastIndexToken === null) group.length else group.lastIndexOf(lastIndexToken)

			val label = group.substring(firstIndex + 1, lastIndex).trim
			val group = new GroupDef(name, description, label, category, section, type, actions)
			groups.put(key.apply(name), group)
		]
		return groups.values.toList
	}

	private def toClassName(String it) {
		var name = it
		name = CharMatcher.is('.').removeFrom(name)
		name = CharMatcher.is('_').replaceFrom(name, 'z')
		val tokens = new ArrayList(on(JAVA_LETTER_OR_DIGIT.negate).trimResults.splitToList(name))
		'''«tokens.map[toLowerCase.toFirstUpper].join»'''.toString
	}

	private def toName(String category) {
		val tokens = new ArrayList(on(WHITESPACE).trimResults.splitToList(category))
		tokens.map[toLowerCase.toFirstUpper].join(' ')
	}

	private def toPathName(String category) {
		val tokens = new ArrayList(on(WHITESPACE).trimResults.splitToList(category))
		JAVA_LETTER_OR_DIGIT.retainFrom('''«tokens.map[toLowerCase].join»'''.toString)
	}

}
