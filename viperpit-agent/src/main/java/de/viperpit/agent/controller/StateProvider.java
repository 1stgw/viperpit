package de.viperpit.agent.controller;

import static de.viperpit.commons.cockpit.StateType.RAMP;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.viperpit.commons.cockpit.StateConfiguration;
import de.viperpit.commons.cockpit.StateConfigurationStore;
import de.viperpit.commons.cockpit.StateType;

@Component
public class StateProvider {

	private static final Logger LOGGER = getLogger(StateProvider.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ResourceLoader resourceLoader;

	private StateConfigurationStore stateConfigurationStore;

	private Map<StateConfiguration, Object> states;

	public StateConfiguration getStateConfiguration(String id) {
		initialize();
		return stateConfigurationStore.getById(id);
	}

	private String getStateFileName(StateType stateType) {
		switch (stateType) {
		case AIR:
			return "classpath:/states_air.json";
		case RAMP:
			return "classpath:/states_ramp.json";
		case TAXI:
			return "classpath:/states_taxi.json";
		default:
			return null;
		}
	}

	public Collection<Entry<StateConfiguration, Object>> getStates() {
		initialize();
		return states.entrySet();
	}

	public Object getValue(StateConfiguration stateConfiguration) {
		initialize();
		return states.get(stateConfiguration);
	}

	private void initialize() {
		if (states != null) {
			return;
		}
		states = new HashMap<>();
		String location = getStateFileName(RAMP);
		if (location == null) {
			return;
		}
		Resource resource = resourceLoader.getResource(location);
		if (resource.exists()) {
			try (InputStream inputStream = resource.getInputStream()) {
				stateConfigurationStore = objectMapper.readValue(inputStream, StateConfigurationStore.class);
				for (StateConfiguration stateConfiguration : stateConfigurationStore.getStateConfigurations()) {
					if (stateConfiguration.isStateful()) {
						states.put(stateConfiguration, stateConfiguration.isActive());
					}
				}
			} catch (IOException exception) {
				LOGGER.error("Error while loading: " + location, exception);
			}
		} else {
			LOGGER.error("State file in " + location + " could not be loaded");
		}
	}

	public void put(StateConfiguration stateConfiguration, Object value) {
		initialize();
		states.put(stateConfiguration, value);
	}

}