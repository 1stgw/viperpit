package de.viperpit.agent.keys;

import static com.google.common.base.CharMatcher.javaDigit;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.skip;
import static com.google.common.collect.Maps.newLinkedHashMap;
import static com.google.common.collect.Maps.newLinkedHashMapWithExpectedSize;
import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class KeyFile {

	public static class KeyCodeLine {

		private final String callback;

		private final String category;

		private final String description;

		private final int key;

		private final int keyCombinationKey;

		private final int keyCombinationModifiers;

		private final int modifiers;

		private final String section;

		private final int sound;

		public KeyCodeLine( //
				String category, //
				String section, //
				String callback, //
				int sound, //
				int key, //
				int modifiers, //
				int keyCombinationKey, //
				int keyCombinationModifiers, //
				String description //
		) {
			super();
			this.category = category;
			this.section = section;
			this.callback = callback;
			this.sound = sound;
			this.key = key;
			this.modifiers = modifiers;
			this.keyCombinationKey = keyCombinationKey;
			this.keyCombinationModifiers = keyCombinationModifiers;
			this.description = description;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			KeyCodeLine other = (KeyCodeLine) obj;
			return Objects.equals(callback, other.callback) && Objects.equals(category, other.category)
					&& Objects.equals(description, other.description) && key == other.key
					&& keyCombinationKey == other.keyCombinationKey
					&& keyCombinationModifiers == other.keyCombinationModifiers && modifiers == other.modifiers
					&& Objects.equals(section, other.section) && sound == other.sound;
		}

		public String getCallback() {
			return this.callback;
		}

		public String getCategory() {
			return this.category;
		}

		public String getDescription() {
			return this.description;
		}

		public int getKey() {
			return this.key;
		}

		public int getKeyCombinationKey() {
			return this.keyCombinationKey;
		}

		public int getKeyCombinationModifiers() {
			return this.keyCombinationModifiers;
		}

		public int getModifiers() {
			return this.modifiers;
		}

		public String getSection() {
			return this.section;
		}

		public int getSound() {
			return this.sound;
		}

		@Override
		public int hashCode() {
			return Objects.hash(callback, category, description, key, keyCombinationKey, keyCombinationModifiers,
					modifiers, section, sound);
		}

		public boolean hasKey() {
			return (this.key != (-1));
		}

		public boolean hasKeyCombinationModifiers() {
			return (this.keyCombinationModifiers != 0);
		}

		public boolean hasKeyCombinations() {
			return (this.keyCombinationKey != 0);
		}

		public boolean hasModifiers() {
			return (this.modifiers != 0);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("KeyCodeLine [category=");
			builder.append(category);
			builder.append(", section=");
			builder.append(section);
			builder.append(", callback=");
			builder.append(callback);
			builder.append(", sound=");
			builder.append(sound);
			builder.append(", key=");
			builder.append(key);
			builder.append(", modifiers=");
			builder.append(modifiers);
			builder.append(", keyCombinationKey=");
			builder.append(keyCombinationKey);
			builder.append(", keyCombinationModifiers=");
			builder.append(keyCombinationModifiers);
			builder.append(", description=");
			builder.append(description);
			builder.append("]");
			return builder.toString();
		}

	}

	private Charset charset;

	private File file;

	private Map<String, KeyCodeLine> keyCodeLines;

	public KeyFile(File file, Charset charset) {
		checkNotNull(Boolean.valueOf(file.exists()));
		checkArgument(file.exists());
		checkNotNull(charset);
		this.file = file;
		this.charset = charset;
	}

	public Map<String, KeyCodeLine> getKeyCodeLines() {
		try {
			if (this.keyCodeLines == null) {
				List<String> lines = readAllLines(file.toPath(), charset);
				Map<String, KeyCodeLine> map = newLinkedHashMapWithExpectedSize(lines.size());
				StringBuilder currentCategory = new StringBuilder();
				StringBuilder currentSection = new StringBuilder();
				skip(filter(lines, line -> !line.startsWith("#")), 1).forEach(line -> {
					String category = toCategory(line);
					if (category != null) {
						currentCategory.delete(0, currentCategory.length());
						currentCategory.append(category);
					}
					String section = toSection(line);
					if (section != null) {
						currentSection.delete(0, currentSection.length());
						currentSection.append(section);
					}
					KeyCodeLine keyCodeLine = toKeyCodeLine(line, currentCategory.toString(),
							currentSection.toString());
					if (keyCodeLine != null) {
						map.put(keyCodeLine.getCallback(), keyCodeLine);
					}
				});
				this.keyCodeLines = newLinkedHashMap(map);
			}
			return this.keyCodeLines;
		} catch (Throwable exception) {
			throw new RuntimeException(exception);
		}
	}

	private List<String> parse(String line) {
		return Splitter.on(CharMatcher.whitespace()).limit(9).trimResults().splitToList(line);
	}

	@SuppressWarnings("deprecation")
	private String toCategory(String line) {
		List<String> tokens = this.parse(line);
		if ((tokens.size() != 9)) {
			return null;
		}
		if ((!Objects.equals(tokens.get(0), "SimDoNothing"))) {
			return null;
		}
		if ((!Objects.equals(tokens.get(3), "0XFFFFFFFF"))) {
			return null;
		}
		if (any(tokens.subList(4, 6), (String string) -> Integer.valueOf(string).intValue() != 0)) {
			return null;
		}
		if ((Integer.valueOf(tokens.get(7)).intValue() != (-1))) {
			return null;
		}
		String description = tokens.get(8);
		if ((javaDigit().indexIn(description) != 1)) {
			return null;
		}
		return description.substring(4, CharMatcher.is('\"').indexIn(description, 4)).trim();
	}

	private KeyCodeLine toKeyCodeLine(String line, String category, String section) {
		List<String> tokens = parse(line);
		if (tokens.size() != 9) {
			return null;
		}
		String _get = tokens.get(0);
		if (Objects.equals(_get, "SimDoNothing")) {
			return null;
		}
		String callback = tokens.get(0);
		int sound = Integer.valueOf(tokens.get(1)).intValue();
		int key = 0;
		if ((!Objects.equals(tokens.get(3), "0XFFFFFFFF"))) {
			key = Integer.valueOf(parseInt(tokens.get(3).toUpperCase().replaceFirst("0X", ""), 16)).intValue();
		} else {
			key = -1;
		}
		int modifiers = Integer.valueOf(tokens.get(4)).intValue();
		int comboKey = (int) 0;
		if (!Objects.equals(tokens.get(5), "0XFFFFFFFF")) {
			comboKey = Integer.valueOf(parseInt(tokens.get(5).toUpperCase().replaceFirst("0X", ""), 16)).intValue();
		} else {
			comboKey = (-1);
		}
		int comboModifiers = Integer.valueOf(tokens.get(6)).intValue();
		int visibility = Integer.valueOf(tokens.get(7)).intValue();
		String description = CharMatcher.is('\"').trimFrom(tokens.get(8));
		if (visibility == -1) {
			return null;
		}
		return new KeyCodeLine(category, section, callback, sound, key, modifiers, comboKey, comboModifiers,
				description);
	}

	private String toSection(String line) {
		List<String> tokens = parse(line);
		if (tokens.size() != 9) {
			return null;
		}
		if (!Objects.equals(tokens.get(0), "SimDoNothing")) {
			return null;
		}
		if (!Objects.equals(tokens.get(3), "0XFFFFFFFF")) {
			return null;
		}
		if (any(tokens.subList(4, 6), (String string) -> Integer.valueOf(string).intValue() != 0)) {
			return null;
		}
		if (Integer.valueOf(tokens.get(7)).intValue() != (-1)) {
			return null;
		}
		String description = tokens.get(8);
		boolean _and = false;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\"======== ");
		if (!(!description.startsWith(stringBuilder.toString()))) {
			_and = false;
		} else {
			StringBuilder stringBuilder1 = new StringBuilder();
			stringBuilder1.append(" ");
			stringBuilder1.append("========\"");
			_and = (!description.endsWith(stringBuilder1.toString()));
		}
		if (_and) {
			return null;
		}
		return description.substring(19, CharMatcher.is('=').indexIn(description, 19)).trim();
	}
}
