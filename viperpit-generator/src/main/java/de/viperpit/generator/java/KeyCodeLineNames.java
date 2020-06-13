package de.viperpit.generator.java;

import static com.google.common.base.CharMatcher.is;
import static com.google.common.base.CharMatcher.javaLetterOrDigit;
import static com.google.common.base.CharMatcher.whitespace;
import static com.google.common.base.Splitter.on;
import static com.google.common.base.Strings.commonPrefix;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.eclipse.xtext.xbase.lib.StringExtensions.toFirstLower;
import static org.eclipse.xtext.xbase.lib.StringExtensions.toFirstUpper;
import static org.springframework.util.StringUtils.capitalize;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

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

	public static String toId(KeyCodeLine keyCodeLine) {
		return toId(keyCodeLine.getDescription());
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

	public static String toName(String string) {
		var tokens = new ArrayList<>(on(whitespace()).omitEmptyStrings().trimResults().splitToList(string));
		return tokens.stream().collect(joining(" "));
	}

	@SuppressWarnings("deprecation")
	public static String toPathName(final String category) {
		final ArrayList<String> tokens = new ArrayList<String>( //
				on(whitespace()) //
						.trimResults() //
						.splitToList(category) //
		);
		final Function1<String, String> _function = new Function1<String, String>() {
			public String apply(final String it) {
				return it.toLowerCase();
			}
		};
		String _join = IterableExtensions.join(ListExtensions.map(tokens, _function));
		StringBuilder _builder = new StringBuilder();
		_builder.append(_join);
		return CharMatcher.javaLetterOrDigit().retainFrom(_builder.toString());
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
