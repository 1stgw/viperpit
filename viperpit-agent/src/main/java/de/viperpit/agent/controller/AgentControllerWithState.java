package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import de.viperpit.agent.model.InitializeStateEvent;
import de.viperpit.agent.model.ResetStateEvent;
import de.viperpit.agent.model.StateChangeEvent;
import de.viperpit.agent.model.TriggerStateChangeEvent;
import de.viperpit.commons.cockpit.StateConfiguration;

@Controller
public class AgentControllerWithState extends AgentController {

	private static final String APP_STATES_INIT = "/cockpit/states/init";

	private static final String APP_STATES_RESET = "/cockpit/states/reset";

	private static final String APP_STATES_TRIGGER_STATE_CHANGE = "/cockpit/states/triggerStateChange";

	private static final Logger LOGGER = getLogger(AgentControllerWithState.class);

	private static final String TOPIC_STATES_UPDATE = "/topic/cockpit/states/update";

	@Autowired
	private StateProvider stateProvider;

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping(APP_STATES_INIT)
	@SendTo(TOPIC_STATES_UPDATE)
	public StateChangeEvent onStatesInit(InitializeStateEvent initializeStateEvent) {
		LOGGER.info("State intialization requested.");
		return stateProvider.initializeStates();
	}

	@MessageMapping(APP_STATES_RESET)
	@SendTo(TOPIC_STATES_UPDATE)
	public StateChangeEvent onStatesReset(ResetStateEvent resetStateEvent) {
		LOGGER.info("State reset requested.");
		return stateProvider.resetStates();
	}

	@MessageMapping(APP_STATES_TRIGGER_STATE_CHANGE)
	@SendTo(TOPIC_STATES_UPDATE)
	public StateChangeEvent onStatesToggle(TriggerStateChangeEvent triggerStateChangeEvent) {
		super.onStatesToggle(triggerStateChangeEvent);
		if (triggerStateChangeEvent == null) {
			return null;
		}
		String callback = triggerStateChangeEvent.getCallback();
		if (callback == null) {
			return null;
		}

		StateConfiguration stateConfiguration = stateProvider.getStateConfiguration(callback);
		if (stateConfiguration == null) {
			return null;
		}
		if (triggerStateChangeEvent.isStart()) {
			return null;
		} else {
			return stateProvider.toggleBooleanState(stateConfiguration);
		}
	}

	@Scheduled(fixedRate = 1000)
	public void onStatesUpdate() {
		StateChangeEvent stateChangeEvent = stateProvider.updateStatesFromSharedMemory();
		if (stateChangeEvent.getUpdatedStates().isEmpty()) {
			return;
		}
		template.convertAndSend(TOPIC_STATES_UPDATE, stateChangeEvent);
	}

}