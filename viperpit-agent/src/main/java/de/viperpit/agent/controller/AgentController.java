package de.viperpit.agent.controller;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import de.viperpit.agent.keys.KeyDispatcherService;
import de.viperpit.agent.model.InitializeStateEvent;
import de.viperpit.agent.model.ResetStateEvent;
import de.viperpit.agent.model.StateChangeEvent;
import de.viperpit.agent.model.TriggerStateChangeEvent;
import de.viperpit.commons.cockpit.StateConfiguration;

@Controller
public class AgentController implements ApplicationListener<ApplicationEvent> {

	private static final String APP_STATES_INIT = "/cockpit/states/init";

	private static final String APP_STATES_RESET = "/cockpit/states/reset";

	private static final String APP_STATES_TRIGGER_STATE_CHANGE = "/cockpit/states/triggerStateChange";

	private static final Logger LOGGER = getLogger(AgentController.class);

	private static final String TOPIC_STATES_UPDATE = "/topic/cockpit/states/update";

	@Autowired
	private KeyDispatcherService keyDispatcherService;

	@Autowired
	private StateProvider stateProvider;

	@Autowired
	private SimpMessagingTemplate template;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		LOGGER.debug(event.toString());
	}

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
		if (triggerStateChangeEvent == null) {
			return null;
		}
		String callback = triggerStateChangeEvent.getCallback();
		StateConfiguration stateConfiguration = stateProvider.getStateConfiguration(callback);
		if (stateConfiguration == null) {
			return null;
		}
		if (triggerStateChangeEvent.isStart()) {
			keyDispatcherService.keyDown(callback);
			return null;
		} else {
			keyDispatcherService.keyUp(callback);
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