package de.viperpit.agent.data;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

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

	private static final Logger LOGGER = getLogger(SharedMemoryReader.class);

	public SharedMemoryData readData() {
		SharedMemoryData sharedMemoryData = new SharedMemoryData();
		sharedMemoryData.setFlightData(readData("FalconSharedMemoryArea", FlightData.class));
		sharedMemoryData.setFlightData2(readData("FalconSharedMemoryArea2", FlightData2.class));
		sharedMemoryData.setIntellivibeData(readData("FalconIntellivibeSharedMemoryArea", IntellivibeData.class));
		sharedMemoryData.setOsbData(readData("FalconSharedOsbMemoryArea", OSBData.class));
		sharedMemoryData.setStringData(readData("FalconSharedMemoryAreaString", StringData.class));
		return sharedMemoryData;
	}

	private <T extends Structure> T readData(String sharedMemoryAreaName, Class<T> type) {
		try (SharedMemory sharedMemory = new SharedMemory(sharedMemoryAreaName)) {
			Pointer pointer = sharedMemory.getView().get();
			T structure = (T) Structure.newInstance(type, pointer);
			structure.autoRead();
			return structure;
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage(), exception);
		}
		return null;
	}

}
