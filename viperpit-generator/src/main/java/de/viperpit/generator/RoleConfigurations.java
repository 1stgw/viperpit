package de.viperpit.generator;

import java.util.Collection;
import java.util.Objects;

public class RoleConfigurations {

	private final Collection<RoleConfiguration> roleConfigurations;

	RoleConfigurations(Collection<RoleConfiguration> roleConfigurations) {
		this.roleConfigurations = roleConfigurations;
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
		RoleConfigurations other = (RoleConfigurations) obj;
		return Objects.equals(roleConfigurations, other.roleConfigurations);
	}

	public RoleConfiguration getRoleConfiguration(String id) {
		return getRoleConfigurations() //
				.stream() //
				.filter(roleConfiguration -> Objects.equals(id, roleConfiguration.getId())) //
				.findFirst() //
				.orElse(null);
	}

	public Collection<RoleConfiguration> getRoleConfigurations() {
		return roleConfigurations;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roleConfigurations);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleConfigurations [roleConfigurations=");
		builder.append(roleConfigurations);
		builder.append("]");
		return builder.toString();
	}

}