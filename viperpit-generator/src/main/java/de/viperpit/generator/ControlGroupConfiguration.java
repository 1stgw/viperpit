package de.viperpit.generator;

import java.util.Collection;

public record ControlGroupConfiguration( //
		String id, //
		String label, //
		boolean stateful, //
		Collection<ControlConfiguration> controlConfigurations) {
}