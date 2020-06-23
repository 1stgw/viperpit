package de.viperpit.agent;

import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan("de.viperpit.agent")
@PropertySource("classpath:/agent.properties")
public class AgentConfiguration {

	@SuppressWarnings("serial")
	public static class SafeCharacterEscapes extends CharacterEscapes {

		private final int[] escapedCharacters;

		public SafeCharacterEscapes() {
			int[] escapedCharacters = standardAsciiEscapesForJSON();
			escapedCharacters['<'] = ESCAPE_STANDARD;
			escapedCharacters['>'] = ESCAPE_STANDARD;
			escapedCharacters['&'] = ESCAPE_STANDARD;
			escapedCharacters['\''] = ESCAPE_STANDARD;
			this.escapedCharacters = escapedCharacters;
		}

		@Override
		public int[] getEscapeCodesForAscii() {
			return escapedCharacters;
		}

		@Override
		public SerializableString getEscapeSequence(int character) {
			return null;
		}

	}

	@Bean
	public Properties directInputProperties(@Value("classpath:/mapping_directinput.properties") Resource resource)
			throws IOException {
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		return properties;
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = json().build();
		objectMapper.getFactory().setCharacterEscapes(new SafeCharacterEscapes());
		return objectMapper;
	}

	@Bean
	public Properties scanCodesProperties(@Value("classpath:/mapping_scancodes.properties") Resource resource)
			throws IOException {
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		return properties;
	}

}