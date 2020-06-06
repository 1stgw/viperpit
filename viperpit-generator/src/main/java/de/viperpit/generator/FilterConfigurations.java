package de.viperpit.generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public record FilterConfigurations(Collection<FilterConfiguration> filterConfigurations) {

	public static record FilterConfiguration(String callback, String type) {
	}

	public boolean isIncluded(String callback) {
		return filterConfigurations() //
				.stream() //
				.filter(it -> Objects.equals(callback, it.callback())) //
				.findAny() //
				.isEmpty();
	}

	public static FilterConfigurations read(File file) {
		if (file == null || !file.exists()) {
			return new FilterConfigurations(List.of());
		}
		try {
			var list = new ArrayList<FilterConfiguration>();
			var properties = new Properties();
			properties.load(new FileReader(file));
			properties.forEach((key, value) -> list.add(new FilterConfiguration(key.toString(), value.toString())));
			return new FilterConfigurations(List.copyOf(list));
		} catch (IOException exception) {
			return new FilterConfigurations(List.of());
		}
	}

}