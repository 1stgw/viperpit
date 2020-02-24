package de.viperpit.commons.cockpit;

import java.util.Objects;

public class Panel {
	private String className;

	private String id;

	private String name;

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
		Panel other = (Panel) obj;
		return Objects.equals(className, other.className) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	public String getClassName() {
		return this.className;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(className, id, name);
	}

	public void setClassName(final String className) {
		this.className = className;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Panel [id=");
		builder.append(id);
		builder.append(", className=");
		builder.append(className);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
