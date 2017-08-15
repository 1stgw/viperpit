package de.viperpit.commons;

import de.viperpit.commons.cockpit.Agent;

public class Topics {

	public static final String APP_AGENTS_CONNECT = "/cockpit/agents/connect";

	public static final String APP_STATES_UPDATE = "/cockpit/states/update";

	public static final String TOPIC_AGENTS_CONNECT = "/topic/cockpit/agents/connect";

	public static final String TOPIC_AGENTS_DISCONNECT = "/topic/cockpit/agents/disconnect";

	public static final String TOPIC_STATES_FIRE = "/topic/cockpit/states/fire";

	public static final String TOPIC_STATES_UPDATE = "/topic/cockpit/states/update";

	public static String forAgent(Agent agent, String destination) {
		return destination + "/" + agent.getId();
	}

	public static String forApp(String destination) {
		return "/app" + destination;
	}

}
