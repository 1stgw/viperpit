package de.viperpit.generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public record RoleConfigurations(Collection<RoleConfiguration> roleConfigurations) {

	public static record RoleConfiguration(String id, String role) {
	}

	public RoleConfiguration getRoleConfiguration(String id) {
		return roleConfigurations().stream().filter(it -> Objects.equals(id, it.id())).findFirst().orElse(null);
	}

	public static RoleConfigurations read(File file) {
		if (file == null || !file.exists()) {
			return new RoleConfigurations(List.of());
		}
		try {
			var list = new ArrayList<RoleConfiguration>();
			var properties = new Properties();
			properties.load(new FileReader(file));
			properties.forEach((key, value) -> list.add(new RoleConfiguration(key.toString(), value.toString())));
			return new RoleConfigurations(List.copyOf(list));
		} catch (IOException exception) {
			return new RoleConfigurations(List.of());
		}
	}

}