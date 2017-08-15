package de.viperpit.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import de.viperpit.commons.cockpit.State;

@Configuration
@ComponentScan("de.viperpit.services")
public class ServicesConfiguration {

	@Bean
	public State state() {
		return new State();
	}

}