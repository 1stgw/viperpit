package de.viperpit.generator;

import java.util.Objects;

import de.viperpit.commons.cockpit.StateType;

public class DefaultStateConfiguration {

	private final String callback;

	private final StateType stateType;

	private final Object defaultValue;

	private final boolean stateful;

	DefaultStateConfiguration(String callback, StateType stateType, Object defaultValue) {
		this(callback, stateType, defaultValue, true);
	}

	DefaultStateConfiguration(String callback, StateType stateType, Object defaultValue, boolean stateful) {
		this.callback = callback;
		this.stateType = stateType;
		this.defaultValue = defaultValue;
		this.stateful = stateful;
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
		return Objects.equals(callback, other.callback);
	}

	public String getCallback() {
		return callback;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public StateType getStateType() {
		return stateType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(callback);
	}

	public boolean isStateful() {
		return stateful;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DefaultStateConfiguration [callback=");
		builder.append(callback);
		builder.append(", stateType=");
		builder.append(stateType);
		builder.append(", defaultValue=");
		builder.append(defaultValue);
		builder.append(", stateful=");
		builder.append(stateful);
		builder.append("]");
		return builder.toString();
	}

}