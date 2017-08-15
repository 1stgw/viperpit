package de.viperpit.generator

import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import de.viperpit.annotations.json.Jsonized
import java.io.File
import java.util.Map

@Jsonized('{
	"name": "",
	"source": "",
	"action": [
		{
			"id": "",
			"clazz": "",
			"callback": "",
			"relatedActions": [""],
			"description": "",
			"category": "",
			"section": "",
			"group": "",
			"style": "",
			"role": "",
			"type": "",
			"state" : {
				"ramp": false,
				"ground": false,
				"air": false
			}
		}
	]
}')
class Configuration {

	var Map<String, Action> map = null

	new() {
	}

	new(String path) {
		val file = new File(path)
		val reader = Files.newReader(file, Charsets.UTF_8)
		try {
			val rootElement = new JsonParser().parse(reader)
			delegate = rootElement as JsonObject
		} finally {
			reader?.close
		}
	}

	def getAction(String it) {
		if (map === null) {
			map = actions.toMap[callback]
		}
		return map.get(it)
	}

	def getRelatedActions(Action it) {
		relatedActions.map[actions].filterNull
	}
}
