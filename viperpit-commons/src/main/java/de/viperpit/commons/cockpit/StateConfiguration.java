package de.viperpit.commons.cockpit;

import java.util.Collection;
import java.util.Objects;

public class StateConfiguration {

	private boolean active;

	private String callback;

	private Collection<String> relatedStateConfigurations;

	private boolean stateful;

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
		StateConfiguration other = (StateConfiguration) obj;
		return Objects.equals(callback, other.callback);
	}

	public String getCallback() {
		return callback;
	}

	public Collection<String> getRelatedStateConfigurations() {
		return relatedStateConfigurations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callback);
	}

	public boolean isActive() {
		return active;
	}

	public boolean isStateful() {
		return stateful;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public void setRelatedStateConfigurations(Collection<String> relatedStateConfigurations) {
		this.relatedStateConfigurations = relatedStateConfigurations;
	}

	public void setStateful(boolean stateful) {
		this.stateful = stateful;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StateConfiguration [callback=");
		builder.append(callback);
		builder.append(", relatedStateConfigurations=");
		builder.append(relatedStateConfigurations);
		builder.append(", active=");
		builder.append(active);
		builder.append(", stateful=");
		builder.append(stateful);
		builder.append("]");
		return builder.toString();
	}

}
