package de.viperpit.generator;

public record ControlConfiguration( //
		String id, //
		String callback, //
		String label, //
		String description, //
		String style, //
		String role, //
		String type, //
		Object defaultValueForRamp, //
		Object defaultValueForTaxi, //
		Object defaultValueForAir) {
}