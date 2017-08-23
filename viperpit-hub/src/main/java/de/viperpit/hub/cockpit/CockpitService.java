package de.viperpit.hub.cockpit;

import static com.google.common.base.CharMatcher.JAVA_LETTER_OR_DIGIT;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.viperpit.commons.cockpit.Action;
import de.viperpit.commons.cockpit.Agent;
import de.viperpit.commons.cockpit.State;

@Component
public class CockpitService {

	private Map<String, String> agentIdsBySessionId = newHashMap();

	private Map<String, Agent> agents = newHashMap();

	private Logger logger = LoggerFactory.getLogger(CockpitService.class);

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ResourceLoader resourceLoader;

	private Map<Agent, State> states = newHashMap();

	public void connect(String sessionId, Agent agent) {
		agentIdsBySessionId.put(sessionId, agent.getId());
		agents.put(agent.getId(), agent);
	}

	public void disconnect(String sessionId) {
		Agent agent = getAgentBySessionId(sessionId);
		if (agent != null) {
			states.remove(agent);
			agents.remove(agent.getId());
			agentIdsBySessionId.remove(sessionId);
		}
	}

	public Agent getAgentById(String agentId) {
		return agents.get(agentId);
	}

	public Agent getAgentBySessionId(String sessionId) {
		String agentId = agentIdsBySessionId.get(sessionId);
		return agents.get(agentId);
	}

	public Collection<Agent> getAgents() {
		return agents.values();
	}

	public State load(Agent agent, String preset) {
		if (agent == null) {
			return null;
		}
		if (preset == null) {
			return null;
		}
		State state = states.get(agent);
		if (state == null) {
			String location = "classpath:/states_" + JAVA_LETTER_OR_DIGIT.retainFrom(preset) + ".json";
			Resource resource = resourceLoader.getResource(location);
			if (resource.exists()) {
				try {
					Collection<Action> actions = objectMapper.readValue(resource.getInputStream(), State.class).getActions();
					state = new State(agent, actions);
					states.put(agent, state);
				} catch (IOException exception) {
					logger.error("Error while loading: " + location, exception);
				}
			} else {
				logger.error("State file in " + location + " could not be loaded");
			}
		}
		return state;
	}

	public State toggle(Agent agent, String callback) {
		if (agent == null) {
			return null;
		}
		if (callback == null) {
			return null;
		}
		State state = states.get(agent);
		if (state == null) {
			return null;
		}
		Action action = state.getByCallback(callback);
		if (action == null || !action.isStateful() || action.isActive()) {
			return null;
		}
		boolean active = !action.isActive();
		action.setActive(active);
		List<Action> affectedActions = newArrayList();
		affectedActions.add(action);
		for (String relatedActionId : action.getRelatedActions()) {
			Action relatedAction = state.getById(relatedActionId);
			if (relatedAction != null) {
				relatedAction.setActive(!active);
				affectedActions.add(relatedAction);
			}
		}
		return new State(agent, affectedActions);
	}

}
