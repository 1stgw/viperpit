package de.viperpit.agent;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan("de.viperpit.agent")
public class AgentConfiguration {

	@Bean
	public Properties directInputProperties(@Value("classpath:/mapping_directinput.properties") Resource resource)
			throws IOException {
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		return properties;
	}

	@Bean
	public Properties scanCodesProperties(@Value("classpath:/mapping_scancodes.properties") Resource resource)
			throws IOException {
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		return properties;
	}

}