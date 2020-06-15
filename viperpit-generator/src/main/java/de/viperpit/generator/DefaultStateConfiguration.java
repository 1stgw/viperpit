package de.viperpit.generator;

import java.util.Objects;

import de.viperpit.commons.cockpit.StateType;

public class DefaultStateConfiguration {

	private final String id;

	private final StateType stateType;

	private final Object defaultValue;

	DefaultStateConfiguration(String id, StateType stateType, Object defaultValue) {
		this.id = id;
		this.stateType = stateType;
		this.defaultValue = defaultValue;
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
		DefaultStateConfiguration other = (DefaultStateConfiguration) obj;
		return Objects.equals(defaultValue, other.defaultValue) && Objects.equals(id, other.id)
				&& stateType == other.stateType;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public String getId() {
		return id;
	}

	public StateType getStateType() {
		return stateType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(defaultValue, id, stateType);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DefaultStateConfiguration [id=");
		builder.append(id);
		builder.append(", stateType=");
		builder.append(stateType);
		builder.append(", defaultValue=");
		builder.append(defaultValue);
		builder.append("]");
		return builder.toString();
	}

}