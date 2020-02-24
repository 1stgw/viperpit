package de.viperpit.commons.cockpit;

import java.util.Collection;
import java.util.Objects;

public class Cockpit {

	private Collection<Console> consoles;

	private Collection<Control> controls;

	private Collection<Group> groups;

	private String id;

	private String name;

	private Collection<Panel> panels;

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
		Cockpit other = (Cockpit) obj;
		return Objects.equals(consoles, other.consoles) && Objects.equals(controls, other.controls)
				&& Objects.equals(groups, other.groups) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(panels, other.panels);
	}

	public Collection<Console> getConsoles() {
		return this.consoles;
	}

	public Collection<Control> getControls() {
		return this.controls;
	}

	public Collection<Group> getGroups() {
		return this.groups;
	}

	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public Collection<Panel> getPanels() {
		return this.panels;
	}

	@Override
	public int hashCode() {
		return Objects.hash(consoles, controls, groups, id, name, panels);
	}

	public void setConsoles(final Collection<Console> consoles) {
		this.consoles = consoles;
	}

	public void setControls(final Collection<Control> controls) {
		this.controls = controls;
	}

	public void setGroups(final Collection<Group> groups) {
		this.groups = groups;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPanels(final Collection<Panel> panels) {
		this.panels = panels;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cockpit [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", consoles=");
		builder.append(consoles);
		builder.append(", panels=");
		builder.append(panels);
		builder.append(", groups=");
		builder.append(groups);
		builder.append(", controls=");
		builder.append(controls);
		builder.append("]");
		return builder.toString();
	}

}
