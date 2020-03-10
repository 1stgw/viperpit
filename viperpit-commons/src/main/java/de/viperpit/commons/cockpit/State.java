package de.viperpit.commons.cockpit;

import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.Map;

public class State {

	private Agent agent;

	private Collection<Action> actions;

	private transient Map<String, Action> byCallback;

	private transient Map<String, Action> byId;

	public State() {
	}

	public State(final Agent agent, final Collection<Action> actions) {
		this.agent = agent;
		this.actions = actions;
	}

	public Action getBy(final ActionEvent it) {
		return this.getByCallback(it.getCallback());
	}

	public Action getByCallback(final String callback) {
		if (this.byCallback == null) {
			this.byCallback = this.actions.stream().collect(toMap(Action::getCallback, action -> action));
		}
		return this.byCallback.get(callback);
	}

	public Action getById(final String id) {
		if (this.byId == null) {
			this.byId = this.actions.stream().collect(toMap(Action::getId, action -> action));
		}
		return this.byId.get(id);
	}

	public Agent getAgent() {
		return this.agent;
	}

	public void setAgent(final Agent agent) {
		this.agent = agent;
	}

	public Collection<Action> getActions() {
		return this.actions;
	}

	public void setActions(final Collection<Action> actions) {
		this.actions = actions;
	}

	public Map<String, Action> getByCallback() {
		return this.byCallback;
	}

	public void setByCallback(final Map<String, Action> byCallback) {
		this.byCallback = byCallback;
	}

	public Map<String, Action> getById() {
		return this.byId;
	}

	public void setById(final Map<String, Action> byId) {
		this.byId = byId;
	}

}
