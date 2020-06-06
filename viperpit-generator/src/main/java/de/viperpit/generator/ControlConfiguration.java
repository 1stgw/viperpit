package de.viperpit.generator;

import de.viperpit.generator.DefaultStateConfigurations.DefaultStateConfiguration;
import de.viperpit.generator.RoleConfigurations.RoleConfiguration;

public record ControlConfiguration( //
		String id, //
		String callback, //
		String label, //
		String description, //
		String style, //
		RoleConfiguration roleConfiguration, //
		DefaultStateConfiguration rampStateConfiguration, //
		DefaultStateConfiguration taxiStateConfiguration, //
		DefaultStateConfiguration airStateConfiguration, //
		String type) {
}