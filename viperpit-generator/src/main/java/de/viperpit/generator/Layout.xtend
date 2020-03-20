package de.viperpit.generator

import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.gson.JsonObject
import de.viperpit.annotations.json.Jsonized
import java.io.File

import static com.google.gson.JsonParser.parseReader

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
			val rootElement = parseReader(reader)
			delegate = rootElement as JsonObject
		} finally {
			reader?.close
		}
	}
}
