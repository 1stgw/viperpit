package de.viperpit.generator;

import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Charsets;
import com.google.common.collect.Iterables;
import com.google.common.io.Files;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Jsonized("{\r\n\t\"console\": [\r\n\t\t{\r\n\t\t\t\"id\": \"\",\r\n\t\t\t\"class\": \"\",\r\n\t\t\t\"name\": \"\",\r\n\t\t\t\"panel\": [\r\n\t\t\t\t{\r\n\t\t\t\t\t\"id\": \"\",\r\n\t\t\t\t\t\"class\": \"\",\r\n\t\t\t\t\t\"name\": \"\",\r\n\t\t\t\t\t\"group\": \r\n\t\t\t\t\t[\r\n\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t\"id\": \"\",\r\n\t\t\t\t\t\t\t\"class\": \"\",\r\n\t\t\t\t\t\t\t\"description\": \"\",\r\n\t\t\t\t\t\t\t\"label\": \"\",\r\n\t\t\t\t\t\t\t\"type\": \"\",\r\n\t\t\t\t\t\t\t\"control\": \r\n\t\t\t\t\t\t\t[\r\n\t\t\t\t\t\t\t\t{\r\n\t\t\t\t\t\t\t\t\t\"id\": \"\",\r\n\t\t\t\t\t\t\t\t\t\"clazz\": \"\",\r\n\t\t\t\t\t\t\t\t\t\"callback\": \"\",\r\n\t\t\t\t\t\t\t\t\t\"description\": \"\",\r\n\t\t\t\t\t\t\t\t\t\"label\": \"\",\r\n\t\t\t\t\t\t\t\t\t\"role\": \"\"\r\n\t\t\t\t\t\t\t\t}\r\n\t\t\t\t\t\t\t]\r\n\t\t\t\t\t\t}\r\n\t\t\t\t\t]\r\n\t\t\t\t}\r\n\t\t\t]\r\n\t\t}\r\n\t]\r\n}")
@SuppressWarnings("all")
public class Cockpit extends AbstractJsonized {
	private Map<String, Console> consolesMap = null;

	private Map<String, Panel> panelsMap = null;

	private Map<String, Group> groupsMap = null;

	public Cockpit() {
	}

	public Cockpit(final String path) {
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

	public Console getConsole(final String it) {
		if ((this.consolesMap == null)) {
			final Function1<Console, String> _function = new Function1<Console, String>() {
				public String apply(final Console it) {
					return it.getId();
				}
			};
			this.consolesMap = IterableExtensions.<String, Console>toMap(this.getConsoles(), _function);
		}
		return this.consolesMap.get(it);
	}

	public Iterable<Control> getControls() {
		List<Control> _xblockexpression = null;
		{
			final LinkedHashSet<Control> result = CollectionLiterals.<Control>newLinkedHashSet();
			final Consumer<Group> _function = new Consumer<Group>() {
				public void accept(final Group group) {
					List<Control> _controls = group.getControls();
					Iterables.<Control>addAll(result, _controls);
				}
			};
			this.getGroups().forEach(_function);
			_xblockexpression = IterableExtensions.<Control>toList(result);
		}
		return _xblockexpression;
	}

	public Group getGroup(final String it) {
		if ((this.groupsMap == null)) {
			final Function1<Group, String> _function = new Function1<Group, String>() {
				public String apply(final Group it) {
					return it.getId();
				}
			};
			this.groupsMap = IterableExtensions.<String, Group>toMap(this.getGroups(), _function);
		}
		return this.groupsMap.get(it);
	}

	public Iterable<Group> getGroups() {
		List<Group> _xblockexpression = null;
		{
			final LinkedHashSet<Group> result = CollectionLiterals.<Group>newLinkedHashSet();
			final Consumer<Panel> _function = new Consumer<Panel>() {
				public void accept(final Panel panel) {
					List<Group> _groups = panel.getGroups();
					Iterables.<Group>addAll(result, _groups);
				}
			};
			this.getPanels().forEach(_function);
			_xblockexpression = IterableExtensions.<Group>toList(result);
		}
		return _xblockexpression;
	}

	public Panel getPanel(final String it) {
		if ((this.panelsMap == null)) {
			final Function1<Panel, String> _function = new Function1<Panel, String>() {
				public String apply(final Panel it) {
					return it.getId();
				}
			};
			this.panelsMap = IterableExtensions.<String, Panel>toMap(this.getPanels(), _function);
		}
		return this.panelsMap.get(it);
	}

	public Iterable<Panel> getPanels() {
		List<Panel> _xblockexpression = null;
		{
			final LinkedHashSet<Panel> result = CollectionLiterals.<Panel>newLinkedHashSet();
			final Consumer<Console> _function = new Consumer<Console>() {
				public void accept(final Console console) {
					List<Panel> _panels = console.getPanels();
					Iterables.<Panel>addAll(result, _panels);
				}
			};
			this.getConsoles().forEach(_function);
			_xblockexpression = IterableExtensions.<Panel>toList(result);
		}
		return _xblockexpression;
	}

	public Iterable<String> getRoles() {
		final Function1<Control, String> _function = new Function1<Control, String>() {
			public String apply(final Control it) {
				return it.getRole();
			}
		};
		List<String> _sort = IterableExtensions.<String>sort(IterableExtensions
				.<String>toList(IterableExtensions.<Control, String>map(this.getControls(), _function)));
		return new LinkedHashSet<String>(_sort);
	}

	public Iterable<String> getTypes() {
		final Function1<Group, String> _function = new Function1<Group, String>() {
			public String apply(final Group it) {
				return it.getType();
			}
		};
		List<String> _sort = IterableExtensions.<String>sort(
				IterableExtensions.<String>toList(IterableExtensions.<Group, String>map(this.getGroups(), _function)));
		return new LinkedHashSet<String>(_sort);
	}

	public List<Console> getConsoles() {
		return (List<Console>) wrap(delegate.get("console"), Console.class);
	}

	public void setConsoles(final List<Console> consoles) {
		delegate.add("console", unWrap(consoles, Console.class));
	}

	public Cockpit(final JsonElement delegate) {
		setDelegate((com.google.gson.JsonObject) delegate);
	}
}
