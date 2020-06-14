package de.viperpit.generator.java;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;
import static com.fasterxml.jackson.core.JsonEncoding.UTF8;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileWriter {

	public static void writeObject(File file, Object object) throws IOException {
		var objectMapper = new ObjectMapper();
		objectMapper.setVisibility(FIELD, ANY);
		JsonGenerator jsonGenerator = new JsonFactoryBuilder() //
				.build() //
				.createGenerator(file, UTF8) //
				.setCodec(objectMapper) //
				.useDefaultPrettyPrinter();
		jsonGenerator.writeObject(object);
	}

}
