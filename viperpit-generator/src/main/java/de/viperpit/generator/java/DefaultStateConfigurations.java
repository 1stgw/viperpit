package de.viperpit.generator.java;

import static de.viperpit.generator.java.DefaultStateConfigurations.StateType.RAMP;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import de.viperpit.commons.cockpit.Pair;

public class DefaultStateConfigurations {

	public static enum StateType {

		AIR("air"), RAMP("ramp"), TAXI("taxi");

		private final String label;

		private StateType(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

	}

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
