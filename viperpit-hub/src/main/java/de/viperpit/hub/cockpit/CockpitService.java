package de.viperpit.hub.cockpit;

import static com.google.common.base.CharMatcher.javaLetterOrDigit;
import static com.google.common.collect.Maps.newHashMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
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

	public void connect(String sessionId, Agent agent) {
		agentIdsBySessionId.put(sessionId, agent.getId());
		agents.put(agent.getId(), agent);
	}

	public void disconnect(String sessionId) {
		Agent agent = getAgentBySessionId(sessionId);
		if (agent != null) {
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
		@SuppressWarnings("deprecation")
		String location = "classpath:/states_" + javaLetterOrDigit().retainFrom(preset) + ".json";
		Resource resource = resourceLoader.getResource(location);
		if (resource.exists()) {
			try (InputStream inputStream = resource.getInputStream()) {
				Collection<Action> actions = objectMapper.readValue(inputStream, State.class).getActions();
				return new State(agent, actions);
			} catch (IOException exception) {
				logger.error("Error while loading: " + location, exception);
			}
		} else {
			logger.error("State file in " + location + " could not be loaded");
		}
		return null;
	}

}
