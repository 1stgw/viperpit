package de.viperpit.agent;

import static java.util.concurrent.Executors.newSingleThreadExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Component
public class AgentCommandLineRunner implements CommandLineRunner {

	@Autowired
	private AgentSessionHandler agentSessionHandler;

	private static final Logger LOGGER = LoggerFactory.getLogger(AgentCommandLineRunner.class);

	public void run(String... args) {
		ExecutorService executorService = newSingleThreadExecutor();
		executorService.submit(() -> {
			WebSocketHttpHeaders headers = new WebSocketHttpHeaders();
			WebSocketClient webSocketClient = new StandardWebSocketClient();
			WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
			stompClient.setMessageConverter(new MappingJackson2MessageConverter());
			String url = "ws://{host}:{port}/viperpit/agents";
			try {
				StompSession stompSession = stompClient.connect(url, headers, agentSessionHandler, "localhost", 9000)
						.get();
				LOGGER.info("Subscribing to topic using session " + stompSession.getSessionId());
				while (stompSession.isConnected()) {
				}
			} catch (InterruptedException | ExecutionException exception) {
				LOGGER.error("Error while establishing session: " + exception.getMessage(), exception);
			}
		});
	}

}
