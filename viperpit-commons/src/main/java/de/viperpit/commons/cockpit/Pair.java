package de.viperpit.commons.cockpit;

import java.util.Objects;

public final class Pair<F, S> {

	private final F first;

	private final S second;

	public Pair(F first, S second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pair<?, ?> other = (Pair<?, ?>) obj;
		return Objects.equals(first, other.first) && Objects.equals(second, other.second);
	}

	public F first() {
		return first;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, second);
	}

	public F key() {
		return first;
	}

	public S second() {
		return second;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pair [first=");
		builder.append(first);
		builder.append(", second=");
		builder.append(second);
		builder.append("]");
		return builder.toString();
	}

	public S value() {
		return second;
	}

}
