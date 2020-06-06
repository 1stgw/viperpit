package de.viperpit.generator;

import java.util.Collection;

public record PanelConfiguration( //
		String id, //
		String label, //
		Collection<ControlGroupConfiguration> controlGroupConfigurations) {
}
