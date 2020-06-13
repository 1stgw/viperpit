package de.viperpit.generator.java;

import java.util.Objects;

public class FilterConfiguration {

	private final String callback;

	private final String type;

	FilterConfiguration(String callback, String type) {
		this.callback = callback;
		this.type = type;
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
		FilterConfiguration other = (FilterConfiguration) obj;
		return Objects.equals(callback, other.callback) && Objects.equals(type, other.type);
	}

	public String getCallback() {
		return callback;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callback, type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilterConfiguration [callback=");
		builder.append(callback);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}