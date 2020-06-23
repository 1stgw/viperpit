package de.viperpit.agent.keys;

import static com.google.common.base.Charsets.ISO_8859_1;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import de.viperpit.agent.data.SharedMemoryStateProvider;

@Service
public class KeyFileFactory {

	@Autowired(required = false)
	private SharedMemoryStateProvider sharedMemoryStateProvider;

	@Cacheable("keyFile")
	public KeyFile getKeyFile() {
		File keyFileLocation = getKeyFileLocation();
		if (keyFileLocation == null) {
			return null;
		}
		return new KeyFile(keyFileLocation, ISO_8859_1);
	}

	protected File getKeyFileLocation() {
		if (sharedMemoryStateProvider == null) {
			return null;
		}
		return sharedMemoryStateProvider.getKeyFileLocation();
	}

}
