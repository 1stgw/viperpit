package de.viperpit.agent.keys;

import static de.viperpit.agent.keys.KeyDispatcher.KeyDispatchType.KEY_DOWN;
import static de.viperpit.agent.keys.KeyDispatcher.KeyDispatchType.KEY_UP;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_SINGLETON;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

	private Set<String> previousCallbacks = new HashSet<>();

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
		if (keyCodeLine == null) {
			LOGGER.error(callback + " has not been found.");
			return false;
		}
		Collection<ScanCodeInterval> scanCodeIntervals = keyCodeLineConverter.toScanCodeIntervals(keyCodeLine, true);
		if (scanCodeIntervals.isEmpty()) {
			return false;
		}
		return keyDispatcher.fire(scanCodeIntervals, keyDispatchTypes);
	}

	public boolean keyDown(String callback) {
		// There still might be some "hanging" keystrokes, that haven't been released.
		// We will release them to prevent accidental key combinations.
		for (String previousCallback : previousCallbacks) {
			this.keyUp(previousCallback);
		}

		// We ensure the callback will be released before the next invocation.
		previousCallbacks.add(callback);

		// We fire the callback.
		return fire(callback, KEY_DOWN);
	}

	public boolean keyUp(String callback) {
		// We can now safely remove the callback, as it will be fired in the next step.
		previousCallbacks.remove(callback);

		// We can now release the keystroke.
		return fire(callback, KEY_UP);
	}
}
