package de.viperpit.hub;

import static org.springframework.boot.Banner.Mode.OFF;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HubApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(HubApplication.class).bannerMode(OFF).build(args).run(args);
	}

}