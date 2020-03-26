package de.viperpit.hub.cockpit;

import static de.viperpit.commons.Topics.APP_AGENTS_CONNECT;
import static de.viperpit.commons.Topics.APP_STATES_UPDATE;
import static de.viperpit.commons.Topics.TOPIC_AGENTS_CONNECT;
import static de.viperpit.commons.Topics.TOPIC_AGENTS_DISCONNECT;
import static de.viperpit.commons.Topics.TOPIC_STATES_FIRE;
import static de.viperpit.commons.Topics.TOPIC_STATES_UPDATE;
import static de.viperpit.commons.Topics.forAgent;
import static org.springframework.messaging.simp.stomp.StompHeaderAccessor.wrap;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import de.viperpit.commons.cockpit.ActionEvent;
import de.viperpit.commons.cockpit.Agent;
import de.viperpit.commons.cockpit.State;
import de.viperpit.commons.cockpit.StateChangeEvent;

@Controller
public class CockpitController implements ApplicationListener<ApplicationEvent> {

	@Autowired
	private CockpitService cockpitService;

	@Autowired
	private SimpMessagingTemplate template;

	@RequestMapping(value = "/services/cockpit/states/fire/{agentId}/{callback}", method = POST)
	public @ResponseBody void fire(@PathVariable String agentId, @PathVariable String callback) {
		if (agentId == null) {
			return;
		}
		if (callback == null) {
			return;
		}
		Agent agent = cockpitService.getAgentById(agentId);
		if (agent == null) {
			return;
		}
		template.convertAndSend(forAgent(agent, TOPIC_STATES_FIRE), new ActionEvent(callback));
	}

	@RequestMapping(value = "/services/cockpit/agents/load", method = GET)
	public @ResponseBody Collection<Agent> loadAgents() {
		return cockpitService.getAgents();
	}

	@RequestMapping(value = "/services/cockpit/states/load/{agentId}/{preset}", method = GET)
	public @ResponseBody State loadState(@PathVariable String agentId, @PathVariable String preset) {
		if (agentId == null) {
			return null;
		}
		if (preset == null) {
			return null;
		}
		Agent agent = cockpitService.getAgentById(agentId);
		if (agent == null) {
			return null;
		}
		return cockpitService.load(agent, preset);
	}

	@SendTo(TOPIC_AGENTS_CONNECT)
	@MessageMapping(APP_AGENTS_CONNECT)
	public Agent onAgentConnect(Agent agent, StompHeaderAccessor stompHeaderAccessor) throws Exception {
		cockpitService.connect(stompHeaderAccessor.getSessionId(), agent);
		return agent;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof SessionDisconnectEvent) {
			SessionDisconnectEvent sessionConnectedEvent = (SessionDisconnectEvent) event;
			StompHeaderAccessor stompHeaderAccessor = wrap(sessionConnectedEvent.getMessage());
			Agent agent = cockpitService.getAgentBySessionId(stompHeaderAccessor.getSessionId());
			if (agent != null) {
				cockpitService.disconnect(stompHeaderAccessor.getSessionId());
				template.convertAndSend(TOPIC_AGENTS_DISCONNECT, agent);
			}
		}
	}

	@SendTo(TOPIC_STATES_UPDATE)
	@MessageMapping(APP_STATES_UPDATE)
	public StateChangeEvent onStatesUpdate(StateChangeEvent stateChangeEvent, StompHeaderAccessor stompHeaderAccessor)
			throws Exception {
		Agent agent = cockpitService.getAgentBySessionId(stompHeaderAccessor.getSessionId());
		if (agent != null) {
			return stateChangeEvent;
		}
		return null;
	}

}