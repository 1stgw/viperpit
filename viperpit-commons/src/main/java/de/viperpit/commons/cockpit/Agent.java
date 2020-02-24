package de.viperpit.commons.cockpit;

import java.util.Objects;

public class Agent {

	private final String id;

	public Agent() {
		this.id = null;
	}

	public Agent(final String id) {
		this.id = id;
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
		Agent other = (Agent) obj;
		return Objects.equals(id, other.id);
	}

	public String getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Agent [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
