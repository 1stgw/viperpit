package de.viperpit.agent;

import static de.viperpit.commons.Topics.APP_AGENTS_CONNECT;
import static de.viperpit.commons.Topics.APP_STATES_UPDATE;
import static de.viperpit.commons.Topics.TOPIC_STATES_FIRE;
import static de.viperpit.commons.Topics.forAgent;
import static de.viperpit.commons.Topics.forApp;

import java.lang.reflect.Type;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import de.viperpit.agent.data.SharedMemoryStateProvider;
import de.viperpit.agent.keys.KeyDispatcherService;
import de.viperpit.commons.cockpit.ActionEvent;
import de.viperpit.commons.cockpit.Agent;
import de.viperpit.commons.cockpit.StateChangeEvent;

@Component
public class AgentSessionHandler extends StompSessionHandlerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentSessionHandler.class);

	private static final int STATE_UPDATE_RATE = 1000;

	private Agent agent;

	@Value("#{environment.COMPUTERNAME}")
	private String agentId;

	@Autowired
	private KeyDispatcherService keyDispatcherService;

	private StompSession session;

	@Autowired
	private SharedMemoryStateProvider sharedMemoryStateProvider;

	@Override
	public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
		this.session = session;
		this.agent = new Agent(agentId);
		session.send(forApp(APP_AGENTS_CONNECT), agent);
		session.subscribe(forAgent(agent, TOPIC_STATES_FIRE), this);
	}

	@Override
	public Type getPayloadType(StompHeaders headers) {
		if (forAgent(agent, TOPIC_STATES_FIRE).equals(headers.getDestination())) {
			return ActionEvent.class;
		} else {
			return String.class;
		}
	}

	@Override
	public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload,
			Throwable exception) {
		LOGGER.error(exception.getMessage());
	}

	@Override
	public void handleFrame(StompHeaders headers, Object payload) {
		if (forAgent(agent, TOPIC_STATES_FIRE).equals(headers.getDestination())) {
			keyDispatcherService.fire(((ActionEvent) payload).getCallback());
		}
	}

	@Scheduled(fixedRate = STATE_UPDATE_RATE)
	public void updateStates() {
		if (session == null) {
			return;
		}
		Map<String, Object> states = sharedMemoryStateProvider.getStates();
		if (!states.isEmpty()) {
			session.send(forApp(APP_STATES_UPDATE), new StateChangeEvent(agent, states));
		}
	}

}