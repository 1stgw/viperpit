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
		"AFGearDown",
		"AFGearUp",
		"SimAVTRSwitchAuto",
		"SimAVTRSwitchOff",
		"SimAVTRSwitchOn",
		"SimAirSourceDump",
		"SimAirSourceNorm",
		"SimAirSourceOff",
		"SimAirSourceRam",
		"SimAltFlapsExtend",
		"SimAltFlapsNorm",
		"SimAltPressDec",
		"SimAltPressDecBy1",
		"SimAltPressInc",
		"SimAltPressIncBy1",
		"SimAntennaSelectDown",
		"SimAntennaSelectMid",
		"SimAntennaSelectUp",
		"SimAntiCollOff",
		"SimAntiCollOn",
		"SimAntiIceDown",
		"SimAntiIceMid",
		"SimAntiIceUp",
		"SimArmMasterArm",
		"SimAud1Com1Gd",
		"SimAud1Com1Sql",
		"SimAud1Com2Gd",
		"SimAud1Com2Sql",
		"SimAuxComBackup",
		"SimAuxComUFC",
		"SimBupUhfBoth",
		"SimBupUhfGuard",
		"SimBupUhfMain",
		"SimBupUhfManual",
		"SimBupUhfOff",
		"SimBupUhfPreset",
		"SimCATI",
		"SimCATIII",
		"SimComm1PowerOff",
		"SimComm1PowerOn",
		"SimComm2PowerOff",
		"SimComm2PowerOn",
		"SimDLOff",
		"SimDLOn",
		"SimDigitalBUPBackup",
		"SimDigitalBUPOff",
		"SimEWSChaffOff",
		"SimEWSChaffOn",
		"SimEWSFlareOff",
		"SimEWSFlareOn",
		"SimEWSJammerOff",
		"SimEWSJammerOn",
		"SimEWSModeAuto",
		"SimEWSModeByp",
		"SimEWSModeMan",
		"SimEWSModeOff",
		"SimEWSModeSemi",
		"SimEWSModeStby",
		"SimEWSMwsOff",
		"SimEWSMwsOn",
		"SimEWSO1Off",
		"SimEWSO1On",
		"SimEWSO2Off",
		"SimEWSO2On",
		"SimEWSProgFour",
		"SimEWSProgOne",
		"SimEWSProgThree",
		"SimEWSProgTwo",
		"SimEWSRWROff",
		"SimEWSRWROn",
		"SimEcmPowerOff",
		"SimEcmPowerOn",
		"SimEngContPri",
		"SimEngContSec",
		"SimEpuAuto",
		"SimEpuOff",
		"SimEpuOn",
		"SimEwsJettOff",
		"SimEwsJettOn",
		"SimExtlMasterNorm",
		"SimExtlMasterOff",
		"SimFCCOff",
		"SimFCCOn",
		"SimFCROff",
		"SimFCROn",
		"SimFuelDoorClose",
		"SimFuelDoorOpen",
		"SimFuelPumpAft",
		"SimFuelPumpFwd",
		"SimFuelPumpNorm",
		"SimFuelPumpOff",
		"SimFuelSwitchCenterExt",
		"SimFuelSwitchNorm",
		"SimFuelSwitchResv",
		"SimFuelSwitchTest",
		"SimFuelSwitchWingExt",
		"SimFuelSwitchWingInt",
		"SimFuelTransNorm",
		"SimFuelTransWing",
		"SimFuselageLightDown",
		"SimFuselageLightMid",
		"SimFuselageLightUp",
		"SimGPSOff",
		"SimGPSOn",
		"SimGndJettOff",
		"SimGndJettOn",
		"SimHSIIlsNav",
		"SimHSIIlsTcn",
		"SimHSINav",
		"SimHSITcn",
		"SimHUDAltAuto",
		"SimHUDAltBaro",
		"SimHUDAltRadar",
		"SimHUDBrtAuto",
		"SimHUDBrtDay",
		"SimHUDBrtNight",
		"SimHUDDEDDED",
		"SimHUDDEDOff",
		"SimHUDDEDPFL",
		"SimHUDVelocityCAS",
		"SimHUDVelocityGND",
		"SimHUDVelocityTAS",
		"SimHmsOff",
		"SimHmsOn",
		"SimHookDown",
		"SimHookUp",
		"SimHsiCourseDec",
		"SimHsiCourseInc",
		"SimHsiCrsDecBy1",
		"SimHsiCrsIncBy1",
		"SimHsiHdgDecBy1",
		"SimHsiHdgIncBy1",
		"SimHsiHeadingDec",
		"SimHsiHeadingInc",
		"SimIFFCodeSwitchHold",
		"SimIFFCodeSwitchZero",
		"SimIFFMasterEmerg",
		"SimIFFMasterLow",
		"SimIFFMasterNorm",
		"SimIFFMasterOff",
		"SimIFFMasterStby",
		"SimIFFMode4MonitorAud",
		"SimIFFMode4MonitorOff",
		"SimIFFMode4ReplyAlpha",
		"SimIFFMode4ReplyBravo",
		"SimIFFMode4ReplyOff",
		"SimINSInFlt",
		"SimINSNav",
		"SimINSNorm",
		"SimINSOff",
		"SimJfsStartDown",
		"SimJfsStartMid",
		"SimJfsStartUp",
		"SimLEFAuto",
		"SimLEFLock",
		"SimLandingLightDown",
		"SimLandingLightMid",
		"SimLandingLightUp",
		"SimLaserArmOff",
		"SimLaserArmOn",
		"SimLeftAPDown",
		"SimLeftAPMid",
		"SimLeftAPUp",
		"SimLeftHptOff",
		"SimLeftHptOn",
		"SimLightsFlash",
		"SimLightsSteady",
		"SimMFDOff",
		"SimMFDOn",
		"SimMIDSLVTOff",
		"SimMIDSLVTOn",
		"SimMIDSLVTZero",
		"SimMainPowerBatt",
		"SimMainPowerMain",
		"SimMainPowerOff",
		"SimManualFlyupDisable",
		"SimManualFlyupEnable",
		"SimMasterFuelOff",
		"SimMasterFuelOn",
		"SimParkingBrakeDown",
		"SimParkingBrakeMid",
		"SimParkingBrakeUp",
		"SimPitchLadderATTFPM",
		"SimPitchLadderFPM",
		"SimPitchLadderOff",
		"SimProbeHeatOff",
		"SimProbeHeatOn",
		"SimProbeHeatTest",
		"SimRALTOFF",
		"SimRALTON",
		"SimRALTSTDBY",
		"SimRFNorm",
		"SimRFQuiet",
		"SimRFSilent",
		"SimReticleOff",
		"SimReticlePri",
		"SimReticleStby",
		"SimRightAPDown",
		"SimRightAPMid",
		"SimRightAPUp",
		"SimRightHptOff",
		"SimRightHptOn",
		"SimSMSOff",
		"SimSMSOn",
		"SimSafeMasterArm",
		"SimScalesOff",
		"SimScalesVAH",
		"SimScalesVVVAH",
		"SimSimMasterArm",
		"SimTACANAATR",
		"SimTACANTR",
		"SimTrimAPDISC",
		"SimTrimAPNORM",
		"SimUFCOff",
		"SimUFCOn",
		"SimVMSOff",
		"SimVMSOn",
		"SimWingLightDown",
		"SimWingLightMid",
		"SimWingLightUp",
		"SimXMit1",
		"SimXMit2",
		"SimXMit3"
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

	protected Object getStateFromSharedMemory(String callback, SharedMemoryData sharedMemoryData) {
		switch (callback) {
			case "AFGearDown":
				return getAFGearDown(callback, sharedMemoryData);
			case "AFGearUp":
				return getAFGearUp(callback, sharedMemoryData);
			case "SimAVTRSwitchAuto":
				return getSimAVTRSwitchAuto(callback, sharedMemoryData);
			case "SimAVTRSwitchOff":
				return getSimAVTRSwitchOff(callback, sharedMemoryData);
			case "SimAVTRSwitchOn":
				return getSimAVTRSwitchOn(callback, sharedMemoryData);
			case "SimAirSourceDump":
				return getSimAirSourceDump(callback, sharedMemoryData);
			case "SimAirSourceNorm":
				return getSimAirSourceNorm(callback, sharedMemoryData);
			case "SimAirSourceOff":
				return getSimAirSourceOff(callback, sharedMemoryData);
			case "SimAirSourceRam":
				return getSimAirSourceRam(callback, sharedMemoryData);
			case "SimAltFlapsExtend":
				return getSimAltFlapsExtend(callback, sharedMemoryData);
			case "SimAltFlapsNorm":
				return getSimAltFlapsNorm(callback, sharedMemoryData);
			case "SimAltPressDec":
				return getSimAltPressDec(callback, sharedMemoryData);
			case "SimAltPressDecBy1":
				return getSimAltPressDecBy1(callback, sharedMemoryData);
			case "SimAltPressInc":
				return getSimAltPressInc(callback, sharedMemoryData);
			case "SimAltPressIncBy1":
				return getSimAltPressIncBy1(callback, sharedMemoryData);
			case "SimAntennaSelectDown":
				return getSimAntennaSelectDown(callback, sharedMemoryData);
			case "SimAntennaSelectMid":
				return getSimAntennaSelectMid(callback, sharedMemoryData);
			case "SimAntennaSelectUp":
				return getSimAntennaSelectUp(callback, sharedMemoryData);
			case "SimAntiCollOff":
				return getSimAntiCollOff(callback, sharedMemoryData);
			case "SimAntiCollOn":
				return getSimAntiCollOn(callback, sharedMemoryData);
			case "SimAntiIceDown":
				return getSimAntiIceDown(callback, sharedMemoryData);
			case "SimAntiIceMid":
				return getSimAntiIceMid(callback, sharedMemoryData);
			case "SimAntiIceUp":
				return getSimAntiIceUp(callback, sharedMemoryData);
			case "SimArmMasterArm":
				return getSimArmMasterArm(callback, sharedMemoryData);
			case "SimAud1Com1Gd":
				return getSimAud1Com1Gd(callback, sharedMemoryData);
			case "SimAud1Com1Sql":
				return getSimAud1Com1Sql(callback, sharedMemoryData);
			case "SimAud1Com2Gd":
				return getSimAud1Com2Gd(callback, sharedMemoryData);
			case "SimAud1Com2Sql":
				return getSimAud1Com2Sql(callback, sharedMemoryData);
			case "SimAuxComBackup":
				return getSimAuxComBackup(callback, sharedMemoryData);
			case "SimAuxComUFC":
				return getSimAuxComUFC(callback, sharedMemoryData);
			case "SimBupUhfBoth":
				return getSimBupUhfBoth(callback, sharedMemoryData);
			case "SimBupUhfGuard":
				return getSimBupUhfGuard(callback, sharedMemoryData);
			case "SimBupUhfMain":
				return getSimBupUhfMain(callback, sharedMemoryData);
			case "SimBupUhfManual":
				return getSimBupUhfManual(callback, sharedMemoryData);
			case "SimBupUhfOff":
				return getSimBupUhfOff(callback, sharedMemoryData);
			case "SimBupUhfPreset":
				return getSimBupUhfPreset(callback, sharedMemoryData);
			case "SimCATI":
				return getSimCATI(callback, sharedMemoryData);
			case "SimCATIII":
				return getSimCATIII(callback, sharedMemoryData);
			case "SimComm1PowerOff":
				return getSimComm1PowerOff(callback, sharedMemoryData);
			case "SimComm1PowerOn":
				return getSimComm1PowerOn(callback, sharedMemoryData);
			case "SimComm2PowerOff":
				return getSimComm2PowerOff(callback, sharedMemoryData);
			case "SimComm2PowerOn":
				return getSimComm2PowerOn(callback, sharedMemoryData);
			case "SimDLOff":
				return getSimDLOff(callback, sharedMemoryData);
			case "SimDLOn":
				return getSimDLOn(callback, sharedMemoryData);
			case "SimDigitalBUPBackup":
				return getSimDigitalBUPBackup(callback, sharedMemoryData);
			case "SimDigitalBUPOff":
				return getSimDigitalBUPOff(callback, sharedMemoryData);
			case "SimEWSChaffOff":
				return getSimEWSChaffOff(callback, sharedMemoryData);
			case "SimEWSChaffOn":
				return getSimEWSChaffOn(callback, sharedMemoryData);
			case "SimEWSFlareOff":
				return getSimEWSFlareOff(callback, sharedMemoryData);
			case "SimEWSFlareOn":
				return getSimEWSFlareOn(callback, sharedMemoryData);
			case "SimEWSJammerOff":
				return getSimEWSJammerOff(callback, sharedMemoryData);
			case "SimEWSJammerOn":
				return getSimEWSJammerOn(callback, sharedMemoryData);
			case "SimEWSModeAuto":
				return getSimEWSModeAuto(callback, sharedMemoryData);
			case "SimEWSModeByp":
				return getSimEWSModeByp(callback, sharedMemoryData);
			case "SimEWSModeMan":
				return getSimEWSModeMan(callback, sharedMemoryData);
			case "SimEWSModeOff":
				return getSimEWSModeOff(callback, sharedMemoryData);
			case "SimEWSModeSemi":
				return getSimEWSModeSemi(callback, sharedMemoryData);
			case "SimEWSModeStby":
				return getSimEWSModeStby(callback, sharedMemoryData);
			case "SimEWSMwsOff":
				return getSimEWSMwsOff(callback, sharedMemoryData);
			case "SimEWSMwsOn":
				return getSimEWSMwsOn(callback, sharedMemoryData);
			case "SimEWSO1Off":
				return getSimEWSO1Off(callback, sharedMemoryData);
			case "SimEWSO1On":
				return getSimEWSO1On(callback, sharedMemoryData);
			case "SimEWSO2Off":
				return getSimEWSO2Off(callback, sharedMemoryData);
			case "SimEWSO2On":
				return getSimEWSO2On(callback, sharedMemoryData);
			case "SimEWSProgFour":
				return getSimEWSProgFour(callback, sharedMemoryData);
			case "SimEWSProgOne":
				return getSimEWSProgOne(callback, sharedMemoryData);
			case "SimEWSProgThree":
				return getSimEWSProgThree(callback, sharedMemoryData);
			case "SimEWSProgTwo":
				return getSimEWSProgTwo(callback, sharedMemoryData);
			case "SimEWSRWROff":
				return getSimEWSRWROff(callback, sharedMemoryData);
			case "SimEWSRWROn":
				return getSimEWSRWROn(callback, sharedMemoryData);
			case "SimEcmPowerOff":
				return getSimEcmPowerOff(callback, sharedMemoryData);
			case "SimEcmPowerOn":
				return getSimEcmPowerOn(callback, sharedMemoryData);
			case "SimEngContPri":
				return getSimEngContPri(callback, sharedMemoryData);
			case "SimEngContSec":
				return getSimEngContSec(callback, sharedMemoryData);
			case "SimEpuAuto":
				return getSimEpuAuto(callback, sharedMemoryData);
			case "SimEpuOff":
				return getSimEpuOff(callback, sharedMemoryData);
			case "SimEpuOn":
				return getSimEpuOn(callback, sharedMemoryData);
			case "SimEwsJettOff":
				return getSimEwsJettOff(callback, sharedMemoryData);
			case "SimEwsJettOn":
				return getSimEwsJettOn(callback, sharedMemoryData);
			case "SimExtlMasterNorm":
				return getSimExtlMasterNorm(callback, sharedMemoryData);
			case "SimExtlMasterOff":
				return getSimExtlMasterOff(callback, sharedMemoryData);
			case "SimFCCOff":
				return getSimFCCOff(callback, sharedMemoryData);
			case "SimFCCOn":
				return getSimFCCOn(callback, sharedMemoryData);
			case "SimFCROff":
				return getSimFCROff(callback, sharedMemoryData);
			case "SimFCROn":
				return getSimFCROn(callback, sharedMemoryData);
			case "SimFuelDoorClose":
				return getSimFuelDoorClose(callback, sharedMemoryData);
			case "SimFuelDoorOpen":
				return getSimFuelDoorOpen(callback, sharedMemoryData);
			case "SimFuelPumpAft":
				return getSimFuelPumpAft(callback, sharedMemoryData);
			case "SimFuelPumpFwd":
				return getSimFuelPumpFwd(callback, sharedMemoryData);
			case "SimFuelPumpNorm":
				return getSimFuelPumpNorm(callback, sharedMemoryData);
			case "SimFuelPumpOff":
				return getSimFuelPumpOff(callback, sharedMemoryData);
			case "SimFuelSwitchCenterExt":
				return getSimFuelSwitchCenterExt(callback, sharedMemoryData);
			case "SimFuelSwitchNorm":
				return getSimFuelSwitchNorm(callback, sharedMemoryData);
			case "SimFuelSwitchResv":
				return getSimFuelSwitchResv(callback, sharedMemoryData);
			case "SimFuelSwitchTest":
				return getSimFuelSwitchTest(callback, sharedMemoryData);
			case "SimFuelSwitchWingExt":
				return getSimFuelSwitchWingExt(callback, sharedMemoryData);
			case "SimFuelSwitchWingInt":
				return getSimFuelSwitchWingInt(callback, sharedMemoryData);
			case "SimFuelTransNorm":
				return getSimFuelTransNorm(callback, sharedMemoryData);
			case "SimFuelTransWing":
				return getSimFuelTransWing(callback, sharedMemoryData);
			case "SimFuselageLightDown":
				return getSimFuselageLightDown(callback, sharedMemoryData);
			case "SimFuselageLightMid":
				return getSimFuselageLightMid(callback, sharedMemoryData);
			case "SimFuselageLightUp":
				return getSimFuselageLightUp(callback, sharedMemoryData);
			case "SimGPSOff":
				return getSimGPSOff(callback, sharedMemoryData);
			case "SimGPSOn":
				return getSimGPSOn(callback, sharedMemoryData);
			case "SimGndJettOff":
				return getSimGndJettOff(callback, sharedMemoryData);
			case "SimGndJettOn":
				return getSimGndJettOn(callback, sharedMemoryData);
			case "SimHSIIlsNav":
				return getSimHSIIlsNav(callback, sharedMemoryData);
			case "SimHSIIlsTcn":
				return getSimHSIIlsTcn(callback, sharedMemoryData);
			case "SimHSINav":
				return getSimHSINav(callback, sharedMemoryData);
			case "SimHSITcn":
				return getSimHSITcn(callback, sharedMemoryData);
			case "SimHUDAltAuto":
				return getSimHUDAltAuto(callback, sharedMemoryData);
			case "SimHUDAltBaro":
				return getSimHUDAltBaro(callback, sharedMemoryData);
			case "SimHUDAltRadar":
				return getSimHUDAltRadar(callback, sharedMemoryData);
			case "SimHUDBrtAuto":
				return getSimHUDBrtAuto(callback, sharedMemoryData);
			case "SimHUDBrtDay":
				return getSimHUDBrtDay(callback, sharedMemoryData);
			case "SimHUDBrtNight":
				return getSimHUDBrtNight(callback, sharedMemoryData);
			case "SimHUDDEDDED":
				return getSimHUDDEDDED(callback, sharedMemoryData);
			case "SimHUDDEDOff":
				return getSimHUDDEDOff(callback, sharedMemoryData);
			case "SimHUDDEDPFL":
				return getSimHUDDEDPFL(callback, sharedMemoryData);
			case "SimHUDVelocityCAS":
				return getSimHUDVelocityCAS(callback, sharedMemoryData);
			case "SimHUDVelocityGND":
				return getSimHUDVelocityGND(callback, sharedMemoryData);
			case "SimHUDVelocityTAS":
				return getSimHUDVelocityTAS(callback, sharedMemoryData);
			case "SimHmsOff":
				return getSimHmsOff(callback, sharedMemoryData);
			case "SimHmsOn":
				return getSimHmsOn(callback, sharedMemoryData);
			case "SimHookDown":
				return getSimHookDown(callback, sharedMemoryData);
			case "SimHookUp":
				return getSimHookUp(callback, sharedMemoryData);
			case "SimHsiCourseDec":
				return getSimHsiCourseDec(callback, sharedMemoryData);
			case "SimHsiCourseInc":
				return getSimHsiCourseInc(callback, sharedMemoryData);
			case "SimHsiCrsDecBy1":
				return getSimHsiCrsDecBy1(callback, sharedMemoryData);
			case "SimHsiCrsIncBy1":
				return getSimHsiCrsIncBy1(callback, sharedMemoryData);
			case "SimHsiHdgDecBy1":
				return getSimHsiHdgDecBy1(callback, sharedMemoryData);
			case "SimHsiHdgIncBy1":
				return getSimHsiHdgIncBy1(callback, sharedMemoryData);
			case "SimHsiHeadingDec":
				return getSimHsiHeadingDec(callback, sharedMemoryData);
			case "SimHsiHeadingInc":
				return getSimHsiHeadingInc(callback, sharedMemoryData);
			case "SimIFFCodeSwitchHold":
				return getSimIFFCodeSwitchHold(callback, sharedMemoryData);
			case "SimIFFCodeSwitchZero":
				return getSimIFFCodeSwitchZero(callback, sharedMemoryData);
			case "SimIFFMasterEmerg":
				return getSimIFFMasterEmerg(callback, sharedMemoryData);
			case "SimIFFMasterLow":
				return getSimIFFMasterLow(callback, sharedMemoryData);
			case "SimIFFMasterNorm":
				return getSimIFFMasterNorm(callback, sharedMemoryData);
			case "SimIFFMasterOff":
				return getSimIFFMasterOff(callback, sharedMemoryData);
			case "SimIFFMasterStby":
				return getSimIFFMasterStby(callback, sharedMemoryData);
			case "SimIFFMode4MonitorAud":
				return getSimIFFMode4MonitorAud(callback, sharedMemoryData);
			case "SimIFFMode4MonitorOff":
				return getSimIFFMode4MonitorOff(callback, sharedMemoryData);
			case "SimIFFMode4ReplyAlpha":
				return getSimIFFMode4ReplyAlpha(callback, sharedMemoryData);
			case "SimIFFMode4ReplyBravo":
				return getSimIFFMode4ReplyBravo(callback, sharedMemoryData);
			case "SimIFFMode4ReplyOff":
				return getSimIFFMode4ReplyOff(callback, sharedMemoryData);
			case "SimINSInFlt":
				return getSimINSInFlt(callback, sharedMemoryData);
			case "SimINSNav":
				return getSimINSNav(callback, sharedMemoryData);
			case "SimINSNorm":
				return getSimINSNorm(callback, sharedMemoryData);
			case "SimINSOff":
				return getSimINSOff(callback, sharedMemoryData);
			case "SimJfsStartDown":
				return getSimJfsStartDown(callback, sharedMemoryData);
			case "SimJfsStartMid":
				return getSimJfsStartMid(callback, sharedMemoryData);
			case "SimJfsStartUp":
				return getSimJfsStartUp(callback, sharedMemoryData);
			case "SimLEFAuto":
				return getSimLEFAuto(callback, sharedMemoryData);
			case "SimLEFLock":
				return getSimLEFLock(callback, sharedMemoryData);
			case "SimLandingLightDown":
				return getSimLandingLightDown(callback, sharedMemoryData);
			case "SimLandingLightMid":
				return getSimLandingLightMid(callback, sharedMemoryData);
			case "SimLandingLightUp":
				return getSimLandingLightUp(callback, sharedMemoryData);
			case "SimLaserArmOff":
				return getSimLaserArmOff(callback, sharedMemoryData);
			case "SimLaserArmOn":
				return getSimLaserArmOn(callback, sharedMemoryData);
			case "SimLeftAPDown":
				return getSimLeftAPDown(callback, sharedMemoryData);
			case "SimLeftAPMid":
				return getSimLeftAPMid(callback, sharedMemoryData);
			case "SimLeftAPUp":
				return getSimLeftAPUp(callback, sharedMemoryData);
			case "SimLeftHptOff":
				return getSimLeftHptOff(callback, sharedMemoryData);
			case "SimLeftHptOn":
				return getSimLeftHptOn(callback, sharedMemoryData);
			case "SimLightsFlash":
				return getSimLightsFlash(callback, sharedMemoryData);
			case "SimLightsSteady":
				return getSimLightsSteady(callback, sharedMemoryData);
			case "SimMFDOff":
				return getSimMFDOff(callback, sharedMemoryData);
			case "SimMFDOn":
				return getSimMFDOn(callback, sharedMemoryData);
			case "SimMIDSLVTOff":
				return getSimMIDSLVTOff(callback, sharedMemoryData);
			case "SimMIDSLVTOn":
				return getSimMIDSLVTOn(callback, sharedMemoryData);
			case "SimMIDSLVTZero":
				return getSimMIDSLVTZero(callback, sharedMemoryData);
			case "SimMainPowerBatt":
				return getSimMainPowerBatt(callback, sharedMemoryData);
			case "SimMainPowerMain":
				return getSimMainPowerMain(callback, sharedMemoryData);
			case "SimMainPowerOff":
				return getSimMainPowerOff(callback, sharedMemoryData);
			case "SimManualFlyupDisable":
				return getSimManualFlyupDisable(callback, sharedMemoryData);
			case "SimManualFlyupEnable":
				return getSimManualFlyupEnable(callback, sharedMemoryData);
			case "SimMasterFuelOff":
				return getSimMasterFuelOff(callback, sharedMemoryData);
			case "SimMasterFuelOn":
				return getSimMasterFuelOn(callback, sharedMemoryData);
			case "SimParkingBrakeDown":
				return getSimParkingBrakeDown(callback, sharedMemoryData);
			case "SimParkingBrakeMid":
				return getSimParkingBrakeMid(callback, sharedMemoryData);
			case "SimParkingBrakeUp":
				return getSimParkingBrakeUp(callback, sharedMemoryData);
			case "SimPitchLadderATTFPM":
				return getSimPitchLadderATTFPM(callback, sharedMemoryData);
			case "SimPitchLadderFPM":
				return getSimPitchLadderFPM(callback, sharedMemoryData);
			case "SimPitchLadderOff":
				return getSimPitchLadderOff(callback, sharedMemoryData);
			case "SimProbeHeatOff":
				return getSimProbeHeatOff(callback, sharedMemoryData);
			case "SimProbeHeatOn":
				return getSimProbeHeatOn(callback, sharedMemoryData);
			case "SimProbeHeatTest":
				return getSimProbeHeatTest(callback, sharedMemoryData);
			case "SimRALTOFF":
				return getSimRALTOFF(callback, sharedMemoryData);
			case "SimRALTON":
				return getSimRALTON(callback, sharedMemoryData);
			case "SimRALTSTDBY":
				return getSimRALTSTDBY(callback, sharedMemoryData);
			case "SimRFNorm":
				return getSimRFNorm(callback, sharedMemoryData);
			case "SimRFQuiet":
				return getSimRFQuiet(callback, sharedMemoryData);
			case "SimRFSilent":
				return getSimRFSilent(callback, sharedMemoryData);
			case "SimReticleOff":
				return getSimReticleOff(callback, sharedMemoryData);
			case "SimReticlePri":
				return getSimReticlePri(callback, sharedMemoryData);
			case "SimReticleStby":
				return getSimReticleStby(callback, sharedMemoryData);
			case "SimRightAPDown":
				return getSimRightAPDown(callback, sharedMemoryData);
			case "SimRightAPMid":
				return getSimRightAPMid(callback, sharedMemoryData);
			case "SimRightAPUp":
				return getSimRightAPUp(callback, sharedMemoryData);
			case "SimRightHptOff":
				return getSimRightHptOff(callback, sharedMemoryData);
			case "SimRightHptOn":
				return getSimRightHptOn(callback, sharedMemoryData);
			case "SimSMSOff":
				return getSimSMSOff(callback, sharedMemoryData);
			case "SimSMSOn":
				return getSimSMSOn(callback, sharedMemoryData);
			case "SimSafeMasterArm":
				return getSimSafeMasterArm(callback, sharedMemoryData);
			case "SimScalesOff":
				return getSimScalesOff(callback, sharedMemoryData);
			case "SimScalesVAH":
				return getSimScalesVAH(callback, sharedMemoryData);
			case "SimScalesVVVAH":
				return getSimScalesVVVAH(callback, sharedMemoryData);
			case "SimSimMasterArm":
				return getSimSimMasterArm(callback, sharedMemoryData);
			case "SimTACANAATR":
				return getSimTACANAATR(callback, sharedMemoryData);
			case "SimTACANTR":
				return getSimTACANTR(callback, sharedMemoryData);
			case "SimTrimAPDISC":
				return getSimTrimAPDISC(callback, sharedMemoryData);
			case "SimTrimAPNORM":
				return getSimTrimAPNORM(callback, sharedMemoryData);
			case "SimUFCOff":
				return getSimUFCOff(callback, sharedMemoryData);
			case "SimUFCOn":
				return getSimUFCOn(callback, sharedMemoryData);
			case "SimVMSOff":
				return getSimVMSOff(callback, sharedMemoryData);
			case "SimVMSOn":
				return getSimVMSOn(callback, sharedMemoryData);
			case "SimWingLightDown":
				return getSimWingLightDown(callback, sharedMemoryData);
			case "SimWingLightMid":
				return getSimWingLightMid(callback, sharedMemoryData);
			case "SimWingLightUp":
				return getSimWingLightUp(callback, sharedMemoryData);
			case "SimXMit1":
				return getSimXMit1(callback, sharedMemoryData);
			case "SimXMit2":
				return getSimXMit2(callback, sharedMemoryData);
			case "SimXMit3":
				return getSimXMit3(callback, sharedMemoryData);
			default:
				return null;
		}
	}

	protected Object getAFGearDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getAFGearUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAVTRSwitchAuto(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAVTRSwitchOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAVTRSwitchOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAirSourceDump(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAirSourceNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAirSourceOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAirSourceRam(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAltFlapsExtend(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAltFlapsNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAltPressDec(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAltPressDecBy1(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAltPressInc(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAltPressIncBy1(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntennaSelectDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntennaSelectMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntennaSelectUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntiCollOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntiCollOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntiIceDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntiIceMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAntiIceUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimArmMasterArm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAud1Com1Gd(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAud1Com1Sql(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAud1Com2Gd(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAud1Com2Sql(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAuxComBackup(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimAuxComUFC(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimBupUhfBoth(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimBupUhfGuard(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimBupUhfMain(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimBupUhfManual(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimBupUhfOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimBupUhfPreset(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimCATI(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimCATIII(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimComm1PowerOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimComm1PowerOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimComm2PowerOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimComm2PowerOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimDLOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimDLOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimDigitalBUPBackup(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimDigitalBUPOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSChaffOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSChaffOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSFlareOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSFlareOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSJammerOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSJammerOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSModeAuto(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSModeByp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSModeMan(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSModeOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSModeSemi(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSModeStby(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSMwsOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSMwsOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSO1Off(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSO1On(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSO2Off(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSO2On(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSProgFour(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSProgOne(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSProgThree(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSProgTwo(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSRWROff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEWSRWROn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEcmPowerOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEcmPowerOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEngContPri(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEngContSec(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEpuAuto(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEpuOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEpuOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEwsJettOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimEwsJettOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimExtlMasterNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimExtlMasterOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFCCOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFCCOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFCROff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFCROn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelDoorClose(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelDoorOpen(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelPumpAft(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelPumpFwd(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelPumpNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelPumpOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelSwitchCenterExt(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelSwitchNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelSwitchResv(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelSwitchTest(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelSwitchWingExt(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelSwitchWingInt(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelTransNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuelTransWing(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuselageLightDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuselageLightMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimFuselageLightUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimGPSOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimGPSOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimGndJettOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimGndJettOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHSIIlsNav(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHSIIlsTcn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHSINav(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHSITcn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDAltAuto(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDAltBaro(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDAltRadar(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDBrtAuto(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDBrtDay(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDBrtNight(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDDEDDED(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDDEDOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDDEDPFL(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDVelocityCAS(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDVelocityGND(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHUDVelocityTAS(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHmsOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHmsOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHookDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHookUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiCourseDec(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiCourseInc(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiCrsDecBy1(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiCrsIncBy1(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiHdgDecBy1(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiHdgIncBy1(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiHeadingDec(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimHsiHeadingInc(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFCodeSwitchHold(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFCodeSwitchZero(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMasterEmerg(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMasterLow(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMasterNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMasterOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMasterStby(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMode4MonitorAud(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMode4MonitorOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMode4ReplyAlpha(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMode4ReplyBravo(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimIFFMode4ReplyOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimINSInFlt(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimINSNav(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimINSNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimINSOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimJfsStartDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimJfsStartMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimJfsStartUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLEFAuto(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLEFLock(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLandingLightDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLandingLightMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLandingLightUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLaserArmOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLaserArmOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLeftAPDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLeftAPMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLeftAPUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLeftHptOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLeftHptOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLightsFlash(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimLightsSteady(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMFDOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMFDOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMIDSLVTOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMIDSLVTOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMIDSLVTZero(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMainPowerBatt(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMainPowerMain(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMainPowerOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimManualFlyupDisable(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimManualFlyupEnable(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMasterFuelOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimMasterFuelOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimParkingBrakeDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimParkingBrakeMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimParkingBrakeUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimPitchLadderATTFPM(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimPitchLadderFPM(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimPitchLadderOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimProbeHeatOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimProbeHeatOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimProbeHeatTest(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRALTOFF(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRALTON(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRALTSTDBY(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRFNorm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRFQuiet(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRFSilent(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimReticleOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimReticlePri(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimReticleStby(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRightAPDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRightAPMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRightAPUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRightHptOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimRightHptOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimSMSOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimSMSOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimSafeMasterArm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimScalesOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimScalesVAH(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimScalesVVVAH(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimSimMasterArm(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimTACANAATR(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimTACANTR(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimTrimAPDISC(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimTrimAPNORM(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimUFCOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimUFCOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimVMSOff(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimVMSOn(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimWingLightDown(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimWingLightMid(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimWingLightUp(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimXMit1(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimXMit2(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	protected Object getSimXMit3(String callback, SharedMemoryData sharedMemoryData) {
		return null;
	}
	
	}
