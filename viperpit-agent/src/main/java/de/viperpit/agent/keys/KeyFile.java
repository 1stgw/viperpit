package de.viperpit.agent.keys;

import static com.google.common.base.CharMatcher.javaDigit;
import static com.google.common.base.Objects.equal;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.skip;
import static com.google.common.collect.Lists.newArrayList;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.file.Files.readAllLines;
import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.common.base.CharMatcher;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

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

		public KeyCodeLine(final String category, final String section, final String callback, final int sound,
				final int key, final int modifiers, final int keyCombinationKey, final int keyCombinationModifiers,
				final String description) {
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
			return java.util.Objects.equals(callback, other.callback)
					&& java.util.Objects.equals(category, other.category)
					&& java.util.Objects.equals(description, other.description) && key == other.key
					&& keyCombinationKey == other.keyCombinationKey
					&& keyCombinationModifiers == other.keyCombinationModifiers && modifiers == other.modifiers
					&& java.util.Objects.equals(section, other.section) && sound == other.sound;
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
			return java.util.Objects.hash(callback, category, description, key, keyCombinationKey,
					keyCombinationModifiers, modifiers, section, sound);
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

	private File file;

	private Map<String, KeyFile.KeyCodeLine> keyCodeLines;

	public KeyFile(final File file) {
		Preconditions.<Boolean>checkNotNull(Boolean.valueOf(file.exists()));
		Preconditions.checkArgument(file.exists());
		this.file = file;
	}

	public Map<String, KeyFile.KeyCodeLine> getKeyCodeLines() {
		try {
			if ((this.keyCodeLines == null)) {
				final ArrayList<KeyFile.KeyCodeLine> keyCodeLines = newArrayList();
				final StringBuilder currentCategory = new StringBuilder();
				final StringBuilder currentSection = new StringBuilder();
				skip(Iterables.filter(readAllLines(this.file.toPath(), ISO_8859_1), new Predicate<String>() {
					public boolean apply(final String it) {
						return !it.startsWith("#");
					}
				}), 1).forEach(new Consumer<String>() {
					public void accept(final String line) {
						final String category = KeyFile.this.toCategory(line);
						if ((category != null)) {
							currentCategory.delete(0, currentCategory.length());
							currentCategory.append(category);
						}
						final String section = KeyFile.this.toSection(line);
						if ((section != null)) {
							currentSection.delete(0, currentSection.length());
							currentSection.append(section);
						}
						final KeyFile.KeyCodeLine keyCodeLine = KeyFile.this.toKeyCodeLine(line,
								currentCategory.toString(), currentSection.toString());
						if ((keyCodeLine != null)) {
							keyCodeLines.add(keyCodeLine);
						}
					}
				});
				this.keyCodeLines = keyCodeLines.stream()
						.collect(toMap(KeyCodeLine::getCallback, keyCodeLine -> keyCodeLine));
			}
			return this.keyCodeLines;
		} catch (Throwable _e) {
			throw new RuntimeException(_e);
		}
	}

	private List<String> parse(final String line) {
		return Splitter.on(CharMatcher.whitespace()).limit(9).trimResults().splitToList(line);
	}

	@SuppressWarnings("deprecation")
	private String toCategory(final String line) {
		final List<String> tokens = this.parse(line);
		if ((tokens.size() != 9)) {
			return null;
		}
		if ((!equal(tokens.get(0), "SimDoNothing"))) {
			return null;
		}
		if ((!equal(tokens.get(3), "0XFFFFFFFF"))) {
			return null;
		}
		if (any(tokens.subList(4, 6), (String string) -> Integer.valueOf(string).intValue() != 0)) {
			return null;
		}
		if ((Integer.valueOf(tokens.get(7)).intValue() != (-1))) {
			return null;
		}
		final String description = tokens.get(8);
		if ((javaDigit().indexIn(description) != 1)) {
			return null;
		}
		return description.substring(4, CharMatcher.is('\"').indexIn(description, 4)).trim();
	}

	private KeyFile.KeyCodeLine toKeyCodeLine(final String line, final String category, final String section) {
		final List<String> it = this.parse(line);
		int _size = it.size();
		boolean _tripleNotEquals = (_size != 9);
		if (_tripleNotEquals) {
			return null;
		}
		String _get = it.get(0);
		boolean _equals = Objects.equal(_get, "SimDoNothing");
		if (_equals) {
			return null;
		}
		final String callback = it.get(0);
		final int sound = Integer.valueOf(it.get(1)).intValue();
		int _xifexpression = (int) 0;
		String _get_1 = it.get(3);
		boolean _notEquals = (!Objects.equal(_get_1, "0XFFFFFFFF"));
		if (_notEquals) {
			_xifexpression = Integer.valueOf(Integer.parseInt(it.get(3).toUpperCase().replaceFirst("0X", ""), 16))
					.intValue();
		} else {
			_xifexpression = (-1);
		}
		final int key = _xifexpression;
		final int modifiers = Integer.valueOf(it.get(4)).intValue();
		int _xifexpression_1 = (int) 0;
		String _get_2 = it.get(5);
		boolean _notEquals_1 = (!Objects.equal(_get_2, "0XFFFFFFFF"));
		if (_notEquals_1) {
			_xifexpression_1 = Integer.valueOf(Integer.parseInt(it.get(5).toUpperCase().replaceFirst("0X", ""), 16))
					.intValue();
		} else {
			_xifexpression_1 = (-1);
		}
		final int comboKey = _xifexpression_1;
		final int comboModifiers = Integer.valueOf(it.get(6)).intValue();
		final int visibility = Integer.valueOf(it.get(7)).intValue();
		final String description = CharMatcher.is('\"').trimFrom(it.get(8));
		if ((visibility != (-1))) {
			return new KeyFile.KeyCodeLine(category, section, callback, sound, key, modifiers, comboKey, comboModifiers,
					description);
		}
		return null;
	}

	private String toSection(final String line) {
		final List<String> it = this.parse(line);
		int _size = it.size();
		boolean _tripleNotEquals = (_size != 9);
		if (_tripleNotEquals) {
			return null;
		}
		String _get = it.get(0);
		boolean _notEquals = (!Objects.equal(_get, "SimDoNothing"));
		if (_notEquals) {
			return null;
		}
		String _get_1 = it.get(3);
		boolean _notEquals_1 = (!Objects.equal(_get_1, "0XFFFFFFFF"));
		if (_notEquals_1) {
			return null;
		}
		if (any(it.subList(4, 6), (String string) -> Integer.valueOf(string).intValue() != 0)) {
			return null;
		}
		int _intValue = Integer.valueOf(it.get(7)).intValue();
		boolean _notEquals_2 = (_intValue != (-1));
		if (_notEquals_2) {
			return null;
		}
		final String description = it.get(8);
		boolean _and = false;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\"======== ");
		boolean _startsWith = description.startsWith(stringBuilder.toString());
		boolean _not = (!_startsWith);
		if (!_not) {
			_and = false;
		} else {
			StringBuilder stringBuilder1 = new StringBuilder();
			stringBuilder1.append(" ");
			stringBuilder1.append("========\"");
			boolean _endsWith = description.endsWith(stringBuilder1.toString());
			boolean _not_1 = (!_endsWith);
			_and = _not_1;
		}
		if (_and) {
			return null;
		}
		return description.substring(19, CharMatcher.is('=').indexIn(description, 19)).trim();
	}
}
