package de.viperpit.agent.model;

import java.util.Objects;

public class ToggleStateEvent {

	private String id;

	public ToggleStateEvent() {
	}

	public ToggleStateEvent(String id) {
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
		ToggleStateEvent other = (ToggleStateEvent) obj;
		return Objects.equals(id, other.id);
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ToggleStateEvent [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
