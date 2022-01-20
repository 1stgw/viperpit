package de.viperpit.generator;

import static com.google.common.base.CharMatcher.is;
import static com.google.common.base.CharMatcher.javaLetterOrDigit;
import static com.google.common.base.CharMatcher.whitespace;
import static com.google.common.base.Splitter.on;
import static com.google.common.base.Strings.commonPrefix;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.join;
import static org.eclipse.xtext.xbase.lib.ListExtensions.map;
import static org.eclipse.xtext.xbase.lib.StringExtensions.toFirstLower;
import static org.eclipse.xtext.xbase.lib.StringExtensions.toFirstUpper;
import static org.springframework.util.StringUtils.capitalize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.CharMatcher;

import de.viperpit.agent.keys.KeyFile.KeyCodeLine;
import de.viperpit.commons.cockpit.Pair;

public class KeyCodeLineNames {

	public static String toCapitalizedName(String string) {
		var tokens = new ArrayList<>(on(whitespace()).trimResults().splitToList(string));
		return tokens.stream().map(token -> capitalize(token.toLowerCase())).collect(joining(" "));
	}

	@SuppressWarnings("deprecation")
	public static String toClassName(String string) {
		var name = string;
		name = is('.').removeFrom(name);
		name = is('_').replaceFrom(name, 'z');
		var tokens = new ArrayList<>(on(javaLetterOrDigit().negate()).trimResults().splitToList(name));
		return tokens.stream().map(token -> toFirstUpper(token.toLowerCase())).collect(joining());
	}

	public static Pair<String, String> toGroupAndLabel(KeyCodeLine keyCodeLine) {
		var separator = " - ";
		var description = keyCodeLine.getDescription();
		var lastIndex = description.lastIndexOf(separator);
		if (lastIndex != -1) {
			var group = description.substring(0, lastIndex).trim();
			var label = description.substring(lastIndex + separator.length(), description.length()).trim();
			return new Pair<>(group, label);
		}
		return new Pair<>(description, null);
	}

	public static String toId(String string) {
		return toFirstLower(toClassName(string));
	}

	public static String toLabel(KeyCodeLine keyCodeLine) {
		var lastIndexToken = '-';
		String description = keyCodeLine.getDescription();
		if (description.lastIndexOf(lastIndexToken) < 0) {
			lastIndexToken = ':';
		}
		return description.substring(description.lastIndexOf(lastIndexToken) + 1, description.length()).trim();
	}

	public static String toLabel(String string) {
		var tokens = new ArrayList<>(on(whitespace()).omitEmptyStrings().trimResults().splitToList(string));
		return tokens.stream().collect(joining(" "));
	}

	@SuppressWarnings("deprecation")
	public static String toPathName(final String category) {
		List<String> tokens = new ArrayList<String>( //
				on(whitespace()) //
						.trimResults() //
						.splitToList(category) //
		);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(join(map(tokens, it -> it.toLowerCase())));
		return CharMatcher.javaLetterOrDigit().retainFrom(stringBuilder.toString());
	}

	public static Collection<KeyCodeLine> toRelated(KeyCodeLine keyCodeLine, Pair<String, String> groupAndLabel,
			Collection<KeyCodeLine> keyCodeLines) {
		if (groupAndLabel.value() == null) {
			return emptyList();
		}
		return keyCodeLines.stream().filter(otherKeyCodeLine -> {
			if (keyCodeLine.getCallback().equals(otherKeyCodeLine.getCallback())) {
				return false;
			}
			return commonPrefix(keyCodeLine.getDescription(), otherKeyCodeLine.getDescription())
					.length() >= groupAndLabel.first().length();
		}).collect(toList());
	}

}
