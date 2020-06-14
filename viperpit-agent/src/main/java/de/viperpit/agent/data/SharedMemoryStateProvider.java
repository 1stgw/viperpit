package de.viperpit.agent.data;

import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits.RefuelRDY;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits2.EcmPwr;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.LeftGearDown;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.NoseGearDown;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.ParkBrakeOn;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.RightGearDown;

import org.springframework.stereotype.Component;

import de.viperpit.agent.data.SharedMemoryReader.SharedMemoryData;

@Component
public class SharedMemoryStateProvider extends AbstractSharedMemoryStateProvider {

	@Override
	protected Object getEcmOprSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return isBitNotSet(EcmPwr, sharedMemoryData.getFlightData().lightBits2);
	}

	@Override
	protected Object getEcmOprSwitchOpr(String id, SharedMemoryData sharedMemoryData) {
		return isBitSet(EcmPwr, sharedMemoryData.getFlightData().lightBits2);
	}

	@Override
	protected Object getFuelAirRefuelSwitchClose(String id, SharedMemoryData sharedMemoryData) {
		return isBitNotSet(RefuelRDY, sharedMemoryData.getFlightData().lightBits);
	}

	@Override
	protected Object getFuelAirRefuelSwitchOpen(String id, SharedMemoryData sharedMemoryData) {
		return isBitSet(RefuelRDY, sharedMemoryData.getFlightData().lightBits);
	}

	@Override
	protected Object getGearLgHandleDn(String id, SharedMemoryData sharedMemoryData) {
		if (isBitSet(NoseGearDown, sharedMemoryData.getFlightData().lightBits3)) {
			return true;
		}
		if (isBitSet(LeftGearDown, sharedMemoryData.getFlightData().lightBits3)) {
			return true;
		}
		if (isBitSet(RightGearDown, sharedMemoryData.getFlightData().lightBits3)) {
			return true;
		}
		return false;
	}

	@Override
	protected Object getGearLgHandleUp(String id, SharedMemoryData sharedMemoryData) {
		if (isBitSet(NoseGearDown, sharedMemoryData.getFlightData().lightBits3)) {
			return false;
		}
		if (isBitSet(LeftGearDown, sharedMemoryData.getFlightData().lightBits3)) {
			return false;
		}
		if (isBitSet(RightGearDown, sharedMemoryData.getFlightData().lightBits3)) {
			return false;
		}
		return true;
	}

	@Override
	protected Object getGearParkingBreakSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return isBitNotSet(ParkBrakeOn, sharedMemoryData.getFlightData().lightBits3);
	}

	@Override
	protected Object getGearParkingBreakSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return isBitSet(ParkBrakeOn, sharedMemoryData.getFlightData().lightBits3);
	}

	private boolean isBitNotSet(int bit, int value) {
		return !isBitSet(bit, value);
	}

	private boolean isBitSet(int bit, int value) {
		return (bit & value) != 0;
	}

}
