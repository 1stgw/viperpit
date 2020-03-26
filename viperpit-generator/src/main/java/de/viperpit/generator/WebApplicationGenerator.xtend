package de.viperpit.generator

import java.io.File
import org.slf4j.LoggerFactory
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT
import static com.google.common.base.CharMatcher.javaLetterOrDigit
import static com.google.common.base.CharMatcher.javaUpperCase
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
		val pathForRouter = new File('''«pathForModule»/router''')
		pathForRouter.mkdirs
		write('''
			«FOR console : cockpit.consoles»
				import «console.clazz» from "@/components/«profile»/consoles/«console.clazz»";
			«ENDFOR»
			
			export default class «profile.toUpperCase»Router {
				static getRoutes() {
					return [
						«FOR console : cockpit.consoles SEPARATOR ','»
							{
								path: "/cockpits/«profile»/consoles/«console.id»",
								name: "«console.clazz»For«profile.toFirstUpper»",
								component: «console.clazz»
							}
						«ENDFOR»
					];
				}
			}
		'''.process, new File(pathForRouter, '''index.js'''.toString), UTF_8)
		val pathForCockpit = new File('''«pathForModule»/cockpit''')
		pathForCockpit.mkdirs
		write('''
			<template>
				<div class="container-fluid">
					<div v-if="isConnected">
						<nav class="nav justify-content-center">
							«FOR console : cockpit.consoles»
								<router-link
									class="nav-link"
									active-class="active"
									to="/cockpits/«profile»/consoles/«console.id»"
									>«console.name»</router-link
								>
							«ENDFOR»
						</nav>
						<router-view></router-view>
					</div>
					<div v-else>
						<div class="alert alert-warning" role="alert">
							<p>
								<span
									class="glyphicon glyphicon-warning-sign"
									aria-hidden="true"
								></span>
								No Joy...
							</p>
							<p>Currently there is nothing Airborne.</p>
							<p>Please connect an Agent to the server...</p>
						</div>
					</div>
				</div>
			</template>
			
			<script>
			import { mapGetters } from "vuex";
			
			export default {
				name: "«profile.toFirstUpper»",
				computed: {
					...mapGetters(["isConnected"])
				}
			};
			</script>
		'''.process, new File(pathForCockpit, '''«profile.toFirstUpper».vue'''.toString), UTF_8)
		layout.consoleRowSets.forEach [
			val console = cockpit.getConsole(console)
			val pathForConsoles = new File('''«pathForModule»/consoles''')
			pathForConsoles.mkdirs
			write('''
				<template>
					<div class="container-fluid">
						«FOR consoleRow : consoleRows»
							<div class="row">
							«FOR panelRowSet : consoleRow.panelRowSets»
								«val panel = cockpit.getPanel(panelRowSet.panel)»
									<div class="col-sm-«12 / consoleRow.panelRowSets.size»">
										<«panel.clazz.kebapCaseName» />
									</div>
							«ENDFOR»
							</div>
						«ENDFOR»
					</div>
				</template>
				
				<script>
				«FOR panel : console.panels»
					import «panel.clazz» from "@/components/«profile»/panels/«panel.clazz»";
				«ENDFOR»
				
				export default {
					name: "«console.clazz»",
					components: {
						«FOR panel : console.panels SEPARATOR ','»
							«panel.clazz»
						«ENDFOR»
					}
				};
				</script>
			'''.process, new File(pathForConsoles, '''«console.clazz».vue'''.toString), UTF_8)
		]
		cockpit.panels.forEach [ panel |
			val pathForPanels = new File('''«pathForModule»/panels''')
			pathForPanels.mkdirs
			write('''
				<template>
					<div class="card card-default">
						<div class="card-heading">«panel.name»</div>
						<div class="card-body">
							<div class="row">
								«FOR group : panel.groups»
									<div class="col-xs-6 col-sm-6">
										<div align="center" style="padding: 0px;">
											<«group.controlName.kebapCaseName»
												id="«group.id»"
												description="«group.description»"
												«IF !group.label.nullOrEmpty»label="«group.label»"«ENDIF»
												type="«group.type»"
											>
												«FOR control : group.controls»
													<control
														id="«control.id»"
														description="«control.description»"
														label="«control.label»"
														type="«group.type»"
														role="«control.role»"
													/>
												«ENDFOR»
											</«group.controlName.kebapCaseName»>
										</div>
									</div>
								«ENDFOR»
							</div>
						</div>
					</div>
				</template>
				
				<script>
				import Control from "@/components/controls/Control";
				«FOR controlName : panel.groups.map[controlName].toSet.sort»
					import «controlName» from "@/components/controls/«controlName»";
				«ENDFOR»
				
				export default {
					name: "«panel.clazz»",
					components: {
						Control,
						«FOR controlName : panel.groups.map[controlName].toSet.sort SEPARATOR ','»
							«controlName»
						«ENDFOR»
					}
				};
				</script>
			'''.process, new File(pathForPanels, '''«panel.clazz».vue'''.toString), UTF_8)
		]
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
					SharedMemoryData sharedMemoryData = sharedMemoryReader.readData();
					Map<String, Object> states = new LinkedHashMap<>(STATES.size());
					for (String id : STATES) {
						Object state = getStateFromSharedMemory(id, sharedMemoryData);
						if (state != null) {
							states.put(id, state);
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

		val pathForMetadata = new File('''«path.absolutePath»/viperpit-hub/src/main/resources''')
		val builder = new Jackson2ObjectMapperBuilder()
		builder.featuresToEnable(INDENT_OUTPUT)
		val extension objectMapper = builder.build
		val cockpitConfiguration = new de.viperpit.commons.cockpit.Cockpit() => [
			id = profile
			name = profile.toFirstUpper
			consoles = cockpit.consoles.map [ console |
				new de.viperpit.commons.cockpit.Console() => [
					id = console.id
					className = console.clazz
					name = console.name
				]
			].toList
			panels = cockpit.panels.map [ panel |
				new de.viperpit.commons.cockpit.Panel() => [
					id = panel.id
					className = panel.clazz
					name = panel.name
				]
			].toList
			groups = cockpit.groups.map [ group |
				new de.viperpit.commons.cockpit.Group() => [
					id = group.id
					className = group.clazz
					description = group.description
					label = group.label
					type = group.type
				]
			].toList
			controls = cockpit.controls.map [ control |
				new de.viperpit.commons.cockpit.Control() => [
					id = control.id
					className = control.clazz
					description = control.description
					label = control.label
					role = control.role
				]
			].toList
		]
		write(cockpitConfiguration.writeValueAsString, new File(pathForMetadata, '''configuration_cockpit.json'''.toString), UTF_8)
		val actionsForRamp = configuration.actions.map [ action |
			new de.viperpit.commons.cockpit.Action() => [
				id = action.id
				callback = action.callback
				if (action.state !== null) {
					active = action.state.ramp
					stateful = true
				} else {
					active = false
					stateful = false
				}
				relatedActions = action.relatedActions
			]
		].toList
		val stateConfigurationForRamp = new de.viperpit.commons.cockpit.State(null, actionsForRamp) => []
		write(stateConfigurationForRamp.writeValueAsString, new File(pathForMetadata, '''states_ramp.json'''.toString), UTF_8)
		val actionsForGround = configuration.actions.map [ action |
			new de.viperpit.commons.cockpit.Action() => [
				id = action.id
				callback = action.callback
				if (action.state !== null) {
					active = action.state.ground
					stateful = true
				} else {
					active = false
					stateful = false
				}
				relatedActions = action.relatedActions
			]
		].toList
		val stateConfigurationForGround = new de.viperpit.commons.cockpit.State(null, actionsForGround) => []
		write(stateConfigurationForGround.writeValueAsString, new File(pathForMetadata, '''states_ground.json'''.toString), UTF_8)
		val actionsForAir = configuration.actions.map [ action |
			new de.viperpit.commons.cockpit.Action() => [
				id = action.id
				callback = action.callback
				if (action.state !== null) {
					active = action.state.air
					stateful = true
				} else {
					active = false
					stateful = false
				}
				relatedActions = action.relatedActions
			]
		].toList
		val stateConfigurationForAir = new de.viperpit.commons.cockpit.State(null, actionsForAir) => []
		write(stateConfigurationForAir.writeValueAsString, new File(pathForMetadata, '''states_air.json'''.toString), UTF_8)
	}

	private def getControlName(Group group) {
		'''«group.type.toFirstUpper»Group'''.toString
	}

	private def getKebapCaseName(String it) {
		if (length <= 1) {
			return toLowerCase
		}
		val tokens = newArrayList
		var current = 0
		while (current < length) {
			var next = javaUpperCase.indexIn(it, current + 1)
			if (next === -1) {
				next = length
			}
			val token = javaLetterOrDigit.retainFrom(substring(current, next)).toLowerCase
			tokens += token
			current = next
		}
		return tokens.join('-')
	}

	private def process(CharSequence it) {
		toString.replace('\t', '  ')
	}

}
