package de.viperpit.agent;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

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
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry //
				.addEndpoint("/sockets") //
				.setAllowedOrigins("*");
	}

}