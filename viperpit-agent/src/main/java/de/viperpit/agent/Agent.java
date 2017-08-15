package de.viperpit.agent;

import static org.springframework.boot.Banner.Mode.OFF;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Agent {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Agent.class).bannerMode(OFF).web(false).build(args).run(args);
	}

}