package de.viperpit.agent.data;

import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.ParkBrakeOn;

import org.springframework.stereotype.Component;

import de.viperpit.agent.data.SharedMemoryReader.SharedMemoryData;

@Component
public class SharedMemoryStateProvider extends AbstractSharedMemoryStateProvider {

	@Override
	protected Object getGearParkingBreakSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return isBitSet(ParkBrakeOn, sharedMemoryData.getFlightData().lightBits3);
	}

	@Override
	protected Object getGearParkingBreakSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return isBitNotSet(ParkBrakeOn, sharedMemoryData.getFlightData().lightBits3);
	}

	private boolean isBitNotSet(int bit, int value) {
		return !isBitSet(bit, value);
	}

	private boolean isBitSet(int bit, int value) {
		return (bit & value) != 0;
	}

}
