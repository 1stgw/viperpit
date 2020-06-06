package de.viperpit.commons.cockpit;

public record Pair<F, S> (F first, S second) {

	public F key() {
		return first();
	}

	public S value() {
		return second();
	}

}
