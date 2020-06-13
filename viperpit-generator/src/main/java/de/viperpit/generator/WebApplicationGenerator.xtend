package de.viperpit.generator

import de.viperpit.commons.cockpit.Console
import de.viperpit.commons.cockpit.Control
import de.viperpit.commons.cockpit.Group
import de.viperpit.commons.cockpit.Panel
import de.viperpit.commons.cockpit.StateConfiguration
import de.viperpit.commons.cockpit.StateConfigurationStore
import java.io.File
import org.slf4j.LoggerFactory
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT
import static com.google.common.base.Charsets.UTF_8
import static de.viperpit.generator.GeneratorUtils.write

class WebApplicationGenerator {

	static val LOGGER = LoggerFactory.getLogger(WebApplicationGenerator)

	def run(File path, String profile) throws Exception {
		LOGGER.info("Running the Generator.")
		val metadataPath = '''«path.absolutePath»/viperpit-generator/src/main/resources/«profile»'''
		val configuration = new Configuration('''«metadataPath»/configuration.json''')
		val cockpit = new Cockpit('''«metadataPath»/cockpit.json''')
		val layout = new Layout('''«metadataPath»/layout.json''')
		if (configuration !== null && cockpit !== null && layout !== null) {
			LOGGER.info("Found files and loading entries.")
			generate(path, profile, configuration, cockpit, layout)
			LOGGER.info("Generator has finished successfully.")
		} else {
			LOGGER.error("Files could not be loaded")
		}
	}

	private def generate(File path, String profile, Configuration configuration, Cockpit cockpit, Layout layout) {
		val pathForModule = new File('''«path.absolutePath»/viperpit-web/src/components/«profile»''')
		pathForModule.mkdirs
		val pathForStates = new File('''«path.absolutePath»/viperpit-agent/src/main/java''')
		pathForStates.mkdirs
		val pathForStateProvider = new File('''«pathForStates»/de/viperpit/agent/data''')
		pathForStateProvider.mkdirs
		val statefulActions = configuration.actions.filter[state !== null].sortBy[id]
		write('''
			package de.viperpit.agent.data;
			
			import static com.google.common.collect.Lists.newArrayList;
			
			import java.util.Collection;
			import java.util.LinkedHashMap;
			import java.util.Map;
			
			import org.springframework.beans.factory.annotation.Autowired;
			import org.springframework.stereotype.Component;
			
			import de.viperpit.agent.data.SharedMemoryReader.SharedMemoryData;
			
			@Component
			public abstract class AbstractSharedMemoryStateProvider implements StateProvider {
			
				private static final Collection<String> STATES = newArrayList(
					«FOR action : statefulActions SEPARATOR "," + System.lineSeparator»"«action.id»"«ENDFOR»
				);
			
				@Autowired
				private SharedMemoryReader sharedMemoryReader;
			
				@Override
				public Map<String, Object> getStates() {
					Map<String, Object> states = new LinkedHashMap<>(STATES.size());
					SharedMemoryData sharedMemoryData = sharedMemoryReader.readData();
					if (sharedMemoryData != null) {
						for (String id : STATES) {
							Object state = getStateFromSharedMemory(id, sharedMemoryData);
							if (state != null) {
								states.put(id, state);
							}
						}
					}
					return states;
				}
			
				protected Object getStateFromSharedMemory(String id, SharedMemoryData sharedMemoryData) {
					switch (id) {
						«FOR action : statefulActions»
							case "«action.id»":
								return get«action.id.toFirstUpper»(id, sharedMemoryData);
						«ENDFOR»
						default:
							return null;
					}
				}
			
				«FOR action : statefulActions»
					protected Object get«action.id.toFirstUpper»(String id, SharedMemoryData sharedMemoryData) {
						return null;
					}
					
				«ENDFOR»
				}
		''', new File(pathForStateProvider, '''AbstractSharedMemoryStateProvider.java'''.toString), UTF_8)

		val pathForMetadata = new File('''«path.absolutePath»/viperpit-agent/src/main/resources''')
		val builder = new Jackson2ObjectMapperBuilder()
		builder.featuresToEnable(INDENT_OUTPUT)
		val extension objectMapper = builder.build
		val cockpitConfiguration = new de.viperpit.commons.cockpit.Cockpit() => [
			id = profile
			name = profile.toFirstUpper
			consoles = cockpit.consoles.map [ console |
				new Console() => [
					id = console.id
					className = console.clazz
					name = console.name
				]
			].toList
			panels = cockpit.panels.map [ panel |
				new Panel() => [
					id = panel.id
					className = panel.clazz
					name = panel.name
				]
			].toList
			groups = cockpit.groups.map [ group |
				new Group() => [
					id = group.id
					className = group.clazz
					description = group.description
					label = group.label
					type = group.type
				]
			].toList
			controls = cockpit.controls.map [ control |
				new Control() => [
					id = control.id
					className = control.clazz
					description = control.description
					label = control.label
					role = control.role
				]
			].toList
		]
		write(cockpitConfiguration.writeValueAsString, new File(pathForMetadata, '''configuration_cockpit.json'''.toString), UTF_8)
		val stateConfigurationsForRamp = configuration.actions.map [ action |
			new StateConfiguration() => [
				id = action.id
				callback = action.callback
				if (action.state !== null) {
					active = action.state.ramp
					stateful = true
				} else {
					active = false
					stateful = false
				}
				relatedStateConfigurations = action.relatedActions
			]
		].toList
		val stateConfigurationStoreForRamp = new StateConfigurationStore(stateConfigurationsForRamp) => []
		write(stateConfigurationStoreForRamp.writeValueAsString, new File(pathForMetadata, '''states_ramp.json'''.toString), UTF_8)
		val stateConfigurationsForGround = configuration.actions.map [ action |
			new StateConfiguration() => [
				id = action.id
				callback = action.callback
				if (action.state !== null) {
					active = action.state.ground
					stateful = true
				} else {
					active = false
					stateful = false
				}
				relatedStateConfigurations = action.relatedActions
			]
		].toList
		val stateConfigurationStoreForGround = new StateConfigurationStore(stateConfigurationsForGround) => []
		write(stateConfigurationStoreForGround.writeValueAsString, new File(pathForMetadata, '''states_ground.json'''.toString), UTF_8)
		val stateConfigurationsForAir = configuration.actions.map [ action |
			new StateConfiguration() => [
				id = action.id
				callback = action.callback
				if (action.state !== null) {
					active = action.state.air
					stateful = true
				} else {
					active = false
					stateful = false
				}
				relatedStateConfigurations = action.relatedActions
			]
		].toList
		val stateConfigurationStoreForAir = new StateConfigurationStore(stateConfigurationsForAir) => []
		write(stateConfigurationStoreForAir.writeValueAsString, new File(pathForMetadata, '''states_air.json'''.toString), UTF_8)
	}
}
