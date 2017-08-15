package de.viperpit.commons.cockpit

import java.util.Collection
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.EqualsHashCode
import org.eclipse.xtend.lib.annotations.ToString

@Accessors
@EqualsHashCode
@ToString
class Cockpit {
	String id
	String name
	Collection<Console> consoles
	Collection<Panel> panels
	Collection<Group> groups
	Collection<Control> controls
}

@Accessors
@EqualsHashCode
@ToString
class Console {
	String id
	String className
	String name
}

@Accessors
@EqualsHashCode
@ToString
class Panel {
	String id
	String className
	String name
}

@Accessors
@EqualsHashCode
@ToString
class Group {
	String id
	String className
	String description
	String label
	String type
}

@Accessors
@EqualsHashCode
@ToString
class Control {
	String id
	String className
	String description
	String label
	String role
}
