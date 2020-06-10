package de.viperpit.generator.java;

import java.util.Collection;

public record CockpitConfiguration( //
		String id, //
		String label, //
		Collection<ConsoleConfiguration> consoleConfigurations) {
}
