package de.viperpit.agent.keys;

import static de.viperpit.agent.keys.KeyDispatcher.KeyDispatchType.KEY_DOWN;
import static de.viperpit.agent.keys.KeyDispatcher.KeyDispatchType.KEY_UP;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import java.util.Collection;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import de.viperpit.agent.keys.KeyCodeLineConverter.ScanCodeInterval;
import de.viperpit.agent.keys.KeyDispatcher.KeyDispatchType;
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

	private boolean fire(String callback, KeyDispatchType... keyDispatchTypes) {
		KeyFile keyFile = keyFileFactory.getKeyFile();
		if (keyFile == null) {
			LOGGER.error("Key file has not been loaded");
			return false;
		}
		KeyCodeLine keyCodeLine = keyFile.getKeyCodeLines().get(callback);
		if (keyCodeLine != null) {
			Collection<ScanCodeInterval> scanCodeIntervals = keyCodeLineConverter.toScanCodeIntervals(keyCodeLine,
					true);
			if (scanCodeIntervals.isEmpty()) {
				return false;
			}
			return keyDispatcher.fire(scanCodeIntervals, keyDispatchTypes);
		} else {
			LOGGER.error(callback + " has not been found.");
			return false;
		}
	}

	public boolean keyDown(String callback) {
		return fire(callback, KEY_DOWN);
	}

	public boolean keyUp(String callback) {
		return fire(callback, KEY_UP);
	}

}
