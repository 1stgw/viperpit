package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class PanelRow extends AbstractJsonized {
	public List<String> getGroups() {
		return (List<String>) wrap(delegate.get("group"), String.class);
	}

	public void setGroups(final List<String> groups) {
		delegate.add("group", unWrap(groups, String.class));
	}
}
