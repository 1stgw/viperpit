package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class Console extends AbstractJsonized {
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

	public List<Panel> getPanels() {
		return (List<Panel>) wrap(delegate.get("panel"), Panel.class);
	}

	public void setPanels(final List<Panel> panels) {
		delegate.add("panel", unWrap(panels, Panel.class));
	}
}
