package de.viperpit.generator

import com.google.common.io.Files
import java.io.File
import java.nio.charset.Charset
import org.slf4j.LoggerFactory

import static com.google.common.base.Charsets.UTF_8

class WebApplicationGenerator {

	static val LOGGER = LoggerFactory.getLogger(WebApplicationGenerator)

	def run(File target, CockpitConfiguration cockpitConfiguration) throws Exception {
		LOGGER.info("Running the Generator.")
		if (cockpitConfiguration !== null) {
			val pathForStateProvider = new File('''«target»/de/viperpit/agent/data''')
			pathForStateProvider.mkdirs
			val statefulActions = cockpitConfiguration.controlConfigurations.filter[stateful].sortBy[id]
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
				public abstract class AbstractSharedMemoryStateProvider {
				
					private static final Collection<String> STATES = newArrayList(
						«FOR action : statefulActions SEPARATOR "," + System.lineSeparator»"«action.id»"«ENDFOR»
					);
				
					@Autowired
					private SharedMemoryReader sharedMemoryReader;
				
					protected SharedMemoryReader getSharedMemoryReader() {
						return sharedMemoryReader;
					}
				
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
		} else {
			LOGGER.error("Files could not be loaded")
		}
	}

	static def write(CharSequence charSequence, File file, Charset charset) {
		Files.asCharSink(file, charset).write(charSequence)
	}

}
