package de.viperpit.commons.cockpit;

import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.Map;

public class StateConfigurationStore {

	private transient Map<String, StateConfiguration> byCallback;

	private transient Map<String, StateConfiguration> byId;

	private Collection<StateConfiguration> stateConfigurations;

	public StateConfigurationStore() {
	}

	public StateConfigurationStore(Collection<StateConfiguration> stateConfigurations) {
		this.stateConfigurations = stateConfigurations;
	}

	public StateConfiguration getByCallback(String callback) {
		if (byCallback == null) {
			byCallback = stateConfigurations.stream()
					.collect(toMap(StateConfiguration::getCallback, stateConfiguration -> stateConfiguration));
		}
		return byCallback.get(callback);
	}

	public StateConfiguration getById(String id) {
		if (byId == null) {
			byId = stateConfigurations.stream()
					.collect(toMap(StateConfiguration::getId, stateConfiguration -> stateConfiguration));
		}
		return byId.get(id);
	}

	public Collection<StateConfiguration> getStateConfigurations() {
		return stateConfigurations;
	}

	public void setStateConfigurations(Collection<StateConfiguration> stateConfigurations) {
		this.stateConfigurations = stateConfigurations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StateConfigurationStore [stateConfigurations=");
		builder.append(stateConfigurations);
		builder.append("]");
		return builder.toString();
	}

}
