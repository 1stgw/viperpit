package de.viperpit.generator;

import java.io.BufferedReader;
import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Jsonized("{\r\n\t\"name\": \"\",\r\n\t\"source\": \"\",\r\n\t\"action\": [\r\n\t\t{\r\n\t\t\t\"id\": \"\",\r\n\t\t\t\"callback\": \"\",\r\n\t\t\t\"relatedActions\": [\"\"],\r\n\t\t\t\"description\": \"\",\r\n\t\t\t\"category\": \"\",\r\n\t\t\t\"section\": \"\",\r\n\t\t\t\"group\": \"\",\r\n\t\t\t\"style\": \"\",\r\n\t\t\t\"role\": \"\",\r\n\t\t\t\"type\": \"\",\r\n\t\t\t\"state\" : {\r\n\t\t\t\t\"ramp\": false,\r\n\t\t\t\t\"ground\": false,\r\n\t\t\t\t\"air\": false\r\n\t\t\t}\r\n\t\t}\r\n\t]\r\n}")
@SuppressWarnings("all")
public class Configuration extends AbstractJsonized {
	private Map<String, Action> map = null;

	public Configuration() {
	}

	public Configuration(final String path) {
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

	public Action getAction(final String it) {
		if ((this.map == null)) {
			final Function1<Action, String> _function = new Function1<Action, String>() {
				public String apply(final Action it) {
					return it.getCallback();
				}
			};
			this.map = IterableExtensions.<String, Action>toMap(this.getActions(), _function);
		}
		return this.map.get(it);
	}

	public Iterable<List<Action>> getRelatedActions(final Action it) {
		final Function1<String, List<Action>> _function = new Function1<String, List<Action>>() {
			public List<Action> apply(final String it) {
				return Configuration.this.getActions();
			}
		};
		return IterableExtensions
				.<List<Action>>filterNull(ListExtensions.<String, List<Action>>map(it.getRelatedActions(), _function));
	}

	public String getName() {
		return (String) wrap(delegate.get("name"), String.class);
	}

	public void setName(final String name) {
		delegate.add("name", unWrap(name, String.class));
	}

	public String getSource() {
		return (String) wrap(delegate.get("source"), String.class);
	}

	public void setSource(final String source) {
		delegate.add("source", unWrap(source, String.class));
	}

	public List<Action> getActions() {
		return (List<Action>) wrap(delegate.get("action"), Action.class);
	}

	public void setActions(final List<Action> actions) {
		delegate.add("action", unWrap(actions, Action.class));
	}

	public Configuration(final JsonElement delegate) {
		setDelegate((com.google.gson.JsonObject) delegate);
	}
}
