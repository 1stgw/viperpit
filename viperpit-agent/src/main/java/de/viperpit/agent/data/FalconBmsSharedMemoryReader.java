package de.viperpit.agent.data;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import de.viperpit.agent.data.jna.FlightDataLibrary.FlightData;

public class FalconBmsSharedMemoryReader {

	public static void main(String[] args) {
		try (SharedMemory sharedMemory = new SharedMemory("FalconSharedMemoryArea", 2048, true)) {
			Pointer pointer = sharedMemory.getView().get();
			FlightData structure = (FlightData) Structure.newInstance(FlightData.class, pointer);
			for (String fieldName : structure.getFieldOrder()) {
				System.out.println(fieldName + ": " + structure.readField(fieldName));
			}
		}
	}

}
