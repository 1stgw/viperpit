package de.viperpit.agent.data;

import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits.RefuelRDY;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits2.Degr;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.LeftGearDown;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.NoseGearDown;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.OnGround;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.ParkBrakeOn;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.Power_Off;
import static de.viperpit.agent.data.jna.FlightDataLibrary.FlightData.LightBits3.RightGearDown;
import static de.viperpit.commons.cockpit.StateType.AIR;
import static de.viperpit.commons.cockpit.StateType.RAMP;
import static de.viperpit.commons.cockpit.StateType.TAXI;

import java.io.File;

import org.springframework.stereotype.Component;

import de.viperpit.agent.data.SharedMemoryReader.SharedMemoryData;
import de.viperpit.agent.data.jna.FlightDataLibrary.StringData.StringIdentifier;
import de.viperpit.commons.cockpit.StateType;

@Component
public class SharedMemoryStateProvider extends AbstractSharedMemoryStateProvider {

	public StateType getCurrentStateType() {
		SharedMemoryData sharedMemoryData = getSharedMemoryReader().readData();
		if (sharedMemoryData == null) {
			return RAMP;
		}
		if (isBitSet(OnGround, sharedMemoryData.getFlightData().lightBits3)) {
			if (isBitSet(Power_Off, sharedMemoryData.getFlightData().lightBits3)) {
				return RAMP;
			} else {
				return TAXI;
			}
		} else {
			return AIR;
		}
	}

	@Override
	protected Object getEcmOprSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return isBitSet(Degr, sharedMemoryData.getFlightData().lightBits2);
	}

	@Override
	protected Object getEcmOprSwitchOpr(String id, SharedMemoryData sharedMemoryData) {
		return isBitNotSet(Degr, sharedMemoryData.getFlightData().lightBits2);
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
	protected Object getGearParkingBrakeSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return isBitNotSet(ParkBrakeOn, sharedMemoryData.getFlightData().lightBits3);
	}

	@Override
	protected Object getGearParkingBrakeSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return isBitSet(ParkBrakeOn, sharedMemoryData.getFlightData().lightBits3);
	}

	public File getKeyFileLocation() {
		String[] strings = getSharedMemoryReader().readStrings();
		int identifier = StringIdentifier.KeyFile;
		if (strings.length <= identifier) {
			return null;
		}
		String keyFilePath = strings[identifier];
		if (keyFilePath == null) {
			return null;
		}
		File file = new File(keyFilePath);
		if (!file.canRead()) {
			return null;
		}
		return file;
	}

	private boolean isBitNotSet(int bit, int value) {
		return !isBitSet(bit, value);
	}

	private boolean isBitSet(int bit, int value) {
		return (bit & value) != 0;
	}

}
