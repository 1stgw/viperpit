package de.viperpit.agent;

import static de.viperpit.agent.Topics.APP_STATES_UPDATE;
import static de.viperpit.agent.Topics.TOPIC_STATES_INIT;
import static de.viperpit.agent.Topics.TOPIC_STATES_TOGGLE;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.viperpit.agent.data.SharedMemoryStateProvider;
import de.viperpit.agent.keys.KeyDispatcherService;
import de.viperpit.agent.model.Agent;
import de.viperpit.agent.model.InitializeStateEvent;
import de.viperpit.agent.model.StateChangeEvent;
import de.viperpit.agent.model.ToggleStateEvent;
import de.viperpit.commons.cockpit.StateConfiguration;
import de.viperpit.commons.cockpit.StateConfigurationStore;

@Component
public class AgentSessionHandler extends StompSessionHandlerAdapter {

	private static final int CONNECTION_RATE = 1000;

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentSessionHandler.class);

	private static final int STATE_UPDATE_RATE = 1000;

	private final Agent agent;

	@Autowired
	private KeyDispatcherService keyDispatcherService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	private SharedMemoryStateProvider sharedMemoryStateProvider;

	private StateConfigurationStore stateConfigurationStore;

	private final Map<StateConfiguration, Object> states = new HashMap<>();

	private StompSession stompSession;

	@Value("${url}")
	private String url;

	public AgentSessionHandler(@Value("#{environment.COMPUTERNAME}") String agentId) {
		this.agent = new Agent(agentId);
	}

	@Override
	public void afterConnected(StompSession stompSession, StompHeaders connectedHeaders) {
		LOGGER.info("Established session " + stompSession.getSessionId());
		this.stompSession = stompSession;
		stompSession.subscribe(TOPIC_STATES_INIT, new StompFrameHandler() {

			@Override
			public Type getPayloadType(StompHeaders headers) {
				return InitializeStateEvent.class;
			}

			@Override
			public void handleFrame(StompHeaders headers, Object payload) {
				LOGGER.info("State intialization requested.");
				updateStates(false);
			}

		});
		stompSession.subscribe(TOPIC_STATES_TOGGLE, new StompFrameHandler() {

			@Override
			public Type getPayloadType(StompHeaders headers) {
				return ToggleStateEvent.class;
			}

			@Override
			public void handleFrame(StompHeaders headers, Object payload) {
				if (payload == null) {
					return;
				}
				if (stateConfigurationStore == null) {
					return;
				}
				String id = ((ToggleStateEvent) payload).getId();
				StateConfiguration stateConfiguration = stateConfigurationStore.getById(id);
				if (stateConfiguration == null) {
					return;
				}
				keyDispatcherService.fire(stateConfiguration.getCallback());
				if (stateConfiguration.isStateful()) {
					Map<String, Object> statesToUpdate = new HashMap<>();
					statesToUpdate.put(id, true);
					for (String idOfRelated : stateConfiguration.getRelatedStateConfigurations()) {
						statesToUpdate.put(idOfRelated, false);
					}
					updateStates(statesToUpdate);
				}
			}

		});
	}

	@Scheduled(fixedRate = CONNECTION_RATE)
	public void connectToWebSocket() {
		if (stompSession != null && stompSession.isConnected()) {
			return;
		}
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.initialize();
		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);
		webSocketStompClient.setTaskScheduler(taskScheduler);
		webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());
		webSocketStompClient.setInboundMessageSizeLimit(1024 * 1024);
		WebSocketHttpHeaders webSocketHttpHeaders = new WebSocketHttpHeaders();
		StompHeaders stompHeaders = new StompHeaders();
		stompHeaders.set("agent-id", agent.getId());
		try {
			webSocketStompClient.connect(url, webSocketHttpHeaders, stompHeaders, this).get();
		} catch (InterruptedException | ExecutionException exception) {
			LOGGER.error("Error while establishing session: " + exception.getMessage());
		}
	}

	private String getStateFileName(String preset) {
		switch (preset) {
		case "ramp":
			return "classpath:/states_ramp.json";
		case "ground":
			return "classpath:/states_ground.json";
		case "air":
			return "classpath:/states_air.json";
		default:
			return null;
		}
	}

	@Override
	public void handleException(StompSession stompSession, StompCommand command, StompHeaders headers, byte[] payload,
			Throwable exception) {
		LOGGER.error("WebSocket error: " + exception.getMessage());
	}

	@PostConstruct
	private void initialize() {
		String location = getStateFileName("ramp");
		if (location != null) {
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
	}

	@Scheduled(fixedRate = STATE_UPDATE_RATE)
	public void updateStates() {
		updateStates(true);
	}

	private void updateStates(boolean modifiedOnly) {
		if (stompSession == null) {
			return;
		}
		if (!stompSession.isConnected()) {
			return;
		}
		Map<String, Object> statesToUpdate = new HashMap<>();
		if (!modifiedOnly) {
			for (Entry<StateConfiguration, Object> entry : states.entrySet()) {
				statesToUpdate.put(entry.getKey().getId(), entry.getValue());
			}
		}
		Map<String, Object> statesFromSharedMemory = sharedMemoryStateProvider.getStates();
		for (Entry<String, Object> entry : statesFromSharedMemory.entrySet()) {
			String id = entry.getKey();
			StateConfiguration stateConfiguration = stateConfigurationStore.getById(id);
			if (stateConfiguration != null) {
				Object newValue = entry.getValue();
				Object oldValue = states.get(stateConfiguration);
				if (!Objects.equals(oldValue, newValue)) {
					statesToUpdate.put(id, newValue);
				}
			}
		}
		updateStates(statesToUpdate);
	}

	private void updateStates(Map<String, ? extends Object> statesToUpdate) {
		if (statesToUpdate.isEmpty()) {
			return;
		}
		statesToUpdate.forEach((id, value) -> {
			StateConfiguration stateConfiguration = stateConfigurationStore.getById(id);
			if (stateConfiguration != null) {
				states.put(stateConfiguration, value);
			}
		});
		stompSession.send(APP_STATES_UPDATE, new StateChangeEvent(agent, statesToUpdate));
	}

}