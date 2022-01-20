package de.viperpit.generator;

import static com.google.common.base.Objects.equal;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static de.viperpit.commons.cockpit.StateType.AIR;
import static de.viperpit.commons.cockpit.StateType.RAMP;
import static de.viperpit.commons.cockpit.StateType.TAXI;
import static de.viperpit.generator.JsonFileWriter.writeObject;
import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableSet;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import de.viperpit.agent.keys.KeyFile.KeyCodeLine;
import de.viperpit.commons.cockpit.StateConfiguration;
import de.viperpit.commons.cockpit.StateConfigurationStore;

public class DefaultStateConfigurationsGenerator {

	private static final Set<String> STATES_ALWAYS_OFF = unmodifiableSet(newHashSet( //
			"SimMasterFuelOff", //
			"SimFuelDoorOpen", //
			"SimEpuOn", //
			"SimEpuOff", //
			"SimAVTRSwitchOn", //
			"SimBupUhfMain", //
			"SimEwsJettOn", //
			"SimGndJettOn", //
			"SimParkingBrakeOn", //
			"SimArmMasterArm", //
			"SimDriftCOOn", //
			"SimRALTON", //
			"SimScalesOff", //
			"SimPitchLadderOff", //
			"SimINSNorm" //
	));

	private static final Set<String> STATES_ALWAYS_ON = unmodifiableSet(newHashSet( //
			"SimAltFlapsNorm", //
			"SimTrimAPNORM", //
			"SimMasterFuelOn", //
			"SimFuelDoorClose", //
			"SimEpuAuto", //
			"SimAVTRSwitchOff", //
			"SimJfsStart_Off", //
			"SimEngContPri", //
			"SimAud1Com1Sql", //
			"SimAud1Com2Sql", //
			"SimBupUhfPreset", //
			"SimEwsJettOff", //
			"SimEWSProgOne", //
			"SimHookUp", "SimGndJettOff", //
			"SimParkingBrakeOff", //
			"SimCATIII", //
			"SimLandingLightOff", //
			"SimRFNorm", //
			"SimLaserArmOff", //
			"SimSafeMasterArm", //
			"SimRightAPMid", //
			"SimLeftAPMid", //
			"SimDriftCOOff", //
			"SimHSINav", //
			"SimFuelSwitchNorm", //
			"SimFuelTransNorm", //
			"SimScalesVAH", //
			"SimRALTOFF", //
			"SimPitchLadderATTFPM", //
			"SimHUDDEDOff", //
			"SimReticleOff", //
			"SimHUDVelocityCAS", //
			"SimHUDAltAuto", //
			"SimHUDBrtDay", //
			"SimInteriorLight", //
			"SimInstrumentLight", //
			"SimVMSOn" //
	));

	private static final Set<String> STATES_OFF_AT_RAMP = unmodifiableSet(newHashSet( //
			"SimMasterFuelOff", //
			"SimBupUhfBoth", //
			"AFCanopyClose", //
			"AFGearUp", //
			"SimSeatOn", //
			"SimEWSModeStby", //
			"SimINSNav" //
	));

	private static final Set<String> STATES_ON_AT_RAMP = unmodifiableSet(newHashSet( //
			"SimAuxComBackup", //
			"SimTACANAATR", //
			"SimLEFAuto", //
			"AFGearDown", //
			"SimTrimAPNORSimMasterFuelOnM", //
			"SimLightsSteady", //
			"AFCanopyOpen", //
			"SimSeatOff" //
	));

	private boolean isValidDefaultValue(RoleConfiguration roleConfiguration, Object defaultValue) {
		return defaultValue instanceof Boolean;
	}

	public DefaultStateConfigurations run( //
			File target, //
			Collection<KeyCodeLine> keyCodeLines, //
			RoleConfigurations roleConfigurations) throws Exception {
		var collection = new ArrayList<DefaultStateConfiguration>();
		keyCodeLines.stream().forEach(keyCodeLine -> {
			boolean stateful = isStateful(keyCodeLine, roleConfigurations);
			RoleConfiguration roleConfiguration = roleConfigurations.getRoleConfiguration(keyCodeLine.getCallback());
			String role = roleConfiguration.getRole();
			String callback = keyCodeLine.getCallback();
			if (!stateful) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false, stateful));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false, stateful));
				collection.add(new DefaultStateConfiguration(callback, AIR, false, stateful));
			} else if (STATES_ALWAYS_ON.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, true));
				collection.add(new DefaultStateConfiguration(callback, TAXI, true));
				collection.add(new DefaultStateConfiguration(callback, AIR, true));
			} else if (STATES_ALWAYS_OFF.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			} else if (STATES_ON_AT_RAMP.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, true));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			} else if (STATES_OFF_AT_RAMP.contains(callback)) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, true));
				collection.add(new DefaultStateConfiguration(callback, AIR, true));
			} else if (equal(role, "off")) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, true));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			} else if (equal(role, "on")) {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, true));
				collection.add(new DefaultStateConfiguration(callback, AIR, true));
			} else {
				collection.add(new DefaultStateConfiguration(callback, RAMP, false));
				collection.add(new DefaultStateConfiguration(callback, TAXI, false));
				collection.add(new DefaultStateConfiguration(callback, AIR, false));
			}
		});
		DefaultStateConfigurations defaultStateConfigurations = new DefaultStateConfigurations(collection);
		var stateConfigurationsForRamp = new ArrayList<StateConfiguration>();
		var stateConfigurationsForTaxi = new ArrayList<StateConfiguration>();
		var stateConfigurationsForAir = new ArrayList<StateConfiguration>();
		for (KeyCodeLine keyCodeLine : keyCodeLines) {
			var roleConfiguration = roleConfigurations.getRoleConfiguration(keyCodeLine.getCallback());
			var defaultValueForRamp = defaultStateConfigurations.getDefaultValue(keyCodeLine.getCallback(), RAMP);
			if (isValidDefaultValue(roleConfiguration, defaultValueForRamp)) {
				stateConfigurationsForRamp.add(toStateConfiguration( //
						keyCodeLine, //
						roleConfiguration, //
						defaultValueForRamp, //
						defaultStateConfigurations.isStateful(keyCodeLine.getCallback()) //
				));
			}
			var defaultValueForTaxi = defaultStateConfigurations.getDefaultValue(keyCodeLine.getCallback(), TAXI);
			if (isValidDefaultValue(roleConfiguration, defaultValueForTaxi)) {
				stateConfigurationsForTaxi.add(toStateConfiguration( //
						keyCodeLine, //
						roleConfiguration, //
						defaultValueForTaxi, //
						defaultStateConfigurations.isStateful(keyCodeLine.getCallback()) //
				));
			}
			var defaultValueForAir = defaultStateConfigurations.getDefaultValue(keyCodeLine.getCallback(), AIR);
			if (isValidDefaultValue(roleConfiguration, defaultValueForAir)) {
				stateConfigurationsForAir.add(toStateConfiguration( //
						keyCodeLine, //
						roleConfiguration, //
						defaultValueForAir, //
						defaultStateConfigurations.isStateful(keyCodeLine.getCallback()) //
				));
			}
		}
		writeObject( //
				new File(target, "states_ramp.json"), //
				new StateConfigurationStore(stateConfigurationsForRamp));
		writeObject(//
				new File(target, "states_taxi.json"), //
				new StateConfigurationStore(stateConfigurationsForTaxi));
		writeObject( //
				new File(target, "states_air.json"), //
				new StateConfigurationStore(stateConfigurationsForAir));
		return defaultStateConfigurations;
	}

	private boolean isStateful(KeyCodeLine keyCodeLine, RoleConfigurations roleConfigurations) {
		RoleConfiguration roleConfiguration = roleConfigurations.getRoleConfiguration(keyCodeLine.getCallback());
		String role = roleConfiguration.getRole();
		String style = roleConfiguration.getStyle();
		if (equal(style, "switch")) {
			return true;
		}
		if (equal(style, "knob") //
				&& (!equal(role, "left") //
						&& !equal(role, "right") //
						&& !equal(role, "increase") //
						&& !equal(role, "decrease") //
						&& !equal(role, "up") //
						&& !equal(role, "down") //
				)) {
			return true;
		}
		if (equal(style, "handle") //
				&& (equal(role, "on") //
						|| equal(role, "off") //
						|| equal(role, "down") //
						|| equal(role, "up") //
				)) {
			return true;
		}
		return false;
	}

	private StateConfiguration toStateConfiguration( //
			KeyCodeLine keyCodeLine, //
			RoleConfiguration roleConfiguration, //
			Object defaultValue, //
			boolean stateful //
	) {
		StateConfiguration stateConfiguration = new StateConfiguration();
		stateConfiguration.setCallback(keyCodeLine.getCallback());
		Collection<String> relatedCallbacks;
		if (roleConfiguration.getRelatedCallbacks() == null) {
			relatedCallbacks = emptyList();
		} else {
			relatedCallbacks = newArrayList(roleConfiguration.getRelatedCallbacks());
		}
		stateConfiguration.setRelatedStateConfigurations(relatedCallbacks);
		if (defaultValue instanceof Boolean) {
			stateConfiguration.setActive((Boolean) defaultValue);
			stateConfiguration.setStateful(stateful);
		}
		return stateConfiguration;
	}

}