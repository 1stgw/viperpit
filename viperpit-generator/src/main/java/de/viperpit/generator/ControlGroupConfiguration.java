package de.viperpit.generator;

import java.util.Collection;

public record ControlGroupConfiguration( //
		String id, //
		String label, //
		Collection<ControlConfiguration> controlConfigurations) {
}