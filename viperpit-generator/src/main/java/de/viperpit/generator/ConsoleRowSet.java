package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class ConsoleRowSet extends AbstractJsonized {
	public String getConsole() {
		return (String) wrap(delegate.get("console"), String.class);
	}

	public void setConsole(final String console) {
		delegate.add("console", unWrap(console, String.class));
	}

	public List<ConsoleRow> getConsoleRows() {
		return (List<ConsoleRow>) wrap(delegate.get("consoleRow"), ConsoleRow.class);
	}

	public void setConsoleRows(final List<ConsoleRow> consoleRows) {
		delegate.add("consoleRow", unWrap(consoleRows, ConsoleRow.class));
	}
}
