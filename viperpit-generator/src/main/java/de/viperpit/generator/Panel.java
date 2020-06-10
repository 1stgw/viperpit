package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class Panel extends AbstractJsonized {
	public String getId() {
		return (String) wrap(delegate.get("id"), String.class);
	}

	public void setId(final String id) {
		delegate.add("id", unWrap(id, String.class));
	}

	public String getClazz() {
		return (String) wrap(delegate.get("class"), String.class);
	}

	public void setClazz(final String clazz) {
		delegate.add("class", unWrap(clazz, String.class));
	}

	public String getName() {
		return (String) wrap(delegate.get("name"), String.class);
	}

	public void setName(final String name) {
		delegate.add("name", unWrap(name, String.class));
	}

	public List<Group> getGroups() {
		return (List<Group>) wrap(delegate.get("group"), Group.class);
	}

	public void setGroups(final List<Group> groups) {
		delegate.add("group", unWrap(groups, Group.class));
	}
}
