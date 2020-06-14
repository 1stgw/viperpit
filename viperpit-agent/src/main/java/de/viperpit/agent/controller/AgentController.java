package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import de.viperpit.agent.data.SharedMemoryStateProvider;
import de.viperpit.agent.keys.KeyDispatcherService;
import de.viperpit.agent.model.Agent;
import de.viperpit.agent.model.InitializeStateEvent;
import de.viperpit.agent.model.StateChangeEvent;
import de.viperpit.agent.model.ToggleStateEvent;
import de.viperpit.commons.cockpit.StateConfiguration;

@Controller
public class AgentController implements ApplicationListener<ApplicationEvent> {

	private static final String APP_STATES_INIT = "/cockpit/states/init";

	private static final String APP_STATES_TOGGLE = "/cockpit/states/toggle";

	private static final Logger LOGGER = getLogger(AgentController.class);

	private static final String TOPIC_STATES_UPDATE = "/topic/cockpit/states/update";

	private final Agent agent;

	@Autowired
	private KeyDispatcherService keyDispatcherService;

	@Autowired
	private SharedMemoryStateProvider sharedMemoryStateProvider;

	@Autowired
	private StateConfigurationReader stateConfigurationReader;

	@Autowired
	private SimpMessagingTemplate template;

	@Value("${url}")
	private String url;

	public AgentController(@Value("#{environment.COMPUTERNAME}") String agentId) {
		this.agent = new Agent(agentId);
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println(event);
	}

	@MessageMapping(APP_STATES_INIT)
	@SendTo(TOPIC_STATES_UPDATE)
	public StateChangeEvent onStatesInit(InitializeStateEvent initializeStateEvent) {
		LOGGER.info("State intialization requested.");
		Map<String, Object> statesToUpdate = new HashMap<>();
		for (Entry<StateConfiguration, Object> entry : stateConfigurationReader.getStates()) {
			statesToUpdate.put(entry.getKey().getId(), entry.getValue());
		}
		return updateStates(statesToUpdate);
	}

	@MessageMapping(APP_STATES_TOGGLE)
	@SendTo(TOPIC_STATES_UPDATE)
	public StateChangeEvent onStatesToggle(ToggleStateEvent toggleStateEvent) {
		if (toggleStateEvent == null) {
			return null;
		}
		String id = toggleStateEvent.getId();
		StateConfiguration stateConfiguration = stateConfigurationReader.getStateConfiguration(id);
		if (stateConfiguration == null) {
			return null;
		}
		keyDispatcherService.fire(stateConfiguration.getCallback());
		if (!stateConfiguration.isStateful()) {
			return null;
		}
		Map<String, Object> statesToUpdate = new HashMap<>();
		statesToUpdate.put(id, true);
		for (String idOfRelated : stateConfiguration.getRelatedStateConfigurations()) {
			statesToUpdate.put(idOfRelated, false);
		}
		return updateStates(statesToUpdate);
	}

	@Scheduled(fixedRate = 1000)
	public void onStatesUpdate() {
		Map<String, Object> statesToUpdate = new HashMap<>();
		Map<String, Object> statesFromSharedMemory = sharedMemoryStateProvider.getStates();
		for (Entry<String, Object> entry : statesFromSharedMemory.entrySet()) {
			String id = entry.getKey();
			StateConfiguration stateConfiguration = stateConfigurationReader.getStateConfiguration(id);
			if (stateConfiguration != null) {
				Object newValue = entry.getValue();
				Object oldValue = stateConfigurationReader.getValue(stateConfiguration);
				if (!Objects.equals(oldValue, newValue)) {
					statesToUpdate.put(id, newValue);
					LOGGER.info("Updating " + stateConfiguration + ": " + newValue);
				}
			}
		}
		StateChangeEvent stateChangeEvent = updateStates(statesToUpdate);
		if (stateChangeEvent.getUpdatedStates().isEmpty()) {
			return;
		}
		template.convertAndSend(TOPIC_STATES_UPDATE, stateChangeEvent);
	}

	private StateChangeEvent updateStates(Map<String, ? extends Object> statesToUpdate) {
		statesToUpdate.forEach((id, value) -> {
			StateConfiguration stateConfiguration = stateConfigurationReader.getStateConfiguration(id);
			if (stateConfiguration != null) {
				stateConfigurationReader.put(stateConfiguration, value);
			}
		});
		return new StateChangeEvent(agent, statesToUpdate);
	}

}