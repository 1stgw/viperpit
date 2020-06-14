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

	private final boolean stateful;

	ControlConfiguration(String id, String callback, String label, String description, String style, String role,
			String type, boolean stateful) {
		this.id = id;
		this.callback = callback;
		this.label = label;
		this.description = description;
		this.style = style;
		this.role = role;
		this.type = type;
		this.stateful = stateful;
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
		return Objects.equals(callback, other.callback) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(label, other.label)
				&& Objects.equals(role, other.role) && stateful == other.stateful && Objects.equals(style, other.style)
				&& Objects.equals(type, other.type);
	}

	public String getCallback() {
		return callback;
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
		return Objects.hash(callback, description, id, label, role, stateful, style, type);
	}

	public boolean isStateful() {
		return stateful;
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
		builder.append(", stateful=");
		builder.append(stateful);
		builder.append("]");
		return builder.toString();
	}

}