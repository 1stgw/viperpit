package de.viperpit.commons.cockpit;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StateChangeEvent {

	private Agent agent;

	private Map<String, Object> updatedStates;

	public StateChangeEvent() {
		this.agent = null;
		this.updatedStates = new HashMap<>();
	}

	public StateChangeEvent(Agent agent, Map<String, Object> updatedStates) {
		this.agent = agent;
		this.updatedStates = new HashMap<>(updatedStates);
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
		StateChangeEvent other = (StateChangeEvent) obj;
		return Objects.equals(agent, other.agent) && Objects.equals(updatedStates, other.updatedStates);
	}

	public Agent getAgent() {
		return agent;
	}

	public Map<String, Object> getUpdatedStates() {
		return updatedStates;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agent, updatedStates);
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public void setUpdatedStates(Map<String, Object> updatedStates) {
		this.updatedStates = updatedStates;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StateChangeEvent [updatedStates=");
		builder.append(updatedStates);
		builder.append(", agent=");
		builder.append(agent);
		builder.append("]");
		return builder.toString();
	}

}
