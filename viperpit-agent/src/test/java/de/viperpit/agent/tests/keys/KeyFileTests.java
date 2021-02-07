package de.viperpit.agent.tests.keys;

import static com.google.common.base.Charsets.ISO_8859_1;
import static com.google.common.collect.Iterables.toArray;
import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.viperpit.agent.AgentConfiguration;
import de.viperpit.agent.keys.KeyCodeLineConverter;
import de.viperpit.agent.keys.KeyCodeLineConverter.ScanCodeInterval;
import de.viperpit.agent.keys.KeyFile;
import de.viperpit.agent.keys.KeyFile.KeyCodeLine;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = { AgentConfiguration.class })
public class KeyFileTests {

	@Autowired
	private KeyCodeLineConverter keyCodeLineConverter;

	private KeyFile keyFile;

	@BeforeEach
	public void loadKeyFile() throws URISyntaxException {
		File file = new File(KeyFileTests.class.getResource("/demo.key").toURI());
		assertTrue(file.exists());
		keyFile = new KeyFile(file, ISO_8859_1);
	}

	@AfterEach
	public void resetKeyFile() {
		keyFile = null;
	}

	@Test
	public void testDemoKeyFiles() {
		Map<String, KeyCodeLine> keyCodeLines = keyFile.getKeyCodeLines();
		assertNotNull(keyCodeLines);
		assertEquals(1008, keyCodeLines.size());
	}

	@Test
	public void testEntryWithKey() {
		KeyCodeLine keyCodeLine = keyFile.getKeyCodeLines().get("SimTogglePaused");
		assertNotNull(keyCodeLine);
		assertEquals(keyCodeLine.getCategory(), "MISCELLANEOUS");
		assertEquals(keyCodeLine.getSection(), "SIMULATION & HARDWARE");
		assertEquals(keyCodeLine.getCallback(), "SimTogglePaused");
		assertEquals(keyCodeLine.getSound(), -1);
		Iterable<ScanCodeInterval> expected = newArrayList(new ScanCodeInterval(0x19));
		Iterable<ScanCodeInterval> actual = keyCodeLineConverter.toScanCodeIntervals(keyCodeLine, false);
		assertIterableEquals(expected, actual, ScanCodeInterval.class);
		assertEquals(keyCodeLine.getDescription(), "SIM: Sim-Pause - Toggle");
	}

	@Test
	public void testEntryWithKeyAndModifier() {
		KeyCodeLine keyCodeLine = keyFile.getKeyCodeLines().get("SimMotionFreeze");
		assertNotNull(keyCodeLine);
		assertEquals(keyCodeLine.getCategory(), "MISCELLANEOUS");
		assertEquals(keyCodeLine.getSection(), "SIMULATION & HARDWARE");
		assertEquals(keyCodeLine.getCallback(), "SimMotionFreeze");
		assertEquals(keyCodeLine.getSound(), -1);
		Iterable<ScanCodeInterval> expected = newArrayList(new ScanCodeInterval(0x2A, 0x19));
		Iterable<ScanCodeInterval> actual = keyCodeLineConverter.toScanCodeIntervals(keyCodeLine, false);
		assertIterableEquals(expected, actual, ScanCodeInterval.class);
		assertEquals(keyCodeLine.getDescription(), "SIM: Sim-Freeze - Toggle");
	}

	@Test
	public void testEntryWithKeyAndComboKeyAndComboModifier() {
		KeyCodeLine keyCodeLine = keyFile.getKeyCodeLines().get("OTWToggleFrameRate");
		assertNotNull(keyCodeLine);
		assertEquals(keyCodeLine.getCategory(), "MISCELLANEOUS");
		assertEquals(keyCodeLine.getSection(), "SIMULATION & HARDWARE");
		assertEquals(keyCodeLine.getCallback(), "OTWToggleFrameRate");
		assertEquals(keyCodeLine.getSound(), -1);
		Iterable<ScanCodeInterval> expected = newArrayList(new ScanCodeInterval(0x38, 0x2E),
				new ScanCodeInterval(0x21));
		Iterable<ScanCodeInterval> actual = keyCodeLineConverter.toScanCodeIntervals(keyCodeLine, false);
		assertIterableEquals(expected, actual, ScanCodeInterval.class);
		assertEquals(keyCodeLine.getDescription(), "SIM: Display Frame Rate - Toggle");
	}

	private static <T> void assertIterableEquals(Iterable<T> expected, Iterable<T> actual, Class<T> type) {
		assertArrayEquals(toArray(expected, type), toArray(actual, type));
	}

}
