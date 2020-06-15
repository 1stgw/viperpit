package de.viperpit.agent.controller;

import static de.viperpit.commons.cockpit.StateType.RAMP;
import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.viperpit.agent.data.SharedMemoryStateProvider;
import de.viperpit.agent.model.Agent;
import de.viperpit.agent.model.StateChangeEvent;
import de.viperpit.commons.cockpit.StateConfiguration;
import de.viperpit.commons.cockpit.StateConfigurationStore;
import de.viperpit.commons.cockpit.StateType;

@Component
public class StateProvider {

	private static final Logger LOGGER = getLogger(StateProvider.class);

	private final Agent agent;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private SharedMemoryStateProvider sharedMemoryStateProvider;

	private StateConfigurationStore stateConfigurationStore;

	private Map<StateConfiguration, Object> states;

	public StateProvider(@Value("#{environment.COMPUTERNAME}") String agentId) {
		this.agent = new Agent(agentId);
	}

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

	private Collection<Entry<StateConfiguration, Object>> getStates() {
		initialize();
		return states.entrySet();
	}

	private Object getValue(StateConfiguration stateConfiguration) {
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

	public StateChangeEvent initializeStates() {
		Map<StateConfiguration, Object> statesToUpdate = new HashMap<>();
		for (Entry<StateConfiguration, Object> entry : getStates()) {
			statesToUpdate.put(entry.getKey(), entry.getValue());
		}
		return updateStates(statesToUpdate);
	}

	private void put(StateConfiguration stateConfiguration, Object value) {
		initialize();
		states.put(stateConfiguration, value);
	}

	public StateChangeEvent toggleBooleanState(StateConfiguration stateConfiguration) {
		if (stateConfiguration == null || !stateConfiguration.isStateful()) {
			return null;
		}
		Map<StateConfiguration, Object> statesToUpdate = new HashMap<>();
		Object value = getValue(stateConfiguration);
		if (value instanceof Boolean) {
			boolean oldValue = ((Boolean) value).booleanValue();
			boolean newValue = !oldValue;
			statesToUpdate.put(stateConfiguration, newValue);
			for (String idOfRelated : stateConfiguration.getRelatedStateConfigurations()) {
				var relatedStateConfiguration = getStateConfiguration(idOfRelated);
				if (relatedStateConfiguration != null) {
					statesToUpdate.put(relatedStateConfiguration, oldValue);
				}
			}
		}
		return updateStates(statesToUpdate);
	}

	private StateChangeEvent updateStates(Map<StateConfiguration, ? extends Object> statesToUpdate) {
		Map<String, Object> updatedStates = new HashMap<>(statesToUpdate.size());
		statesToUpdate.forEach((stateConfiguration, value) -> {
			if (stateConfiguration != null) {
				put(stateConfiguration, value);
				updatedStates.put(stateConfiguration.getId(), value);
			}
		});
		return new StateChangeEvent(agent, updatedStates);
	}

	public StateChangeEvent updateStatesFromSharedMemory() {
		Map<StateConfiguration, Object> statesToUpdate = new HashMap<>();
		Map<String, Object> statesFromSharedMemory = sharedMemoryStateProvider.getStates();
		for (Entry<String, Object> entry : statesFromSharedMemory.entrySet()) {
			String id = entry.getKey();
			StateConfiguration stateConfiguration = getStateConfiguration(id);
			if (stateConfiguration != null) {
				Object newValue = entry.getValue();
				Object oldValue = getValue(stateConfiguration);
				if (!Objects.equals(oldValue, newValue)) {
					statesToUpdate.put(stateConfiguration, newValue);
					LOGGER.info("Updating " + stateConfiguration + ": " + newValue);
				}
			}
		}
		return updateStates(statesToUpdate);
	}

}