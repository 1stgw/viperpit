package de.viperpit.agent.data;

import static com.google.common.base.Charsets.UTF_8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import org.springframework.stereotype.Component;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef.UINT;

import de.viperpit.agent.data.jna.FlightDataLibrary.FlightData;
import de.viperpit.agent.data.jna.FlightDataLibrary.FlightData2;
import de.viperpit.agent.data.jna.FlightDataLibrary.OSBData;
import de.viperpit.agent.data.jna.FlightDataLibrary.StringData;
import de.viperpit.agent.data.jna.IVibeDataLibrary.IntellivibeData;

@Component
public class SharedMemoryReader {

	public static class SharedMemoryData {

		private FlightData flightData;

		private FlightData2 flightData2;

		private IntellivibeData intellivibeData;

		private OSBData osbData;

		private StringData stringData;

		public SharedMemoryData() {
			super();
		}

		public FlightData getFlightData() {
			return flightData;
		}

		public FlightData2 getFlightData2() {
			return flightData2;
		}

		public IntellivibeData getIntellivibeData() {
			return intellivibeData;
		}

		public OSBData getOsbData() {
			return osbData;
		}

		public StringData getStringData() {
			return stringData;
		}

		private void setFlightData(FlightData flightData) {
			this.flightData = flightData;
		}

		private void setFlightData2(FlightData2 flightData2) {
			this.flightData2 = flightData2;
		}

		private void setIntellivibeData(IntellivibeData intellivibeData) {
			this.intellivibeData = intellivibeData;
		}

		private void setOsbData(OSBData osbData) {
			this.osbData = osbData;
		}

		private void setStringData(StringData stringData) {
			this.stringData = stringData;
		}

	}

	public SharedMemoryData readData() {
		SharedMemoryData sharedMemoryData = new SharedMemoryData();
		readFlightData((data, pointer) -> sharedMemoryData.setFlightData(data));
		readFlightData2((data, pointer) -> sharedMemoryData.setFlightData2(data));
		readIntellivibeData((data, pointer) -> sharedMemoryData.setIntellivibeData(data));
		readOSBData((data, pointer) -> sharedMemoryData.setOsbData(data));
		readStringData((data, pointer) -> sharedMemoryData.setStringData(data));
		return sharedMemoryData;
	}

	protected <T extends Structure> void readData(String sharedMemoryAreaName, Class<T> type,
			BiConsumer<T, Pointer> consumer) {
		try (SharedMemory sharedMemory = new SharedMemory(sharedMemoryAreaName)) {
			Pointer pointer = sharedMemory.getView().get();
			T structure = (T) Structure.newInstance(type, pointer);
			structure.autoRead();
			if (consumer != null) {
				consumer.accept(structure, pointer);
			}
		} catch (Exception exception) {
			T structure = (T) Structure.newInstance(type);
			if (consumer != null) {
				consumer.accept(structure, null);
			}
		}
	}

	public void readFlightData(BiConsumer<FlightData, Pointer> consumer) {
		readData("FalconSharedMemoryArea", FlightData.class, consumer);
	}

	public void readFlightData2(BiConsumer<FlightData2, Pointer> consumer) {
		readData("FalconSharedMemoryArea2", FlightData2.class, consumer);
	}

	public void readIntellivibeData(BiConsumer<IntellivibeData, Pointer> consumer) {
		readData("FalconIntellivibeSharedMemoryArea", IntellivibeData.class, consumer);
	}

	public void readOSBData(BiConsumer<OSBData, Pointer> consumer) {
		readData("FalconSharedOsbMemoryArea", OSBData.class, consumer);
	}

	public void readStringData(BiConsumer<StringData, Pointer> consumer) {
		readData("FalconSharedMemoryAreaString", StringData.class, consumer);
	}

	public String[] readStrings() {
		List<String> strings = new ArrayList<>();
		readStringData((stringData, pointer) -> {
			long offset = 0;
			// We can skip the version number
			offset += UINT.SIZE;
			int numberOfStrings = pointer.getInt(offset);
			offset += UINT.SIZE;
			// We can skip the data size
			offset += UINT.SIZE;
			for (int i = 0; i < numberOfStrings; i++) {
				int stringIdentifier = pointer.getInt(offset);
				offset += UINT.SIZE;
				int stringLength = pointer.getInt(offset);
				offset += UINT.SIZE;
				byte[] byteArray = pointer.getByteArray(offset, stringLength + 1);
				strings.add(stringIdentifier, Native.toString(byteArray, UTF_8.name()));
				offset += stringLength + 1;
			}
		});
		return strings.toArray(new String[strings.size()]);
	}

}
