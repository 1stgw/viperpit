package de.viperpit.generator.java;

import java.util.Collection;
import java.util.Objects;

public class PanelConfiguration {

	private final String id;

	private final String label;

	private final Collection<ControlGroupConfiguration> controlGroupConfigurations;

	PanelConfiguration(String id, String label, Collection<ControlGroupConfiguration> controlGroupConfigurations) {
		this.id = id;
		this.label = label;
		this.controlGroupConfigurations = controlGroupConfigurations;
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
		PanelConfiguration other = (PanelConfiguration) obj;
		return Objects.equals(controlGroupConfigurations, other.controlGroupConfigurations)
				&& Objects.equals(id, other.id) && Objects.equals(label, other.label);
	}

	public Collection<ControlGroupConfiguration> getControlGroupConfigurations() {
		return controlGroupConfigurations;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public int hashCode() {
		return Objects.hash(controlGroupConfigurations, id, label);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PanelConfiguration [id=");
		builder.append(id);
		builder.append(", label=");
		builder.append(label);
		builder.append(", controlGroupConfigurations=");
		builder.append(controlGroupConfigurations);
		builder.append("]");
		return builder.toString();
	}

}
