package de.viperpit.launcher;

import static org.springframework.boot.Banner.Mode.OFF;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import de.viperpit.agent.AgentConfiguration;

@EnableScheduling
@SpringBootApplication(scanBasePackageClasses = { AgentConfiguration.class })
public class LauncherApplication implements CommandLineRunner {

	public static void main(String[] args) {
		new SpringApplicationBuilder(LauncherApplication.class).bannerMode(OFF).build(args).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}