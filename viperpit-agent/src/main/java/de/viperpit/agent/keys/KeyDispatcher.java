package de.viperpit.agent.keys;

import static com.sun.jna.platform.win32.WinUser.INPUT.INPUT_KEYBOARD;
import static com.sun.jna.platform.win32.WinUser.KEYBDINPUT.KEYEVENTF_EXTENDEDKEY;
import static com.sun.jna.platform.win32.WinUser.KEYBDINPUT.KEYEVENTF_KEYUP;
import static com.sun.jna.platform.win32.WinUser.KEYBDINPUT.KEYEVENTF_SCANCODE;
import static de.viperpit.agent.keys.KeyDispatcher.KeyDispatchType.KEY_DOWN;
import static de.viperpit.agent.keys.KeyDispatcher.KeyDispatchType.KEY_UP;
import static java.lang.Thread.sleep;
import static java.util.Arrays.asList;
import static java.util.EnumSet.copyOf;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.WORD;
import com.sun.jna.platform.win32.WinUser.INPUT;
import com.sun.jna.platform.win32.WinUser.KEYBDINPUT;

import de.viperpit.agent.keys.KeyCodeLineConverter.ScanCodeInterval;

@Component
public class KeyDispatcher {

	public static enum KeyDispatchType {
		KEY_DOWN, KEY_UP
	}

	private static final User32 OS = User32.INSTANCE;

	private final String windowName;

	public KeyDispatcher(@Value("${local.bms.window}") String windowName) {
		this.windowName = windowName;
	}

	private void configure(INPUT input, int scanCode, boolean keyUp) {
		int flags = KEYEVENTF_SCANCODE;
		if ((scanCode & 0xE000) != 0 || (scanCode & 0xE100) != 0) {
			flags = KEYEVENTF_EXTENDEDKEY;
		}
		if (keyUp) {
			flags |= KEYEVENTF_KEYUP;
		}
		input.input = new INPUT.INPUT_UNION();
		input.input.setType(KEYBDINPUT.class);
		input.type = new DWORD(INPUT_KEYBOARD);
		input.input.ki.dwFlags = new DWORD(flags);
		input.input.ki.time = new DWORD(0);
		input.input.ki.wScan = new WORD(scanCode);
	}

	private void delayAction(int millis) {
		try {
			sleep(millis);
		} catch (InterruptedException exception) {
		}
	}

	private int fire(int[] scanCodes, EnumSet<KeyDispatchType> keyDispatchTypes) {
		if (windowName != null) {
			HWND window = OS.FindWindow(null, windowName);
			if (window != null) {
				OS.SetFocus(window);
				OS.SetForegroundWindow(window);
				if (isDelayAction()) {
					delayAction(200);
				}
				INPUT[] inputs = (INPUT[]) new INPUT().toArray(scanCodes.length * 2);
				int i = 0;
				if (keyDispatchTypes.contains(KEY_DOWN)) {
					for (int scanCode : scanCodes) {
						configure(inputs[i], scanCode, false);
						i++;
					}
				}
				if (keyDispatchTypes.contains(KEY_UP)) {
					for (int scanCode : scanCodes) {
						configure(inputs[i], scanCode, true);
						i++;
					}
				}
				return OS.SendInput(new DWORD(inputs.length), inputs, inputs[0].size()).intValue();
			}
		}
		return 0;
	}

	public boolean fire(Iterable<ScanCodeInterval> scanCodeIntervals, KeyDispatchType... keyDispatchTypes) {
		int result = 0;
		for (ScanCodeInterval scanCodeInterval : scanCodeIntervals) {
			result += fire(scanCodeInterval.getScanCodes(), copyOf(asList(keyDispatchTypes)));
		}
		return result != 0;
	}

	private boolean isDelayAction() {
		return true;
	}

}
