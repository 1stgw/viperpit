package de.viperpit.commons.cockpit;

import java.util.Objects;

public class Group {

	private String className;

	private String description;

	private String id;

	private String label;

	private String type;

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
		Group other = (Group) obj;
		return Objects.equals(className, other.className) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(label, other.label)
				&& Objects.equals(type, other.type);
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

	public String getType() {
		return this.type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(className, description, id, label, type);
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

	public void setType(final String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Group [id=");
		builder.append(id);
		builder.append(", className=");
		builder.append(className);
		builder.append(", description=");
		builder.append(description);
		builder.append(", label=");
		builder.append(label);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

}
