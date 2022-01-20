package de.viperpit.generator;

import static de.viperpit.commons.cockpit.StateType.RAMP;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.viperpit.commons.cockpit.Pair;
import de.viperpit.commons.cockpit.StateType;

public class DefaultStateConfigurations {

	private final Map<Pair<String, StateType>, DefaultStateConfiguration> map = new HashMap<>(650);

	DefaultStateConfigurations(Collection<DefaultStateConfiguration> defaultStateConfigurations) {
		for (DefaultStateConfiguration defaultStateConfiguration : defaultStateConfigurations) {
			var key = new Pair<>(defaultStateConfiguration.getCallback(), defaultStateConfiguration.getStateType());
			map.put(key, defaultStateConfiguration);
		}
	}

	public Object getDefaultValue(String callback, StateType stateType) {
		DefaultStateConfiguration defaultStateConfiguration = map.get(new Pair<>(callback, stateType));
		if (defaultStateConfiguration == null) {
			return null;
		}
		return defaultStateConfiguration.getDefaultValue();
	}

	public boolean isStateful(String callback) {
		DefaultStateConfiguration defaultStateConfiguration = map.get(new Pair<>(callback, RAMP));
		if (defaultStateConfiguration == null) {
			return false;
		}
		return defaultStateConfiguration.isStateful();
	}

}
