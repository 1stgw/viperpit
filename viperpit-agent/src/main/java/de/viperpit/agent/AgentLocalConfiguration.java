package de.viperpit.agent;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import de.viperpit.agent.keys.KeyFile;

@Configuration
@PropertySource("classpath:/agent.properties")
public class AgentLocalConfiguration {

	@Bean
	public KeyFile keyFile(@Value("${keyFile}") File file) throws IOException {
		return new KeyFile(file);
	}

}
