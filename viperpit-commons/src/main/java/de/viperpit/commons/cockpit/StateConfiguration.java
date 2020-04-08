package de.viperpit.commons.cockpit;

import java.util.Collection;
import java.util.Objects;

public class StateConfiguration {

	private boolean active;

	private String callback;

	private String id;

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
		return Objects.equals(id, other.id);
	}

	public String getCallback() {
		return this.callback;
	}

	public String getId() {
		return this.id;
	}

	public Collection<String> getRelatedStateConfigurations() {
		return this.relatedStateConfigurations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public boolean isActive() {
		return this.active;
	}

	public boolean isStateful() {
		return this.stateful;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public void setId(String id) {
		this.id = id;
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
		builder.append("StateConfiguration [id=");
		builder.append(id);
		builder.append(", callback=");
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
