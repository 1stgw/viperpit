package de.viperpit.agent.data;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.viperpit.agent.data.SharedMemoryReader.SharedMemoryData;

@Component
public abstract class AbstractSharedMemoryStateProvider {

	private static final Collection<String> STATES = newArrayList(
		"airAirSourceKnobDump",
		"airAirSourceKnobNorm",
		"airAirSourceKnobOff",
		"airAirSourceKnobRam",
		"audio1Comm1KnobPowerOff",
		"audio1Comm1KnobPowerOn",
		"audio1Comm1ModeKnobGd",
		"audio1Comm1ModeKnobSql",
		"audio1Comm2KnobPowerOff",
		"audio1Comm2KnobPowerOn",
		"audio1Comm2ModeKnobGd",
		"audio1Comm2ModeKnobSql",
		"audio2IlsKnobOff",
		"audio2IlsKnobOn",
		"auxCniKnobSwitchBackup",
		"auxCniKnobSwitchUfc",
		"auxM4CodeSwitchHold",
		"auxM4CodeSwitchZero",
		"auxMasterKnobEmer",
		"auxMasterKnobLow",
		"auxMasterKnobNorm",
		"auxMasterKnobOff",
		"auxMasterKnobStby",
		"auxMonitorSwitchAudio",
		"auxMonitorSwitchOut",
		"auxReplySwitchA",
		"auxReplySwitchB",
		"auxReplySwitchOut",
		"auxStationSelectorSwitchAATr",
		"auxStationSelectorSwitchTR",
		"avionicsDlSwitchOff",
		"avionicsDlSwitchOn",
		"avionicsFccSwitchOff",
		"avionicsFccSwitchOn",
		"avionicsGpsSwitchOff",
		"avionicsGpsSwitchOn",
		"avionicsInsKnobInFltAlign",
		"avionicsInsKnobNav",
		"avionicsInsKnobNorm",
		"avionicsInsKnobOff",
		"avionicsMfdSwitchOff",
		"avionicsMfdSwitchOn",
		"avionicsSmsSwitchOff",
		"avionicsSmsSwitchOn",
		"avionicsUfcSwitchOff",
		"avionicsUfcSwitchOn",
		"avtrAvtrSwitchAuto",
		"avtrAvtrSwitchOff",
		"avtrAvtrSwitchOn",
		"cmdsChSwitchPowerOff",
		"cmdsChSwitchPowerOn",
		"cmdsFlSwitchPowerOff",
		"cmdsFlSwitchPowerOn",
		"cmdsJettSwitchOff",
		"cmdsJettSwitchOn",
		"cmdsJmrSwitchPowerOff",
		"cmdsJmrSwitchPowerOn",
		"cmdsModeKnobAuto",
		"cmdsModeKnobByp",
		"cmdsModeKnobMan",
		"cmdsModeKnobOff",
		"cmdsModeKnobSemi",
		"cmdsModeKnobStby",
		"cmdsMwsSwitchPowerOff",
		"cmdsMwsSwitchPowerOn",
		"cmdsO1SwitchPowerOff",
		"cmdsO1SwitchPowerOn",
		"cmdsO2SwitchPowerOff",
		"cmdsO2SwitchPowerOn",
		"cmdsPrgmKnob1",
		"cmdsPrgmKnob2",
		"cmdsPrgmKnob3",
		"cmdsPrgmKnob4",
		"cmdsRwrSwitchPowerOff",
		"cmdsRwrSwitchPowerOn",
		"ecmOprSwitchOff",
		"ecmOprSwitchOpr",
		"elecMainPwrSwitchBatt",
		"elecMainPwrSwitchMain",
		"elecMainPwrSwitchOff",
		"engEngContSwitchPri",
		"engEngContSwitchSec",
		"engJfsSwitchOff",
		"engJfsSwitchStart2",
		"epuEpuSwitchNorm",
		"epuEpuSwitchOff",
		"epuEpuSwitchOn",
		"extAntiCollisionSwitchOff",
		"extAntiCollisionSwitchOn",
		"extMasterSwitchNorm",
		"extMasterSwitchOff",
		"extPositionSwitchFlash",
		"extPositionSwitchSteady",
		"extWingTailSwitchBrt",
		"extWingTailSwitchOff",
		"fltAltFlapsSwitchExtend",
		"fltAltFlapsSwitchNorm",
		"fltDigitalSwitchBackup",
		"fltDigitalSwitchOff",
		"fltLeFlapsSwitchAuto",
		"fltLeFlapsSwitchLock",
		"fltManualTfFlyupSwitchDisable",
		"fltManualTfFlyupSwitchEnable",
		"fuelAirRefuelSwitchClose",
		"fuelAirRefuelSwitchOpen",
		"fuelEngFeedKnobAft",
		"fuelEngFeedKnobFwd",
		"fuelEngFeedKnobNorm",
		"fuelEngFeedKnobOff",
		"fuelMasterSwitchOff",
		"fuelMasterSwitchOn",
		"gearGndJettSwitchEnable",
		"gearGndJettSwitchOff",
		"gearHookSwitchDn",
		"gearHookSwitchUp",
		"gearLgHandleDn",
		"gearLgHandleUp",
		"gearLightsSwitchLanding",
		"gearLightsSwitchOff",
		"gearParkingBreakSwitchOff",
		"gearParkingBreakSwitchOn",
		"gearStoresConfigSwitchCatI",
		"gearStoresConfigSwitchCatIii",
		"hmcsHmscKnobOff",
		"hmcsHmscKnobOn",
		"hudAltitudeSwitchAuto",
		"hudAltitudeSwitchBaro",
		"hudAltitudeSwitchRadar",
		"hudBrightnessSwitchAutoBrt",
		"hudBrightnessSwitchDay",
		"hudBrightnessSwitchNig",
		"hudDedDataSwitchDed",
		"hudDedDataSwitchOff",
		"hudDedDataSwitchPfl",
		"hudDeprRetSwitchOff",
		"hudDeprRetSwitchPri",
		"hudDeprRetSwitchStby",
		"hudFpmSwitchAttFpm",
		"hudFpmSwitchFpm",
		"hudFpmSwitchOff",
		"hudScalesSwitchOff",
		"hudScalesSwitchVah",
		"hudScalesSwitchVvVah",
		"hudVelocitySwitchCas",
		"hudVelocitySwitchGndSpd",
		"hudVelocitySwitchTas",
		"instrModeKnobIlsNav",
		"instrModeKnobIlsTcn",
		"instrModeKnobNav",
		"instrModeKnobTcn",
		"mainAltimeterPressureKnobDecr1",
		"mainAltimeterPressureKnobDecr5",
		"mainAltimeterPressureKnobIncr1",
		"mainAltimeterPressureKnobIncr5",
		"mainHsiCrsKnobDecrease1",
		"mainHsiCrsKnobDecrease5",
		"mainHsiCrsKnobIncrease1",
		"mainHsiCrsKnobIncrease5",
		"mainHsiHdgKnobDecrease1",
		"mainHsiHdgKnobDecrease5",
		"mainHsiHdgKnobIncrease1",
		"mainHsiHdgKnobIncrease5",
		"miscLaserSwitchArm",
		"miscLaserSwitchOff",
		"miscMasterArmSwitchOff",
		"miscMasterArmSwitchOn",
		"miscMasterArmSwitchSim",
		"miscPitchSwitchAPOff",
		"miscPitchSwitchAltHold",
		"miscPitchSwitchAttHold",
		"miscRfSwitchNorm",
		"miscRfSwitchQuiet",
		"miscRfSwitchSilent",
		"miscRollSwitchAttHold",
		"miscRollSwitchHdgSel",
		"miscRollSwitchStrgSel",
		"qtyExtFuelTransSwitchNorm",
		"qtyExtFuelTransSwitchWingFirst",
		"qtyFuelQtySelKnobExtCtr",
		"qtyFuelQtySelKnobExtWing",
		"qtyFuelQtySelKnobIntWing",
		"qtyFuelQtySelKnobNorm",
		"qtyFuelQtySelKnobRsvr",
		"qtyFuelQtySelKnobTest",
		"snsrFcrSwitchOff",
		"snsrFcrSwitchOn",
		"snsrLeftHdptSwitchOff",
		"snsrLeftHdptSwitchOn",
		"snsrRdrAltSwitchOff",
		"snsrRdrAltSwitchOn",
		"snsrRdrAltSwitchStdby",
		"snsrRightHdptSwitchOff",
		"snsrRightHdptSwitchOn",
		"testProbeHeatSwitchOff",
		"testProbeHeatSwitchOn",
		"testProbeHeatSwitchTest",
		"trimTrimApDiscSwitchDisc",
		"trimTrimApDiscSwitchNorm",
		"uhfFunctionKnobBoth",
		"uhfFunctionKnobMain",
		"uhfFunctionKnobOff",
		"uhfModeKnobGrd",
		"uhfModeKnobMnl",
		"uhfModeKnobPreset",
		"zeroVmsSwitchInhibit",
		"zeroVmsSwitchOn"
	);

	@Autowired
	private SharedMemoryReader sharedMemoryReader;

	protected SharedMemoryReader getSharedMemoryReader() {
		return sharedMemoryReader;
	}

	public Map<String, Object> getStates() {
		Map<String, Object> states = new LinkedHashMap<>(STATES.size());
		SharedMemoryData sharedMemoryData = sharedMemoryReader.readData();
		if (sharedMemoryData != null) {
			for (String id : STATES) {
				Object state = getStateFromSharedMemory(id, sharedMemoryData);
				if (state != null) {
					states.put(id, state);
				}
			}
		}
		return states;
	}

	protected Object getStateFromSharedMemory(String id, SharedMemoryData sharedMemoryData) {
		switch (id) {
			case "airAirSourceKnobDump":
				return getAirAirSourceKnobDump(id, sharedMemoryData);
			case "airAirSourceKnobNorm":
				return getAirAirSourceKnobNorm(id, sharedMemoryData);
			case "airAirSourceKnobOff":
				return getAirAirSourceKnobOff(id, sharedMemoryData);
			case "airAirSourceKnobRam":
				return getAirAirSourceKnobRam(id, sharedMemoryData);
			case "audio1Comm1KnobPowerOff":
				return getAudio1Comm1KnobPowerOff(id, sharedMemoryData);
			case "audio1Comm1KnobPowerOn":
				return getAudio1Comm1KnobPowerOn(id, sharedMemoryData);
			case "audio1Comm1ModeKnobGd":
				return getAudio1Comm1ModeKnobGd(id, sharedMemoryData);
			case "audio1Comm1ModeKnobSql":
				return getAudio1Comm1ModeKnobSql(id, sharedMemoryData);
			case "audio1Comm2KnobPowerOff":
				return getAudio1Comm2KnobPowerOff(id, sharedMemoryData);
			case "audio1Comm2KnobPowerOn":
				return getAudio1Comm2KnobPowerOn(id, sharedMemoryData);
			case "audio1Comm2ModeKnobGd":
				return getAudio1Comm2ModeKnobGd(id, sharedMemoryData);
			case "audio1Comm2ModeKnobSql":
				return getAudio1Comm2ModeKnobSql(id, sharedMemoryData);
			case "audio2IlsKnobOff":
				return getAudio2IlsKnobOff(id, sharedMemoryData);
			case "audio2IlsKnobOn":
				return getAudio2IlsKnobOn(id, sharedMemoryData);
			case "auxCniKnobSwitchBackup":
				return getAuxCniKnobSwitchBackup(id, sharedMemoryData);
			case "auxCniKnobSwitchUfc":
				return getAuxCniKnobSwitchUfc(id, sharedMemoryData);
			case "auxM4CodeSwitchHold":
				return getAuxM4CodeSwitchHold(id, sharedMemoryData);
			case "auxM4CodeSwitchZero":
				return getAuxM4CodeSwitchZero(id, sharedMemoryData);
			case "auxMasterKnobEmer":
				return getAuxMasterKnobEmer(id, sharedMemoryData);
			case "auxMasterKnobLow":
				return getAuxMasterKnobLow(id, sharedMemoryData);
			case "auxMasterKnobNorm":
				return getAuxMasterKnobNorm(id, sharedMemoryData);
			case "auxMasterKnobOff":
				return getAuxMasterKnobOff(id, sharedMemoryData);
			case "auxMasterKnobStby":
				return getAuxMasterKnobStby(id, sharedMemoryData);
			case "auxMonitorSwitchAudio":
				return getAuxMonitorSwitchAudio(id, sharedMemoryData);
			case "auxMonitorSwitchOut":
				return getAuxMonitorSwitchOut(id, sharedMemoryData);
			case "auxReplySwitchA":
				return getAuxReplySwitchA(id, sharedMemoryData);
			case "auxReplySwitchB":
				return getAuxReplySwitchB(id, sharedMemoryData);
			case "auxReplySwitchOut":
				return getAuxReplySwitchOut(id, sharedMemoryData);
			case "auxStationSelectorSwitchAATr":
				return getAuxStationSelectorSwitchAATr(id, sharedMemoryData);
			case "auxStationSelectorSwitchTR":
				return getAuxStationSelectorSwitchTR(id, sharedMemoryData);
			case "avionicsDlSwitchOff":
				return getAvionicsDlSwitchOff(id, sharedMemoryData);
			case "avionicsDlSwitchOn":
				return getAvionicsDlSwitchOn(id, sharedMemoryData);
			case "avionicsFccSwitchOff":
				return getAvionicsFccSwitchOff(id, sharedMemoryData);
			case "avionicsFccSwitchOn":
				return getAvionicsFccSwitchOn(id, sharedMemoryData);
			case "avionicsGpsSwitchOff":
				return getAvionicsGpsSwitchOff(id, sharedMemoryData);
			case "avionicsGpsSwitchOn":
				return getAvionicsGpsSwitchOn(id, sharedMemoryData);
			case "avionicsInsKnobInFltAlign":
				return getAvionicsInsKnobInFltAlign(id, sharedMemoryData);
			case "avionicsInsKnobNav":
				return getAvionicsInsKnobNav(id, sharedMemoryData);
			case "avionicsInsKnobNorm":
				return getAvionicsInsKnobNorm(id, sharedMemoryData);
			case "avionicsInsKnobOff":
				return getAvionicsInsKnobOff(id, sharedMemoryData);
			case "avionicsMfdSwitchOff":
				return getAvionicsMfdSwitchOff(id, sharedMemoryData);
			case "avionicsMfdSwitchOn":
				return getAvionicsMfdSwitchOn(id, sharedMemoryData);
			case "avionicsSmsSwitchOff":
				return getAvionicsSmsSwitchOff(id, sharedMemoryData);
			case "avionicsSmsSwitchOn":
				return getAvionicsSmsSwitchOn(id, sharedMemoryData);
			case "avionicsUfcSwitchOff":
				return getAvionicsUfcSwitchOff(id, sharedMemoryData);
			case "avionicsUfcSwitchOn":
				return getAvionicsUfcSwitchOn(id, sharedMemoryData);
			case "avtrAvtrSwitchAuto":
				return getAvtrAvtrSwitchAuto(id, sharedMemoryData);
			case "avtrAvtrSwitchOff":
				return getAvtrAvtrSwitchOff(id, sharedMemoryData);
			case "avtrAvtrSwitchOn":
				return getAvtrAvtrSwitchOn(id, sharedMemoryData);
			case "cmdsChSwitchPowerOff":
				return getCmdsChSwitchPowerOff(id, sharedMemoryData);
			case "cmdsChSwitchPowerOn":
				return getCmdsChSwitchPowerOn(id, sharedMemoryData);
			case "cmdsFlSwitchPowerOff":
				return getCmdsFlSwitchPowerOff(id, sharedMemoryData);
			case "cmdsFlSwitchPowerOn":
				return getCmdsFlSwitchPowerOn(id, sharedMemoryData);
			case "cmdsJettSwitchOff":
				return getCmdsJettSwitchOff(id, sharedMemoryData);
			case "cmdsJettSwitchOn":
				return getCmdsJettSwitchOn(id, sharedMemoryData);
			case "cmdsJmrSwitchPowerOff":
				return getCmdsJmrSwitchPowerOff(id, sharedMemoryData);
			case "cmdsJmrSwitchPowerOn":
				return getCmdsJmrSwitchPowerOn(id, sharedMemoryData);
			case "cmdsModeKnobAuto":
				return getCmdsModeKnobAuto(id, sharedMemoryData);
			case "cmdsModeKnobByp":
				return getCmdsModeKnobByp(id, sharedMemoryData);
			case "cmdsModeKnobMan":
				return getCmdsModeKnobMan(id, sharedMemoryData);
			case "cmdsModeKnobOff":
				return getCmdsModeKnobOff(id, sharedMemoryData);
			case "cmdsModeKnobSemi":
				return getCmdsModeKnobSemi(id, sharedMemoryData);
			case "cmdsModeKnobStby":
				return getCmdsModeKnobStby(id, sharedMemoryData);
			case "cmdsMwsSwitchPowerOff":
				return getCmdsMwsSwitchPowerOff(id, sharedMemoryData);
			case "cmdsMwsSwitchPowerOn":
				return getCmdsMwsSwitchPowerOn(id, sharedMemoryData);
			case "cmdsO1SwitchPowerOff":
				return getCmdsO1SwitchPowerOff(id, sharedMemoryData);
			case "cmdsO1SwitchPowerOn":
				return getCmdsO1SwitchPowerOn(id, sharedMemoryData);
			case "cmdsO2SwitchPowerOff":
				return getCmdsO2SwitchPowerOff(id, sharedMemoryData);
			case "cmdsO2SwitchPowerOn":
				return getCmdsO2SwitchPowerOn(id, sharedMemoryData);
			case "cmdsPrgmKnob1":
				return getCmdsPrgmKnob1(id, sharedMemoryData);
			case "cmdsPrgmKnob2":
				return getCmdsPrgmKnob2(id, sharedMemoryData);
			case "cmdsPrgmKnob3":
				return getCmdsPrgmKnob3(id, sharedMemoryData);
			case "cmdsPrgmKnob4":
				return getCmdsPrgmKnob4(id, sharedMemoryData);
			case "cmdsRwrSwitchPowerOff":
				return getCmdsRwrSwitchPowerOff(id, sharedMemoryData);
			case "cmdsRwrSwitchPowerOn":
				return getCmdsRwrSwitchPowerOn(id, sharedMemoryData);
			case "ecmOprSwitchOff":
				return getEcmOprSwitchOff(id, sharedMemoryData);
			case "ecmOprSwitchOpr":
				return getEcmOprSwitchOpr(id, sharedMemoryData);
			case "elecMainPwrSwitchBatt":
				return getElecMainPwrSwitchBatt(id, sharedMemoryData);
			case "elecMainPwrSwitchMain":
				return getElecMainPwrSwitchMain(id, sharedMemoryData);
			case "elecMainPwrSwitchOff":
				return getElecMainPwrSwitchOff(id, sharedMemoryData);
			case "engEngContSwitchPri":
				return getEngEngContSwitchPri(id, sharedMemoryData);
			case "engEngContSwitchSec":
				return getEngEngContSwitchSec(id, sharedMemoryData);
			case "engJfsSwitchOff":
				return getEngJfsSwitchOff(id, sharedMemoryData);
			case "engJfsSwitchStart2":
				return getEngJfsSwitchStart2(id, sharedMemoryData);
			case "epuEpuSwitchNorm":
				return getEpuEpuSwitchNorm(id, sharedMemoryData);
			case "epuEpuSwitchOff":
				return getEpuEpuSwitchOff(id, sharedMemoryData);
			case "epuEpuSwitchOn":
				return getEpuEpuSwitchOn(id, sharedMemoryData);
			case "extAntiCollisionSwitchOff":
				return getExtAntiCollisionSwitchOff(id, sharedMemoryData);
			case "extAntiCollisionSwitchOn":
				return getExtAntiCollisionSwitchOn(id, sharedMemoryData);
			case "extMasterSwitchNorm":
				return getExtMasterSwitchNorm(id, sharedMemoryData);
			case "extMasterSwitchOff":
				return getExtMasterSwitchOff(id, sharedMemoryData);
			case "extPositionSwitchFlash":
				return getExtPositionSwitchFlash(id, sharedMemoryData);
			case "extPositionSwitchSteady":
				return getExtPositionSwitchSteady(id, sharedMemoryData);
			case "extWingTailSwitchBrt":
				return getExtWingTailSwitchBrt(id, sharedMemoryData);
			case "extWingTailSwitchOff":
				return getExtWingTailSwitchOff(id, sharedMemoryData);
			case "fltAltFlapsSwitchExtend":
				return getFltAltFlapsSwitchExtend(id, sharedMemoryData);
			case "fltAltFlapsSwitchNorm":
				return getFltAltFlapsSwitchNorm(id, sharedMemoryData);
			case "fltDigitalSwitchBackup":
				return getFltDigitalSwitchBackup(id, sharedMemoryData);
			case "fltDigitalSwitchOff":
				return getFltDigitalSwitchOff(id, sharedMemoryData);
			case "fltLeFlapsSwitchAuto":
				return getFltLeFlapsSwitchAuto(id, sharedMemoryData);
			case "fltLeFlapsSwitchLock":
				return getFltLeFlapsSwitchLock(id, sharedMemoryData);
			case "fltManualTfFlyupSwitchDisable":
				return getFltManualTfFlyupSwitchDisable(id, sharedMemoryData);
			case "fltManualTfFlyupSwitchEnable":
				return getFltManualTfFlyupSwitchEnable(id, sharedMemoryData);
			case "fuelAirRefuelSwitchClose":
				return getFuelAirRefuelSwitchClose(id, sharedMemoryData);
			case "fuelAirRefuelSwitchOpen":
				return getFuelAirRefuelSwitchOpen(id, sharedMemoryData);
			case "fuelEngFeedKnobAft":
				return getFuelEngFeedKnobAft(id, sharedMemoryData);
			case "fuelEngFeedKnobFwd":
				return getFuelEngFeedKnobFwd(id, sharedMemoryData);
			case "fuelEngFeedKnobNorm":
				return getFuelEngFeedKnobNorm(id, sharedMemoryData);
			case "fuelEngFeedKnobOff":
				return getFuelEngFeedKnobOff(id, sharedMemoryData);
			case "fuelMasterSwitchOff":
				return getFuelMasterSwitchOff(id, sharedMemoryData);
			case "fuelMasterSwitchOn":
				return getFuelMasterSwitchOn(id, sharedMemoryData);
			case "gearGndJettSwitchEnable":
				return getGearGndJettSwitchEnable(id, sharedMemoryData);
			case "gearGndJettSwitchOff":
				return getGearGndJettSwitchOff(id, sharedMemoryData);
			case "gearHookSwitchDn":
				return getGearHookSwitchDn(id, sharedMemoryData);
			case "gearHookSwitchUp":
				return getGearHookSwitchUp(id, sharedMemoryData);
			case "gearLgHandleDn":
				return getGearLgHandleDn(id, sharedMemoryData);
			case "gearLgHandleUp":
				return getGearLgHandleUp(id, sharedMemoryData);
			case "gearLightsSwitchLanding":
				return getGearLightsSwitchLanding(id, sharedMemoryData);
			case "gearLightsSwitchOff":
				return getGearLightsSwitchOff(id, sharedMemoryData);
			case "gearParkingBreakSwitchOff":
				return getGearParkingBreakSwitchOff(id, sharedMemoryData);
			case "gearParkingBreakSwitchOn":
				return getGearParkingBreakSwitchOn(id, sharedMemoryData);
			case "gearStoresConfigSwitchCatI":
				return getGearStoresConfigSwitchCatI(id, sharedMemoryData);
			case "gearStoresConfigSwitchCatIii":
				return getGearStoresConfigSwitchCatIii(id, sharedMemoryData);
			case "hmcsHmscKnobOff":
				return getHmcsHmscKnobOff(id, sharedMemoryData);
			case "hmcsHmscKnobOn":
				return getHmcsHmscKnobOn(id, sharedMemoryData);
			case "hudAltitudeSwitchAuto":
				return getHudAltitudeSwitchAuto(id, sharedMemoryData);
			case "hudAltitudeSwitchBaro":
				return getHudAltitudeSwitchBaro(id, sharedMemoryData);
			case "hudAltitudeSwitchRadar":
				return getHudAltitudeSwitchRadar(id, sharedMemoryData);
			case "hudBrightnessSwitchAutoBrt":
				return getHudBrightnessSwitchAutoBrt(id, sharedMemoryData);
			case "hudBrightnessSwitchDay":
				return getHudBrightnessSwitchDay(id, sharedMemoryData);
			case "hudBrightnessSwitchNig":
				return getHudBrightnessSwitchNig(id, sharedMemoryData);
			case "hudDedDataSwitchDed":
				return getHudDedDataSwitchDed(id, sharedMemoryData);
			case "hudDedDataSwitchOff":
				return getHudDedDataSwitchOff(id, sharedMemoryData);
			case "hudDedDataSwitchPfl":
				return getHudDedDataSwitchPfl(id, sharedMemoryData);
			case "hudDeprRetSwitchOff":
				return getHudDeprRetSwitchOff(id, sharedMemoryData);
			case "hudDeprRetSwitchPri":
				return getHudDeprRetSwitchPri(id, sharedMemoryData);
			case "hudDeprRetSwitchStby":
				return getHudDeprRetSwitchStby(id, sharedMemoryData);
			case "hudFpmSwitchAttFpm":
				return getHudFpmSwitchAttFpm(id, sharedMemoryData);
			case "hudFpmSwitchFpm":
				return getHudFpmSwitchFpm(id, sharedMemoryData);
			case "hudFpmSwitchOff":
				return getHudFpmSwitchOff(id, sharedMemoryData);
			case "hudScalesSwitchOff":
				return getHudScalesSwitchOff(id, sharedMemoryData);
			case "hudScalesSwitchVah":
				return getHudScalesSwitchVah(id, sharedMemoryData);
			case "hudScalesSwitchVvVah":
				return getHudScalesSwitchVvVah(id, sharedMemoryData);
			case "hudVelocitySwitchCas":
				return getHudVelocitySwitchCas(id, sharedMemoryData);
			case "hudVelocitySwitchGndSpd":
				return getHudVelocitySwitchGndSpd(id, sharedMemoryData);
			case "hudVelocitySwitchTas":
				return getHudVelocitySwitchTas(id, sharedMemoryData);
			case "instrModeKnobIlsNav":
				return getInstrModeKnobIlsNav(id, sharedMemoryData);
			case "instrModeKnobIlsTcn":
				return getInstrModeKnobIlsTcn(id, sharedMemoryData);
			case "instrModeKnobNav":
				return getInstrModeKnobNav(id, sharedMemoryData);
			case "instrModeKnobTcn":
				return getInstrModeKnobTcn(id, sharedMemoryData);
			case "mainAltimeterPressureKnobDecr1":
				return getMainAltimeterPressureKnobDecr1(id, sharedMemoryData);
			case "mainAltimeterPressureKnobDecr5":
				return getMainAltimeterPressureKnobDecr5(id, sharedMemoryData);
			case "mainAltimeterPressureKnobIncr1":
				return getMainAltimeterPressureKnobIncr1(id, sharedMemoryData);
			case "mainAltimeterPressureKnobIncr5":
				return getMainAltimeterPressureKnobIncr5(id, sharedMemoryData);
			case "mainHsiCrsKnobDecrease1":
				return getMainHsiCrsKnobDecrease1(id, sharedMemoryData);
			case "mainHsiCrsKnobDecrease5":
				return getMainHsiCrsKnobDecrease5(id, sharedMemoryData);
			case "mainHsiCrsKnobIncrease1":
				return getMainHsiCrsKnobIncrease1(id, sharedMemoryData);
			case "mainHsiCrsKnobIncrease5":
				return getMainHsiCrsKnobIncrease5(id, sharedMemoryData);
			case "mainHsiHdgKnobDecrease1":
				return getMainHsiHdgKnobDecrease1(id, sharedMemoryData);
			case "mainHsiHdgKnobDecrease5":
				return getMainHsiHdgKnobDecrease5(id, sharedMemoryData);
			case "mainHsiHdgKnobIncrease1":
				return getMainHsiHdgKnobIncrease1(id, sharedMemoryData);
			case "mainHsiHdgKnobIncrease5":
				return getMainHsiHdgKnobIncrease5(id, sharedMemoryData);
			case "miscLaserSwitchArm":
				return getMiscLaserSwitchArm(id, sharedMemoryData);
			case "miscLaserSwitchOff":
				return getMiscLaserSwitchOff(id, sharedMemoryData);
			case "miscMasterArmSwitchOff":
				return getMiscMasterArmSwitchOff(id, sharedMemoryData);
			case "miscMasterArmSwitchOn":
				return getMiscMasterArmSwitchOn(id, sharedMemoryData);
			case "miscMasterArmSwitchSim":
				return getMiscMasterArmSwitchSim(id, sharedMemoryData);
			case "miscPitchSwitchAPOff":
				return getMiscPitchSwitchAPOff(id, sharedMemoryData);
			case "miscPitchSwitchAltHold":
				return getMiscPitchSwitchAltHold(id, sharedMemoryData);
			case "miscPitchSwitchAttHold":
				return getMiscPitchSwitchAttHold(id, sharedMemoryData);
			case "miscRfSwitchNorm":
				return getMiscRfSwitchNorm(id, sharedMemoryData);
			case "miscRfSwitchQuiet":
				return getMiscRfSwitchQuiet(id, sharedMemoryData);
			case "miscRfSwitchSilent":
				return getMiscRfSwitchSilent(id, sharedMemoryData);
			case "miscRollSwitchAttHold":
				return getMiscRollSwitchAttHold(id, sharedMemoryData);
			case "miscRollSwitchHdgSel":
				return getMiscRollSwitchHdgSel(id, sharedMemoryData);
			case "miscRollSwitchStrgSel":
				return getMiscRollSwitchStrgSel(id, sharedMemoryData);
			case "qtyExtFuelTransSwitchNorm":
				return getQtyExtFuelTransSwitchNorm(id, sharedMemoryData);
			case "qtyExtFuelTransSwitchWingFirst":
				return getQtyExtFuelTransSwitchWingFirst(id, sharedMemoryData);
			case "qtyFuelQtySelKnobExtCtr":
				return getQtyFuelQtySelKnobExtCtr(id, sharedMemoryData);
			case "qtyFuelQtySelKnobExtWing":
				return getQtyFuelQtySelKnobExtWing(id, sharedMemoryData);
			case "qtyFuelQtySelKnobIntWing":
				return getQtyFuelQtySelKnobIntWing(id, sharedMemoryData);
			case "qtyFuelQtySelKnobNorm":
				return getQtyFuelQtySelKnobNorm(id, sharedMemoryData);
			case "qtyFuelQtySelKnobRsvr":
				return getQtyFuelQtySelKnobRsvr(id, sharedMemoryData);
			case "qtyFuelQtySelKnobTest":
				return getQtyFuelQtySelKnobTest(id, sharedMemoryData);
			case "snsrFcrSwitchOff":
				return getSnsrFcrSwitchOff(id, sharedMemoryData);
			case "snsrFcrSwitchOn":
				return getSnsrFcrSwitchOn(id, sharedMemoryData);
			case "snsrLeftHdptSwitchOff":
				return getSnsrLeftHdptSwitchOff(id, sharedMemoryData);
			case "snsrLeftHdptSwitchOn":
				return getSnsrLeftHdptSwitchOn(id, sharedMemoryData);
			case "snsrRdrAltSwitchOff":
				return getSnsrRdrAltSwitchOff(id, sharedMemoryData);
			case "snsrRdrAltSwitchOn":
				return getSnsrRdrAltSwitchOn(id, sharedMemoryData);
			case "snsrRdrAltSwitchStdby":
				return getSnsrRdrAltSwitchStdby(id, sharedMemoryData);
			case "snsrRightHdptSwitchOff":
				return getSnsrRightHdptSwitchOff(id, sharedMemoryData);
			case "snsrRightHdptSwitchOn":
				return getSnsrRightHdptSwitchOn(id, sharedMemoryData);
			case "testProbeHeatSwitchOff":
				return getTestProbeHeatSwitchOff(id, sharedMemoryData);
			case "testProbeHeatSwitchOn":
				return getTestProbeHeatSwitchOn(id, sharedMemoryData);
			case "testProbeHeatSwitchTest":
				return getTestProbeHeatSwitchTest(id, sharedMemoryData);
			case "trimTrimApDiscSwitchDisc":
				return getTrimTrimApDiscSwitchDisc(id, sharedMemoryData);
			case "trimTrimApDiscSwitchNorm":
				return getTrimTrimApDiscSwitchNorm(id, sharedMemoryData);
			case "uhfFunctionKnobBoth":
				return getUhfFunctionKnobBoth(id, sharedMemoryData);
			case "uhfFunctionKnobMain":
				return getUhfFunctionKnobMain(id, sharedMemoryData);
			case "uhfFunctionKnobOff":
				return getUhfFunctionKnobOff(id, sharedMemoryData);
			case "uhfModeKnobGrd":
				return getUhfModeKnobGrd(id, sharedMemoryData);
			case "uhfModeKnobMnl":
				return getUhfModeKnobMnl(id, sharedMemoryData);
			case "uhfModeKnobPreset":
				return getUhfModeKnobPreset(id, sharedMemoryData);
			case "zeroVmsSwitchInhibit":
				return getZeroVmsSwitchInhibit(id, sharedMemoryData);
			case "zeroVmsSwitchOn":
				return getZeroVmsSwitchOn(id, sharedMemoryData);
			default:
				return null;
		}
	}

	protected Object getAirAirSourceKnobDump(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAirAirSourceKnobNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAirAirSourceKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAirAirSourceKnobRam(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm1KnobPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm1KnobPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm1ModeKnobGd(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm1ModeKnobSql(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm2KnobPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm2KnobPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm2ModeKnobGd(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio1Comm2ModeKnobSql(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio2IlsKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAudio2IlsKnobOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxCniKnobSwitchBackup(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxCniKnobSwitchUfc(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxM4CodeSwitchHold(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxM4CodeSwitchZero(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxMasterKnobEmer(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxMasterKnobLow(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxMasterKnobNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxMasterKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxMasterKnobStby(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxMonitorSwitchAudio(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxMonitorSwitchOut(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxReplySwitchA(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxReplySwitchB(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxReplySwitchOut(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxStationSelectorSwitchAATr(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAuxStationSelectorSwitchTR(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsDlSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsDlSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsFccSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsFccSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsGpsSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsGpsSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsInsKnobInFltAlign(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsInsKnobNav(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsInsKnobNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsInsKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsMfdSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsMfdSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsSmsSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsSmsSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsUfcSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvionicsUfcSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvtrAvtrSwitchAuto(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvtrAvtrSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAvtrAvtrSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsChSwitchPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsChSwitchPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsFlSwitchPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsFlSwitchPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsJettSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsJettSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsJmrSwitchPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsJmrSwitchPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsModeKnobAuto(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsModeKnobByp(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsModeKnobMan(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsModeKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsModeKnobSemi(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsModeKnobStby(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsMwsSwitchPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsMwsSwitchPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsO1SwitchPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsO1SwitchPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsO2SwitchPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsO2SwitchPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsPrgmKnob1(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsPrgmKnob2(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsPrgmKnob3(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsPrgmKnob4(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsRwrSwitchPowerOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getCmdsRwrSwitchPowerOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEcmOprSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEcmOprSwitchOpr(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getElecMainPwrSwitchBatt(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getElecMainPwrSwitchMain(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getElecMainPwrSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEngEngContSwitchPri(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEngEngContSwitchSec(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEngJfsSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEngJfsSwitchStart2(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEpuEpuSwitchNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEpuEpuSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getEpuEpuSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtAntiCollisionSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtAntiCollisionSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtMasterSwitchNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtMasterSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtPositionSwitchFlash(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtPositionSwitchSteady(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtWingTailSwitchBrt(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getExtWingTailSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltAltFlapsSwitchExtend(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltAltFlapsSwitchNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltDigitalSwitchBackup(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltDigitalSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltLeFlapsSwitchAuto(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltLeFlapsSwitchLock(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltManualTfFlyupSwitchDisable(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFltManualTfFlyupSwitchEnable(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelAirRefuelSwitchClose(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelAirRefuelSwitchOpen(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelEngFeedKnobAft(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelEngFeedKnobFwd(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelEngFeedKnobNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelEngFeedKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelMasterSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getFuelMasterSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearGndJettSwitchEnable(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearGndJettSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearHookSwitchDn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearHookSwitchUp(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearLgHandleDn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearLgHandleUp(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearLightsSwitchLanding(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearLightsSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearParkingBreakSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearParkingBreakSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearStoresConfigSwitchCatI(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getGearStoresConfigSwitchCatIii(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHmcsHmscKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHmcsHmscKnobOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudAltitudeSwitchAuto(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudAltitudeSwitchBaro(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudAltitudeSwitchRadar(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudBrightnessSwitchAutoBrt(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudBrightnessSwitchDay(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudBrightnessSwitchNig(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudDedDataSwitchDed(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudDedDataSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudDedDataSwitchPfl(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudDeprRetSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudDeprRetSwitchPri(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudDeprRetSwitchStby(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudFpmSwitchAttFpm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudFpmSwitchFpm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudFpmSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudScalesSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudScalesSwitchVah(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudScalesSwitchVvVah(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudVelocitySwitchCas(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudVelocitySwitchGndSpd(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getHudVelocitySwitchTas(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getInstrModeKnobIlsNav(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getInstrModeKnobIlsTcn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getInstrModeKnobNav(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getInstrModeKnobTcn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainAltimeterPressureKnobDecr1(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainAltimeterPressureKnobDecr5(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainAltimeterPressureKnobIncr1(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainAltimeterPressureKnobIncr5(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiCrsKnobDecrease1(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiCrsKnobDecrease5(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiCrsKnobIncrease1(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiCrsKnobIncrease5(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiHdgKnobDecrease1(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiHdgKnobDecrease5(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiHdgKnobIncrease1(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMainHsiHdgKnobIncrease5(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscLaserSwitchArm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscLaserSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscMasterArmSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscMasterArmSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscMasterArmSwitchSim(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscPitchSwitchAPOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscPitchSwitchAltHold(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscPitchSwitchAttHold(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscRfSwitchNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscRfSwitchQuiet(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscRfSwitchSilent(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscRollSwitchAttHold(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscRollSwitchHdgSel(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getMiscRollSwitchStrgSel(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyExtFuelTransSwitchNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyExtFuelTransSwitchWingFirst(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyFuelQtySelKnobExtCtr(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyFuelQtySelKnobExtWing(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyFuelQtySelKnobIntWing(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyFuelQtySelKnobNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyFuelQtySelKnobRsvr(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getQtyFuelQtySelKnobTest(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrFcrSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrFcrSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrLeftHdptSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrLeftHdptSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrRdrAltSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrRdrAltSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrRdrAltSwitchStdby(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrRightHdptSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSnsrRightHdptSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getTestProbeHeatSwitchOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getTestProbeHeatSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getTestProbeHeatSwitchTest(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getTrimTrimApDiscSwitchDisc(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getTrimTrimApDiscSwitchNorm(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getUhfFunctionKnobBoth(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getUhfFunctionKnobMain(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getUhfFunctionKnobOff(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getUhfModeKnobGrd(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getUhfModeKnobMnl(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getUhfModeKnobPreset(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getZeroVmsSwitchInhibit(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getZeroVmsSwitchOn(String id, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	}
