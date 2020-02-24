package de.viperpit.commons.cockpit;

import java.util.Objects;

public class ActionEvent {

	private String callback;

	public ActionEvent() {
	}

	public ActionEvent(final String callback) {
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
		ActionEvent other = (ActionEvent) obj;
		return Objects.equals(callback, other.callback);
	}

	public String getCallback() {
		return this.callback;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callback);
	}

	public void setCallback(final String callback) {
		this.callback = callback;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ActionEvent [callback=");
		builder.append(callback);
		builder.append("]");
		return builder.toString();
	}

}
