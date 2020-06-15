package de.viperpit.agent.keys;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.viperpit.agent.keys.KeyFile.KeyCodeLine;

@Service
@Scope(SCOPE_SINGLETON)
public class KeyDispatcherService {

	@Autowired
	private KeyCodeLineConverter keyCodeLineConverter;

	@Autowired
	private KeyDispatcher keyDispatcher;

	@Autowired
	private KeyFile keyFile;

	private Logger logger = LoggerFactory.getLogger(KeyDispatcherService.class);

	public boolean fire(String callback) {
		if (keyFile == null) {
			logger.error("Key file could not be loaded");
			return false;
		}
		KeyCodeLine keyCodeLine = keyFile.getKeyCodeLines().get(callback);
		if (keyCodeLine != null) {
			return keyDispatcher.fire(keyCodeLineConverter.toScanCodeIntervals(keyCodeLine, true));
		} else {
			logger.error(callback + " has not been found.");
			return false;
		}
	}

}
