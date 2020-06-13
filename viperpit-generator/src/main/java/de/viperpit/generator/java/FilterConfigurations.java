package de.viperpit.generator.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class FilterConfigurations {

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

	private final Collection<FilterConfiguration> filterConfigurations;

	FilterConfigurations(Collection<FilterConfiguration> filterConfigurations) {
		this.filterConfigurations = filterConfigurations;
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
		FilterConfigurations other = (FilterConfigurations) obj;
		return Objects.equals(filterConfigurations, other.filterConfigurations);
	}

	public Collection<FilterConfiguration> getFilterConfigurations() {
		return filterConfigurations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filterConfigurations);
	}

	public boolean isIncluded(String callback) {
		return getFilterConfigurations() //
				.stream() //
				.filter(keyCodeLine -> Objects.equals(callback, keyCodeLine.getCallback())) //
				.findAny() //
				.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilterConfigurations [filterConfigurations=");
		builder.append(filterConfigurations);
		builder.append("]");
		return builder.toString();
	}
}