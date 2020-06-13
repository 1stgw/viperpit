package de.viperpit.generator.java;

import java.util.Collection;
import java.util.Objects;

public class ControlGroupConfiguration {

	private final String id;

	private final String label;

	private final boolean stateful;

	private final Collection<ControlConfiguration> controlConfigurations;

	ControlGroupConfiguration(String id, String label, boolean stateful,
			Collection<ControlConfiguration> controlConfigurations) {
		this.id = id;
		this.label = label;
		this.stateful = stateful;
		this.controlConfigurations = controlConfigurations;
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
		ControlGroupConfiguration other = (ControlGroupConfiguration) obj;
		return Objects.equals(controlConfigurations, other.controlConfigurations) && Objects.equals(id, other.id)
				&& Objects.equals(label, other.label) && stateful == other.stateful;
	}

	public Collection<ControlConfiguration> getControlConfigurations() {
		return controlConfigurations;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public int hashCode() {
		return Objects.hash(controlConfigurations, id, label, stateful);
	}

	public boolean isStateful() {
		return stateful;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ControlGroupConfiguration [id=");
		builder.append(id);
		builder.append(", label=");
		builder.append(label);
		builder.append(", stateful=");
		builder.append(stateful);
		builder.append(", controlConfigurations=");
		builder.append(controlConfigurations);
		builder.append("]");
		return builder.toString();
	}
}