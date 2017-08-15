package de.viperpit.generator

import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import de.viperpit.annotations.json.Jsonized
import java.io.File

@Jsonized('{
	"consoleRowSet": [
		{
			"console": "",
			"consoleRow": [
				{
					"panelRowSet": [
						{
							"panel": "",
							"panelRow": [
								{
									"group": [""]
								}
							]
						}
					]
				}
			]
		}
	]
}')
class Layout {
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
}
