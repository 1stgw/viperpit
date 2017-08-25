package de.viperpit.generator

import java.io.File
import org.slf4j.LoggerFactory

class Generator {

	static val LOGGER = LoggerFactory.getLogger(Generator)

	static def void main(String[] args) {
		if (args.size !== 1) {
			throw new IllegalArgumentException('''One Path parameters have to be set (<workspace>).''')
		}
		run(newArrayList(args), "f16")
		run(newArrayList(args), "f35")
	}

	private static def run(String[] args, String profile) {
		LOGGER.info("Running the Filter Generator...")
		val workspace = args.head.toPath
		val source = '''«args.head»/viperpit-generator/src/main/resources/«profile»'''.toPath
//		LOGGER.info("Running the State Generator...")
//		new StateGenerator().run(source)
//		LOGGER.info("Running the Filter Generator...")
//		new FilterGenerator().run(source)
		LOGGER.info("Running the Configuration Generator...")
		new ConfigurationGenerator().run(source)
		LOGGER.info("Running the Cockpit Generator...")
		new CockpitGenerator().run(source)
		LOGGER.info("Running the Layout Generator...")
		new LayoutGenerator().run(source)
		LOGGER.info("Running the Web Application Generator...")
		new WebApplicationGenerator().run(workspace, profile)
	}

	private static def toPath(CharSequence it) {
		toString.toPath
	}

	private static def toPath(String pathArgument) {
		if (pathArgument.nullOrEmpty) {
			throw new IllegalArgumentException('''Path is not set or empty.''')
		}
		val path = new File(pathArgument)
		if (path.exists && !path.directory) {
			throw new IllegalArgumentException('''Path is not a directory.''')
		}
		path.mkdirs
		return path
	}

}
