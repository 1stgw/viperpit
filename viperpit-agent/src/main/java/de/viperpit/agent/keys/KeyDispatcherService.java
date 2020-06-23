package de.viperpit.agent.keys;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.viperpit.agent.keys.KeyFile.KeyCodeLine;

@Service
@Scope(SCOPE_SINGLETON)
public class KeyDispatcherService {

	private static final Logger LOGGER = getLogger(KeyDispatcherService.class);

	@Autowired
	private KeyCodeLineConverter keyCodeLineConverter;

	@Autowired
	private KeyDispatcher keyDispatcher;

	@Autowired
	private KeyFileFactory keyFileFactory;

	public boolean fire(String callback) {
		KeyFile keyFile = keyFileFactory.getKeyFile();
		if (keyFile == null) {
			LOGGER.error("Key file has not been loaded");
			return false;
		}
		KeyCodeLine keyCodeLine = keyFile.getKeyCodeLines().get(callback);
		if (keyCodeLine != null) {
			return keyDispatcher.fire(keyCodeLineConverter.toScanCodeIntervals(keyCodeLine, true));
		} else {
			LOGGER.error(callback + " has not been found.");
			return false;
		}
	}

}
