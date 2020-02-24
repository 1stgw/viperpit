package de.viperpit.generator

import com.google.common.io.Files
import java.io.File
import java.nio.charset.Charset

class GeneratorUtils {

	static def write(CharSequence charSequence, File file, Charset charset) {
		Files.asCharSink(file, charset).write(charSequence)
	}

}
