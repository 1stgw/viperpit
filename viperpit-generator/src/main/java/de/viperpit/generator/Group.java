package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class Group extends AbstractJsonized {
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

	public String getDescription() {
		return (String) wrap(delegate.get("description"), String.class);
	}

	public void setDescription(final String description) {
		delegate.add("description", unWrap(description, String.class));
	}

	public String getLabel() {
		return (String) wrap(delegate.get("label"), String.class);
	}

	public void setLabel(final String label) {
		delegate.add("label", unWrap(label, String.class));
	}

	public String getType() {
		return (String) wrap(delegate.get("type"), String.class);
	}

	public void setType(final String type) {
		delegate.add("type", unWrap(type, String.class));
	}

	public List<Control> getControls() {
		return (List<Control>) wrap(delegate.get("control"), Control.class);
	}

	public void setControls(final List<Control> controls) {
		delegate.add("control", unWrap(controls, Control.class));
	}
}
