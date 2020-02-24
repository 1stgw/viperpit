package de.viperpit.agent.keys

import java.io.File
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend.lib.annotations.ToString

import static com.google.common.base.CharMatcher.is
import static com.google.common.base.CharMatcher.javaDigit
import static com.google.common.base.CharMatcher.whitespace
import static com.google.common.base.Preconditions.checkArgument
import static com.google.common.base.Preconditions.checkNotNull
import static com.google.common.base.Splitter.on
import static com.google.common.collect.Lists.newArrayList
import static java.nio.charset.StandardCharsets.ISO_8859_1
import static java.nio.file.Files.readAllLines

import static extension java.lang.Integer.parseInt
import static extension java.lang.Integer.valueOf

class KeyFile {

	@FinalFieldsConstructor @EqualsHashCode @ToString static class KeyCodeLine {
		@Accessors(PUBLIC_GETTER) val String category
		@Accessors(PUBLIC_GETTER) val String section
		@Accessors(PUBLIC_GETTER) val String callback
		@Accessors(PUBLIC_GETTER) val int sound
		@Accessors(PUBLIC_GETTER) val int key
		@Accessors(PUBLIC_GETTER) val int modifiers
		@Accessors(PUBLIC_GETTER) val int keyCombinationKey
		@Accessors(PUBLIC_GETTER) val int keyCombinationModifiers
		@Accessors(PUBLIC_GETTER) val String description

		def hasKey() {
			key !== -1
		}

		def hasKeyCombinations() {
			keyCombinationKey !== 0
		}

		def hasKeyCombinationModifiers() {
			keyCombinationModifiers !== 0
		}

		def hasModifiers() {
			modifiers !== 0
		}

	}

	File file

	Map<String, KeyCodeLine> keyCodeLines

	new(File file) {
		checkNotNull(file.exists)
		checkArgument(file.exists)
		this.file = file
	}

	def getKeyCodeLines() {
		if (this.keyCodeLines === null) {
			val keyCodeLines = newArrayList
			val currentCategory = new StringBuilder
			val currentSection = new StringBuilder
			readAllLines(file.toPath, ISO_8859_1).filter [
				!startsWith("#")
			].tail.forEach [ line |
				val category = line.toCategory
				if (category !== null) {
					currentCategory.delete(0, currentCategory.length)
					currentCategory.append(category)
				}
				val section = line.toSection
				if (section !== null) {
					currentSection.delete(0, currentSection.length)
					currentSection.append(section)
				}
				val keyCodeLine = line.toKeyCodeLine(currentCategory.toString, currentSection.toString)
				if (keyCodeLine !== null) {
					keyCodeLines += keyCodeLine
				}
			]
			this.keyCodeLines = keyCodeLines.toMap[callback]
		}
		return this.keyCodeLines
	}

	private def toCategory(String line) {
		val it = line.parse
		if (size !== 9) {
			return null
		}
		if (get(0) != "SimDoNothing") {
			return null
		}
		if (get(3) != "0XFFFFFFFF") {
			return null
		}
		if (subList(4, 6).exists[valueOf.intValue != 0]) {
			return null
		}
		if (get(7).valueOf.intValue != -1) {
			return null
		}
		val description = get(8)
		if (javaDigit.indexIn(description) != 1) {
			return null
		}
		return description.substring(4, is('"').indexIn(description, 4)).trim
	}

	private def toSection(String line) {
		val it = line.parse
		if (size !== 9) {
			return null
		}
		if (get(0) != "SimDoNothing") {
			return null
		}
		if (get(3) != "0XFFFFFFFF") {
			return null
		}
		if (subList(4, 6).exists[valueOf.intValue != 0]) {
			return null
		}
		if (get(7).valueOf.intValue != -1) {
			return null
		}
		val description = get(8)
		if (!description.startsWith('''"======== ''') && !description.endsWith(''' ========"''')) {
			return null
		}
		return description.substring(19, is('=').indexIn(description, 19)).trim
	}

	private def parse(String line) {
		on(whitespace).limit(9).trimResults.splitToList(line)
	}

	private def toKeyCodeLine(String line, String category, String section) {
		val it = line.parse
		if (size !== 9) {
			return null
		}
		if (get(0) == "SimDoNothing") {
			return null
		}
		val callback = get(0)
		val sound = get(1).valueOf.intValue
		val key = if (get(3) != "0XFFFFFFFF") get(3).toUpperCase.replaceFirst("0X", "").parseInt(16).intValue else -1
		val modifiers = get(4).valueOf.intValue
		val comboKey = if (get(5) != "0XFFFFFFFF")
				get(5).toUpperCase.replaceFirst("0X", "").parseInt(16).intValue
			else
				-1
		val comboModifiers = get(6).valueOf.intValue
		val visibility = get(7).valueOf.intValue
		val description = is('"').trimFrom(get(8))
		if (visibility != -1) {
			return new KeyCodeLine(category, section, callback, sound, key, modifiers, comboKey, comboModifiers, description)
		}
	}

}
