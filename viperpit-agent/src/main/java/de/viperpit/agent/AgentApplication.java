package de.viperpit.agent;

import static org.springframework.boot.Banner.Mode.OFF;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AgentApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AgentApplication.class).bannerMode(OFF).web(false).build(args).run(args);
	}

}