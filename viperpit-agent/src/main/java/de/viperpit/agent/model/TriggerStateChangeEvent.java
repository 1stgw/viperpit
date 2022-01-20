package de.viperpit.agent.model;

import java.util.Objects;

public class TriggerStateChangeEvent {

	private String callback;

	private boolean start;

	public TriggerStateChangeEvent() {
	}

	public TriggerStateChangeEvent(String callback) {
		this.callback = callback;
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
		return Objects.equals(callback, other.callback);
	}

	public String getCallback() {
		return callback;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callback);
	}

	public boolean isStart() {
		return start;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TriggerStateChangeEvent [callback=");
		builder.append(callback);
		builder.append(", start=");
		builder.append(start);
		builder.append("]");
		return builder.toString();
	}

}
