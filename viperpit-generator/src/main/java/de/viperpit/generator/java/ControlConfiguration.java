package de.viperpit.generator.java;

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