package de.viperpit.generator;

import java.util.List;

@SuppressWarnings("all")
public class Action extends AbstractJsonized {
	public String getId() {
		return (String) wrap(delegate.get("id"), String.class);
	}

	public void setId(final String id) {
		delegate.add("id", unWrap(id, String.class));
	}

	public String getCallback() {
		return (String) wrap(delegate.get("callback"), String.class);
	}

	public void setCallback(final String callback) {
		delegate.add("callback", unWrap(callback, String.class));
	}

	public List<String> getRelatedActions() {
		return (List<String>) wrap(delegate.get("relatedActions"), String.class);
	}

	public void setRelatedActions(final List<String> relatedActions) {
		delegate.add("relatedActions", unWrap(relatedActions, String.class));
	}

	public String getDescription() {
		return (String) wrap(delegate.get("description"), String.class);
	}

	public void setDescription(final String description) {
		delegate.add("description", unWrap(description, String.class));
	}

	public String getCategory() {
		return (String) wrap(delegate.get("category"), String.class);
	}

	public void setCategory(final String category) {
		delegate.add("category", unWrap(category, String.class));
	}

	public String getSection() {
		return (String) wrap(delegate.get("section"), String.class);
	}

	public void setSection(final String section) {
		delegate.add("section", unWrap(section, String.class));
	}

	public String getGroup() {
		return (String) wrap(delegate.get("group"), String.class);
	}

	public void setGroup(final String group) {
		delegate.add("group", unWrap(group, String.class));
	}

	public String getStyle() {
		return (String) wrap(delegate.get("style"), String.class);
	}

	public void setStyle(final String style) {
		delegate.add("style", unWrap(style, String.class));
	}

	public String getRole() {
		return (String) wrap(delegate.get("role"), String.class);
	}

	public void setRole(final String role) {
		delegate.add("role", unWrap(role, String.class));
	}

	public String getType() {
		return (String) wrap(delegate.get("type"), String.class);
	}

	public void setType(final String type) {
		delegate.add("type", unWrap(type, String.class));
	}

	public State getState() {
		return (State) wrap(delegate.get("state"), State.class);
	}

	public void setState(final State state) {
		delegate.add("state", unWrap(state, State.class));
	}
}
