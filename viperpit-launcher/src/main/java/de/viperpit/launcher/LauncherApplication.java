package de.viperpit.launcher;

import static org.springframework.boot.Banner.Mode.OFF;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import de.viperpit.agent.AgentConfiguration;
import de.viperpit.hub.HubConfiguration;

@SpringBootApplication(scanBasePackageClasses = { HubConfiguration.class, AgentConfiguration.class })
public class LauncherApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LauncherApplication.class).bannerMode(OFF).build(args).run(args);
	}

}