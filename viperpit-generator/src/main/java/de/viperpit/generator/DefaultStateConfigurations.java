package de.viperpit.generator;

import static com.google.common.base.Splitter.on;
import static java.util.Collections.emptyList;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

	public static DefaultStateConfigurations read(File file) {
		if (file == null || !file.exists()) {
			return new DefaultStateConfigurations(emptyList());
		}
		try {
			var list = new ArrayList<DefaultStateConfiguration>();
			var properties = new Properties();
			properties.load(new FileReader(file));
			properties.forEach((key, value) -> {
				var triState = on(',').trimResults().splitToList(value.toString());
				list.add(new DefaultStateConfiguration(key.toString(), StateType.RAMP, triState.get(0)));
				list.add(new DefaultStateConfiguration(key.toString(), StateType.TAXI, triState.get(1)));
				list.add(new DefaultStateConfiguration(key.toString(), StateType.AIR, triState.get(2)));
			});
			return new DefaultStateConfigurations(list);
		} catch (IOException exception) {
			return new DefaultStateConfigurations(emptyList());
		}
	}

	private final Map<Pair<String, StateType>, DefaultStateConfiguration> map = new HashMap<>(650);

	private DefaultStateConfigurations(Collection<DefaultStateConfiguration> defaultStateConfigurations) {
		for (DefaultStateConfiguration defaultStateConfiguration : defaultStateConfigurations) {
			var key = new Pair<>(defaultStateConfiguration.id(), defaultStateConfiguration.stateType());
			map.put(key, defaultStateConfiguration);
		}
	}

	public DefaultStateConfiguration getDefaultConfiguration(String id, StateType stateType) {
		return map.get(new Pair<>(id, stateType));
	}

}
