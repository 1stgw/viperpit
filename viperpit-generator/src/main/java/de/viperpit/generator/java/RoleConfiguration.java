package de.viperpit.generator.java;

import java.util.Collection;
import java.util.Objects;

public class RoleConfiguration {

	private final String id;

	private final String role;

	private final String style;

	private final Collection<String> relatedCallbacks;

	RoleConfiguration(String id, String role, String style, Collection<String> relatedCallbacks) {
		this.id = id;
		this.role = role;
		this.style = style;
		this.relatedCallbacks = relatedCallbacks;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RoleConfiguration other = (RoleConfiguration) obj;
		return Objects.equals(id, other.id) && Objects.equals(relatedCallbacks, other.relatedCallbacks)
				&& Objects.equals(role, other.role) && Objects.equals(style, other.style);
	}

	public String getId() {
		return id;
	}

	public Collection<String> getRelatedCallbacks() {
		return relatedCallbacks;
	}

	public String getRole() {
		return role;
	}

	public String getStyle() {
		return style;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, relatedCallbacks, role, style);
	}

	public boolean hasRelatedCallbacks() {
		return relatedCallbacks != null && !relatedCallbacks.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleConfiguration [id=");
		builder.append(id);
		builder.append(", relatedCallbacks=");
		builder.append(relatedCallbacks);
		builder.append(", role=");
		builder.append(role);
		builder.append(", style=");
		builder.append(style);
		builder.append("]");
		return builder.toString();
	}

}
