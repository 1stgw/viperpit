package de.viperpit.commons.cockpit;

import java.util.Collection;
import java.util.Objects;

public class Action {

	private boolean active;

	private String callback;

	private String id;

	private Collection<String> relatedActions;

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
		Action other = (Action) obj;
		return active == other.active && Objects.equals(callback, other.callback) && Objects.equals(id, other.id)
				&& Objects.equals(relatedActions, other.relatedActions) && stateful == other.stateful;
	}

	public String getCallback() {
		return this.callback;
	}

	public String getId() {
		return this.id;
	}

	public Collection<String> getRelatedActions() {
		return this.relatedActions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, callback, id, relatedActions, stateful);
	}

	public boolean isActive() {
		return this.active;
	}

	public boolean isStateful() {
		return this.stateful;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public void setCallback(final String callback) {
		this.callback = callback;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public void setRelatedActions(final Collection<String> relatedActions) {
		this.relatedActions = relatedActions;
	}

	public void setStateful(final boolean stateful) {
		this.stateful = stateful;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Action [id=");
		builder.append(id);
		builder.append(", callback=");
		builder.append(callback);
		builder.append(", active=");
		builder.append(active);
		builder.append(", stateful=");
		builder.append(stateful);
		builder.append(", relatedActions=");
		builder.append(relatedActions);
		builder.append("]");
		return builder.toString();
	}

}
