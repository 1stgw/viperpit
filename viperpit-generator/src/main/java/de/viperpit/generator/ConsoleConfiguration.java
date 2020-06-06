package de.viperpit.generator;

import java.util.Collection;

public record ConsoleConfiguration( //
		String id, //
		String label, //
		Collection<PanelConfiguration> panelConfigurations) {
}
