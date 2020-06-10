package de.viperpit.generator.java;

import java.util.Collection;

public record ConsoleConfiguration( //
		String id, //
		String label, //
		Collection<PanelConfiguration> panelConfigurations) {
}
