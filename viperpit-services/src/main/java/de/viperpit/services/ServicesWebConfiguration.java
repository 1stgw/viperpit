package de.viperpit.services;

import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
public class ServicesWebConfiguration extends WebMvcConfigurerAdapter {

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

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		super.addCorsMappings(registry);
		registry.addMapping("/services/**").allowedOrigins("http://office:8080", "http://localhost:8080");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	ObjectMapper objectMapper() {
		ObjectMapper objectMapper = json().build();
		objectMapper.getFactory().setCharacterEscapes(new SafeCharacterEscapes());
		return objectMapper;
	}

}