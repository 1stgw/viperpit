package de.viperpit.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class ServicesWebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry) {
		messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
		messageBrokerRegistry.enableSimpleBroker("/topic", "/queue");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/agents");
		registry.addEndpoint("/sockets").setAllowedOrigins("http://localhost:8080", "http://office:8080");
	}

}