package de.viperpit.generator.java;

import java.util.Objects;

public class ControlConfiguration {

	private final String id;

	private final String callback;

	private final String label;

	private final String description;

	private final String style;

	private final String role;

	private final String type;

	private final Object defaultValueForRamp;

	private final Object defaultValueForTaxi;

	private final Object defaultValueForAir;

	ControlConfiguration(String id, String callback, String label, String description, String style, String role,
			String type, Object defaultValueForRamp, Object defaultValueForTaxi, Object defaultValueForAir) {
		this.id = id;
		this.callback = callback;
		this.label = label;
		this.description = description;
		this.style = style;
		this.role = role;
		this.type = type;
		this.defaultValueForRamp = defaultValueForRamp;
		this.defaultValueForTaxi = defaultValueForTaxi;
		this.defaultValueForAir = defaultValueForAir;
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
		ControlConfiguration other = (ControlConfiguration) obj;
		return Objects.equals(callback, other.callback) && Objects.equals(defaultValueForAir, other.defaultValueForAir)
				&& Objects.equals(defaultValueForRamp, other.defaultValueForRamp)
				&& Objects.equals(defaultValueForTaxi, other.defaultValueForTaxi)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(label, other.label) && Objects.equals(role, other.role)
				&& Objects.equals(style, other.style) && Objects.equals(type, other.type);
	}

	public String getCallback() {
		return callback;
	}

	public Object getDefaultValueForAir() {
		return defaultValueForAir;
	}

	public Object getDefaultValueForRamp() {
		return defaultValueForRamp;
	}

	public Object getDefaultValueForTaxi() {
		return defaultValueForTaxi;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getRole() {
		return role;
	}

	public String getStyle() {
		return style;
	}

	public String getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callback, defaultValueForAir, defaultValueForRamp, defaultValueForTaxi, description, id,
				label, role, style, type);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ControlConfiguration [id=");
		builder.append(id);
		builder.append(", callback=");
		builder.append(callback);
		builder.append(", label=");
		builder.append(label);
		builder.append(", description=");
		builder.append(description);
		builder.append(", style=");
		builder.append(style);
		builder.append(", role=");
		builder.append(role);
		builder.append(", type=");
		builder.append(type);
		builder.append(", defaultValueForRamp=");
		builder.append(defaultValueForRamp);
		builder.append(", defaultValueForTaxi=");
		builder.append(defaultValueForTaxi);
		builder.append(", defaultValueForAir=");
		builder.append(defaultValueForAir);
		builder.append("]");
		return builder.toString();
	}

}