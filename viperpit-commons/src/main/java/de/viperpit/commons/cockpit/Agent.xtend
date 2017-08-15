package de.viperpit.commons.cockpit

import org.eclipse.xtend.lib.annotations.Data

@Data
class Agent {

	new() {
		this.id = null
	}

	new(String id) {
		this.id = id
	}

	String id
}
