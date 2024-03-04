package de.viperpit.launcher;

import static org.springframework.boot.Banner.Mode.OFF;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import de.viperpit.agent.AgentConfiguration;

@EnableCaching
@EnableScheduling
@SpringBootApplication(scanBasePackageClasses = AgentConfiguration.class)
public class LauncherApplication implements CommandLineRunner {

	public static void main(String[] args) {
		System.setProperty("java.awt.headless", "false");
		new SpringApplicationBuilder(LauncherApplication.class).headless(false).bannerMode(OFF).build(args).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}