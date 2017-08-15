package de.viperpit.commons.cockpit

import java.util.Collection
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@ToString
class State {
	@Accessors Collection<Action> actions

	transient var Map<String, Action> byCallback
	transient var Map<String, Action> byId

	def getBy(ActionEvent it) {
		return getByCallback(callback)
	}

	def getByCallback(String callback) {
		if (byCallback === null) {
			byCallback = actions.toMap([it.callback])
		}
		return byCallback.get(callback)
	}

	def getById(String id) {
		if (byId === null) {
			byId = actions.toMap([it.id])
		}
		return byId.get(id)
	}
}

@Accessors
@EqualsHashCode
@ToString
class Action {
	String id
	String callback
	boolean active
	boolean stateful
	Collection<String> relatedActions
}

@Accessors
@EqualsHashCode
@ToString
class ActionEvent {
	String callback

	new() {
	}

	new(String callback) {
		this.callback = callback
	}

}
