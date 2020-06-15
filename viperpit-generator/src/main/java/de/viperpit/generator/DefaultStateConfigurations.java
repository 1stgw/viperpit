package de.viperpit.generator;

import static de.viperpit.commons.cockpit.StateType.RAMP;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.viperpit.commons.cockpit.Pair;
import de.viperpit.commons.cockpit.StateType;

public class DefaultStateConfigurations {

	public static record DefaultStateConfiguration(String id, StateType stateType, Object defaultValue) {
	}

	private final Map<Pair<String, StateType>, DefaultStateConfiguration> map = new HashMap<>(650);

	DefaultStateConfigurations(Collection<DefaultStateConfiguration> defaultStateConfigurations) {
		for (DefaultStateConfiguration defaultStateConfiguration : defaultStateConfigurations) {
			var key = new Pair<>(defaultStateConfiguration.id(), defaultStateConfiguration.stateType());
			map.put(key, defaultStateConfiguration);
		}
	}

	public Object getDefaultValue(String id, StateType stateType) {
		DefaultStateConfiguration defaultStateConfiguration = map.get(new Pair<>(id, stateType));
		if (defaultStateConfiguration == null) {
			return null;
		}
		return defaultStateConfiguration.defaultValue();
	}

	public boolean isStateful(String id) {
		return map.get(new Pair<>(id, RAMP)) != null;
	}

}
