package de.viperpit.agent.model;

import java.util.Objects;

public class TriggerStateChangeEvent {

	private String id;

	private boolean start;

	public TriggerStateChangeEvent() {
	}

	public TriggerStateChangeEvent(String id) {
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
		TriggerStateChangeEvent other = (TriggerStateChangeEvent) obj;
		return Objects.equals(id, other.id);
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public boolean isStart() {
		return start;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TriggerStateChangeEvent [id=");
		builder.append(id);
		builder.append(", start=");
		builder.append(start);
		builder.append("]");
		return builder.toString();
	}

}
