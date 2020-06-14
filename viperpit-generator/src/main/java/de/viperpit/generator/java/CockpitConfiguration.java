package de.viperpit.generator.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class CockpitConfiguration {

	private final String id;

	private final String label;

	private final Collection<ConsoleConfiguration> consoleConfigurations;

	CockpitConfiguration(String id, String label, Collection<ConsoleConfiguration> consoleConfigurations) {
		this.id = id;
		this.label = label;
		this.consoleConfigurations = consoleConfigurations;
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
		CockpitConfiguration other = (CockpitConfiguration) obj;
		return Objects.equals(consoleConfigurations, other.consoleConfigurations) && Objects.equals(id, other.id)
				&& Objects.equals(label, other.label);
	}

	public Collection<ConsoleConfiguration> getConsoleConfigurations() {
		return consoleConfigurations;
	}

	public Collection<ControlConfiguration> getControlConfigurations() {
		var collection = new ArrayList<ControlConfiguration>();
		for (ConsoleConfiguration consoleConfiguration : getConsoleConfigurations()) {
			for (PanelConfiguration panelConfiguration : consoleConfiguration.getPanelConfigurations()) {
				for (ControlGroupConfiguration controlGroupConfiguration : panelConfiguration
						.getControlGroupConfigurations()) {
					collection.addAll(controlGroupConfiguration.getControlConfigurations());
				}
			}
		}
		return collection;
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public int hashCode() {
		return Objects.hash(consoleConfigurations, id, label);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CockpitConfiguration [id=");
		builder.append(id);
		builder.append(", label=");
		builder.append(label);
		builder.append(", consoleConfigurations=");
		builder.append(consoleConfigurations);
		builder.append("]");
		return builder.toString();
	}

}
