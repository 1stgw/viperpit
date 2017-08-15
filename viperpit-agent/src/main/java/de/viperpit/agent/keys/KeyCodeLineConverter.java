package de.viperpit.agent.keys;

import static com.sun.jna.Native.loadLibrary;
import static com.sun.jna.win32.W32APIOptions.DEFAULT_OPTIONS;
import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_NUM_LOCK;
import static java.awt.event.KeyEvent.VK_SHIFT;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;
import static java.util.Arrays.copyOf;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.ptr.IntByReference;

import de.viperpit.agent.keys.KeyFile.KeyCodeLine;

@Component
public class KeyCodeLineConverter {

	private static interface KeyCodeLineConverter32 extends User32 {

		public static final KeyCodeLineConverter32 INSTANCE = (KeyCodeLineConverter32) loadLibrary("user32",
				KeyCodeLineConverter32.class, DEFAULT_OPTIONS);

		IntByReference GetKeyboardLayout(int code);

		int GetKeyState(int vkNumLock);

		int MapVirtualKeyEx(int uCode, int uMapType, IntByReference hkl);

	}

	public static class ScanCodeInterval {

		private int[] scanCodes;

		public ScanCodeInterval(int... scanCodes) {
			this.scanCodes = scanCodes;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			ScanCodeInterval other = (ScanCodeInterval) obj;
			if (!Arrays.equals(scanCodes, other.scanCodes)) {
				return false;
			}
			return true;
		}

		public int[] getScanCodes() {
			return scanCodes;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Arrays.hashCode(scanCodes);
			return result;
		}

		@Override
		public String toString() {
			return "ScanCodeInterval [scanCodes=" + Arrays.toString(scanCodes) + "]";
		}

	}

	private static final Logger LOGGER = LoggerFactory.getLogger(KeyCodeLineConverter.class);

	private static final KeyCodeLineConverter32 OS = KeyCodeLineConverter32.INSTANCE;

	@Autowired
	@Qualifier("directInputProperties")
	private Properties directInputProperties;

	private BiMap<String, Integer> directInputScanCodes = null;

	private BiMap<String, Integer> hardwareScanCodes = null;

	@Autowired
	@Qualifier("scanCodesProperties")
	private Properties scanCodesProperties;

	private BiMap<String, Integer> initialize(Properties properties) {
		BiMap<String, Integer> map = HashBiMap.create();
		Enumeration<?> keys = properties.propertyNames();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = properties.get(key);
			if (value != null && !value.toString().isEmpty()) {
				map.put(key.toString(), valueOf(parseInt(value.toString(), 16)));
			}
		}
		return map;
	}

	private synchronized final int toScanCodeFromDirectInputCode(int keyCode) {
		if (directInputScanCodes == null) {
			LOGGER.debug("Converting Direct Input codes.");
			directInputScanCodes = initialize(directInputProperties);
		}
		if (hardwareScanCodes == null) {
			LOGGER.debug("Converting Scan Codes.");
			hardwareScanCodes = initialize(scanCodesProperties);
		}
		String directInputKey = directInputScanCodes.inverse().get(valueOf(keyCode));
		if (directInputKey == null) {
			return 0;
		}
		return hardwareScanCodes.get(directInputKey);
	}

	private final synchronized int toScanCodeFromVirtualKeyCode(int keyCode) {
		return OS.MapVirtualKeyEx(keyCode, 4, OS.GetKeyboardLayout(0));
	}

	public Iterable<ScanCodeInterval> toScanCodeIntervals(KeyCodeLine keyCodeLine, boolean disableNumLock) {
		List<ScanCodeInterval> scanCodeIntervals = Lists.newArrayList();
		if (disableNumLock && OS.GetKeyState(VK_NUM_LOCK) == 1) {
			int scanCode = toScanCodeFromVirtualKeyCode(VK_NUM_LOCK);
			scanCodeIntervals.add(new ScanCodeInterval(scanCode));
		}
		if (keyCodeLine.hasKeyCombinations()) {
			int[] scanCodes = toScanCodes(keyCodeLine.getKeyCombinationKey(), keyCodeLine.getKeyCombinationModifiers());
			scanCodeIntervals.add(new ScanCodeInterval(scanCodes));
		}
		int[] scanCodes = toScanCodes(keyCodeLine.getKey(), keyCodeLine.getModifiers());
		scanCodeIntervals.add(new ScanCodeInterval(scanCodes));
		return scanCodeIntervals;
	}

	private int[] toScanCodes(int key, int modifiers) {
		int[] scanCodesOfModifiers = toScanCodesFromKeyFileCode(modifiers);
		int scanCodeOfKey = toScanCodeFromDirectInputCode(key);
		int[] scanCodes = copyOf(scanCodesOfModifiers, scanCodesOfModifiers.length + 1);
		scanCodes[scanCodes.length - 1] = scanCodeOfKey;
		return scanCodes;
	}

	private int[] toScanCodesFromKeyFileCode(int keyCode) {
		int[] virtualKeyCodes = null;
		switch (keyCode) {
		case 1:
			virtualKeyCodes = new int[] { VK_SHIFT };
			break;
		case 2:
			virtualKeyCodes = new int[] { VK_CONTROL };
			break;
		case 3:
			virtualKeyCodes = new int[] { VK_SHIFT, VK_CONTROL };
			break;
		case 4:
			virtualKeyCodes = new int[] { VK_ALT };
			break;
		case 5:
			virtualKeyCodes = new int[] { VK_SHIFT, VK_ALT };
			break;
		case 6:
			virtualKeyCodes = new int[] { VK_CONTROL, VK_ALT };
			break;
		case 7:
			virtualKeyCodes = new int[] { VK_SHIFT, VK_CONTROL, VK_ALT };
			break;
		default:
			virtualKeyCodes = new int[] {};
			break;
		}
		return toScanCodesFromVirtualKeyCodes(virtualKeyCodes);
	}

	private final synchronized int[] toScanCodesFromVirtualKeyCodes(int... keyCodes) {
		int[] scanCodes = new int[keyCodes.length];
		for (int i = 0; i < keyCodes.length; i++) {
			scanCodes[i] = toScanCodeFromVirtualKeyCode(keyCodes[i]);
		}
		return scanCodes;
	}

}
