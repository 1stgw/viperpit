package de.viperpit.commons.cockpit;

import java.util.Objects;

public class Control {

	private String className;

	private String description;

	private String id;

	private String label;

	private String role;

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
		Control other = (Control) obj;
		return Objects.equals(className, other.className) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(label, other.label)
				&& Objects.equals(role, other.role);
	}

	public String getClassName() {
		return this.className;
	}

	public String getDescription() {
		return this.description;
	}

	public String getId() {
		return this.id;
	}

	public String getLabel() {
		return this.label;
	}

	public String getRole() {
		return this.role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(className, description, id, label, role);
	}

	public void setClassName(final String className) {
		this.className = className;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	public void setRole(final String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Control [id=");
		builder.append(id);
		builder.append(", className=");
		builder.append(className);
		builder.append(", description=");
		builder.append(description);
		builder.append(", label=");
		builder.append(label);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}