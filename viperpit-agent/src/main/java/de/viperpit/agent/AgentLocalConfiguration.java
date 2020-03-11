package de.viperpit.agent;

import static com.google.common.base.Charsets.ISO_8859_1;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import de.viperpit.agent.keys.KeyFile;

@Configuration
@PropertySource("classpath:/agent.properties")
public class AgentLocalConfiguration {

	@Bean
	public KeyFile keyFile(@Value("${keyFile}") Resource resource) throws IOException {
		return new KeyFile(resource.getFile(), ISO_8859_1);
	}

}
