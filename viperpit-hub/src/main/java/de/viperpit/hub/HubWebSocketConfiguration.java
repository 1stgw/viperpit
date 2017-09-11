package de.viperpit.hub;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class HubWebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
		// @formatter:off
		messageBrokerRegistry
			.setApplicationDestinationPrefixes("/app")
			.enableSimpleBroker("/topic", "/queue")
			.setTaskScheduler(new DefaultManagedTaskScheduler());
		// @formatter:on
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/agents");
		registry.addEndpoint("/sockets").setAllowedOrigins("http://localhost:8080", "http://office:8080");
	}

}