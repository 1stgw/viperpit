package de.viperpit.generator;

@SuppressWarnings("all")
public class Control extends AbstractJsonized {
	public String getId() {
		return (String) wrap(delegate.get("id"), String.class);
	}

	public void setId(final String id) {
		delegate.add("id", unWrap(id, String.class));
	}

	public String getClazz() {
		return (String) wrap(delegate.get("clazz"), String.class);
	}

	public void setClazz(final String clazz) {
		delegate.add("clazz", unWrap(clazz, String.class));
	}

	public String getCallback() {
		return (String) wrap(delegate.get("callback"), String.class);
	}

	public void setCallback(final String callback) {
		delegate.add("callback", unWrap(callback, String.class));
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

	public String getRole() {
		return (String) wrap(delegate.get("role"), String.class);
	}

	public void setRole(final String role) {
		delegate.add("role", unWrap(role, String.class));
	}
}
