package de.viperpit.agent;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Component
public class AgentWebSocketClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentWebSocketClient.class);

	private final AgentSessionHandler agentSessionHandler;

	public AgentWebSocketClient(AgentSessionHandler agentSessionHandler) {
		this.agentSessionHandler = agentSessionHandler;
	}

	public void connectTo(String url) {
		ExecutorService executorService = newSingleThreadExecutor();
		executorService.submit(() -> {
			ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
			taskScheduler.initialize();
			WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
			WebSocketClient webSocketClient = new StandardWebSocketClient();
			WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
			stompClient.setTaskScheduler(taskScheduler);
			stompClient.setMessageConverter(new MappingJackson2MessageConverter());
			try {
				StompSession stompSession = stompClient.connect(url, headers, agentSessionHandler).get();
				LOGGER.info("Subscribed to topic using session " + stompSession.getSessionId());
			} catch (InterruptedException | ExecutionException exception) {
				LOGGER.error("Error while establishing session: " + exception.getMessage(), exception);
			}
		});
	}

}
