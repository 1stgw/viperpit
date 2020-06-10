package de.viperpit.generator;

import java.io.BufferedReader;
import java.io.File;
import java.util.List;

import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Jsonized("{\r\n\t\"consoleRowSet\": [\r\n\t\t{\r\n\t\t\t\"console\": \"\",\r\n\t\t\t\"consoleRow\": [\r\n\t\t\t\t{\r\n\t\t\t\t\t\"panelRowSet\": [\r\n\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t\"panel\": \"\",\r\n\t\t\t\t\t\t\t\"panelRow\": [\r\n\t\t\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t\t\t\"group\": [\"\"]\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t]\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t]\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t}\r\n\t]\r\n}")
@SuppressWarnings("all")
public class Layout extends AbstractJsonized {
	public Layout() {
	}

	public Layout(final String path) {
		try {
			final File file = new File(path);
			final BufferedReader reader = Files.newReader(file, Charsets.UTF_8);
			try {
				final JsonElement rootElement = new JsonParser().parse(reader);
				this.delegate = ((JsonObject) rootElement);
			} finally {
				if (reader != null) {
					reader.close();
				}
			}
		} catch (Throwable _e) {
			throw Exceptions.sneakyThrow(_e);
		}
	}

	public List<ConsoleRowSet> getConsoleRowSets() {
		return (List<ConsoleRowSet>) wrap(delegate.get("consoleRowSet"), ConsoleRowSet.class);
	}

	public void setConsoleRowSets(final List<ConsoleRowSet> consoleRowSets) {
		delegate.add("consoleRowSet", unWrap(consoleRowSets, ConsoleRowSet.class));
	}

	public Layout(final JsonElement delegate) {
		setDelegate((com.google.gson.JsonObject) delegate);
	}
}
