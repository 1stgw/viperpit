package de.viperpit.agent;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.server.jetty.JettyRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

@Configuration
@EnableWebSocketMessageBroker
public class AgentWebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.initialize();
		messageBrokerRegistry //
				.setApplicationDestinationPrefixes("/app") //
				.enableSimpleBroker("/topic"); //
	}

	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
		registry.setTimeToFirstMessage(600_000);
	}

	@Bean
	public DefaultHandshakeHandler handshakeHandler() {
		JettyRequestUpgradeStrategy strategy = new JettyRequestUpgradeStrategy();
		strategy.addWebSocketConfigurer(configurable -> {
			configurable.setIdleTimeout(Duration.ofMinutes(10));
		});
		return new DefaultHandshakeHandler(strategy);
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry //
				.addEndpoint("/sockets") //
				.setAllowedOrigins("*");
	}

}