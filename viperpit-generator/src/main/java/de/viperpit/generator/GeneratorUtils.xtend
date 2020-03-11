package de.viperpit.generator

import com.google.common.io.Files
import java.io.File
import java.io.FileReader
import java.nio.charset.Charset
import java.util.Properties
import org.slf4j.LoggerFactory

class GeneratorUtils {

	static val LOGGER = LoggerFactory.getLogger(GeneratorUtils)

	static def (String)=>boolean createFilter(File metadataPath) {
		var filter = [String it|true]
		val filterFile = new File('''«metadataPath.absolutePath»/filter.properties''')
		if (filterFile.exists) {
			LOGGER.info("Loading filter file.")
			val properties = new Properties
			properties.load(new FileReader(filterFile))
			filter = [String it|!properties.containsKey(it)]
		}
		return filter
	}

	static def write(CharSequence charSequence, File file, Charset charset) {
		Files.asCharSink(file, charset).write(charSequence)
	}

}
