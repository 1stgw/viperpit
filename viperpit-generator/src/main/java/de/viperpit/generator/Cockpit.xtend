package de.viperpit.generator

import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.gson.JsonObject
import de.viperpit.annotations.json.Jsonized
import java.io.File
import java.util.LinkedHashSet
import java.util.Map

import static com.google.gson.JsonParser.parseReader

@Jsonized('{
	"console": [
		{
			"id": "",
			"class": "",
			"name": "",
			"panel": [
				{
					"id": "",
					"class": "",
					"name": "",
					"group": 
					[
						{
							"id": "",
							"class": "",
							"description": "",
							"label": "",
							"type": "",
							"control": 
							[
								{
									"id": "",
									"clazz": "",
									"callback": "",
									"description": "",
									"label": "",
									"role": ""
								}
							]
						}
					]
				}
			]
		}
	]
}')
class Cockpit {

	var Map<String, Console> consolesMap = null

	var Map<String, Panel> panelsMap = null

	var Map<String, Group> groupsMap = null

	new() {
	}

	new(String path) {
		val file = new File(path)
		val reader = Files.newReader(file, Charsets.UTF_8)
		try {
			val rootElement = parseReader(reader)
			delegate = rootElement as JsonObject
		} finally {
			reader?.close
		}
	}

	def getConsole(String it) {
		if (consolesMap === null) {
			consolesMap = consoles.toMap[id]
		}
		return consolesMap.get(it)
	}

	def Iterable<Control> getControls() {
		val result = newLinkedHashSet
		groups.forEach [ group |
			result += group.controls
		]
		result.toList
	}

	def getGroup(String it) {
		if (groupsMap === null) {
			groupsMap = groups.toMap[id]
		}
		return groupsMap.get(it)
	}

	def Iterable<Group> getGroups() {
		val result = newLinkedHashSet
		panels.forEach [ panel |
			result += panel.groups
		]
		result.toList
	}

	def getPanel(String it) {
		if (panelsMap === null) {
			panelsMap = panels.toMap[id]
		}
		return panelsMap.get(it)
	}

	def Iterable<Panel> getPanels() {
		val result = newLinkedHashSet
		consoles.forEach [ console |
			result += console.panels
		]
		result.toList
	}

	def Iterable<String> getRoles() {
		new LinkedHashSet(controls.map[role].toList.sort)
	}

	def Iterable<String> getTypes() {
		new LinkedHashSet(groups.map[type].toList.sort)
	}

}
