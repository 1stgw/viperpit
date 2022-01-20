package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.io.IOException;
import java.io.InputStream;
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

	public StateConfiguration getStateConfiguration(String callback) {
		initialize();
		return stateConfigurationStore.getByCallback(callback);
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

	private Object getValue(StateConfiguration stateConfiguration) {
		initialize();
		return states.get(stateConfiguration);
	}

	private void initialize() {
		if (states != null) {
			return;
		}
		states = new HashMap<>();
		StateType stateType = sharedMemoryStateProvider.getCurrentStateType();
		String location = getStateFileName(stateType);
		if (location == null) {
			LOGGER.error("No file found for type " + stateType);
			return;
		}
		Resource resource = resourceLoader.getResource(location);
		if (!resource.exists()) {
			LOGGER.error("State file in " + location + " could not be loaded");
			return;
		}
		try (InputStream inputStream = resource.getInputStream()) {
			stateConfigurationStore = objectMapper.readValue(inputStream, StateConfigurationStore.class);
			for (StateConfiguration stateConfiguration : stateConfigurationStore.getStateConfigurations()) {
				states.put(stateConfiguration, stateConfiguration.isActive());
			}
		} catch (IOException exception) {
			LOGGER.error("Error while loading: " + location, exception);
		}
	}

	public StateChangeEvent initializeStates() {
		initialize();
		Map<StateConfiguration, Object> statesToUpdate = new HashMap<>();
		for (Entry<StateConfiguration, Object> entry : states.entrySet()) {
			statesToUpdate.put(entry.getKey(), entry.getValue());
		}
		return updateStates(statesToUpdate);
	}

	private void put(StateConfiguration stateConfiguration, Object value) {
		initialize();
		states.put(stateConfiguration, value);
	}

	public StateChangeEvent resetStates() {
		synchronized (states) {
			states = null;
		}
		return initializeStates();
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
			for (String callbackOfRelated : stateConfiguration.getRelatedStateConfigurations()) {
				var relatedStateConfiguration = getStateConfiguration(callbackOfRelated);
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
				updatedStates.put(stateConfiguration.getCallback(), value);
			}
		});
		return new StateChangeEvent(agent, updatedStates);
	}

	public StateChangeEvent updateStatesFromSharedMemory() {
		Map<StateConfiguration, Object> statesToUpdate = new HashMap<>();
		Map<String, Object> statesFromSharedMemory = sharedMemoryStateProvider.getStates();
		for (Entry<String, Object> entry : statesFromSharedMemory.entrySet()) {
			String callback = entry.getKey();
			StateConfiguration stateConfiguration = getStateConfiguration(callback);
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