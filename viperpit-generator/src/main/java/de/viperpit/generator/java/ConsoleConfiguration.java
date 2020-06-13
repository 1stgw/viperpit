package de.viperpit.generator.java;

import java.util.Collection;
import java.util.Objects;

public class ConsoleConfiguration {

	private final String id;

	private final String label;

	private final Collection<PanelConfiguration> panelConfigurations;

	ConsoleConfiguration(String id, String label, Collection<PanelConfiguration> panelConfigurations) {
		this.id = id;
		this.label = label;
		this.panelConfigurations = panelConfigurations;
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
		ConsoleConfiguration other = (ConsoleConfiguration) obj;
		return Objects.equals(id, other.id) && Objects.equals(label, other.label)
				&& Objects.equals(panelConfigurations, other.panelConfigurations);
	}

	public String getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public Collection<PanelConfiguration> getPanelConfigurations() {
		return panelConfigurations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, label, panelConfigurations);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsoleConfiguration [id=");
		builder.append(id);
		builder.append(", label=");
		builder.append(label);
		builder.append(", panelConfigurations=");
		builder.append(panelConfigurations);
		builder.append("]");
		return builder.toString();
	}

}
