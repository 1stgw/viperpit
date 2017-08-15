/*
 * BMS433.hpp
 *
 *  Created on: Nov 22, 2015
 *      Author: Harold
 */

#ifndef BMS433_HPP_
#define BMS433_HPP_

#include <inttypes.h>
#include "jni_md.h"
#include "jni.h"
#include <iostream>
#include <FlightData.h>
#include <windows.h>

extern "C"{

	HANDLE flightDataMemHandle = NULL, flightData2MemHandle = NULL, OSBDataMemHandle = NULL, textureDataMemHandle = NULL;
	FlightData* flightData 		= NULL;
	FlightData2* flightData2 	= NULL;
	OSBData* osbData			= NULL;
	long* textureData			= NULL;

	jboolean Java_org_bmsforum_jni_FlightData_init(JNIEnv *env, jobject obj);
	jboolean Java_org_bmsforum_jni_FlightData_dispose(JNIEnv *env, jobject obj);

//FlightData methods
	jboolean Java_org_bmsforum_jni_FlightData_isSet1(JNIEnv *env, jobject obj, jint mask);
	jboolean Java_org_bmsforum_jni_FlightData_isSet2(JNIEnv *env, jobject obj, jint mask);
	jboolean Java_org_bmsforum_jni_FlightData_isSet3(JNIEnv *env, jobject obj, jint mask);
	jboolean Java_org_bmsforum_jni_FlightData_isSetHSI(JNIEnv *env, jobject obj, jint mask);
	jfloat Java_org_bmsforum_jni_FlightData_getx(JNIEnv *env, jobject obj);            // Ownship North (Ft)
	jfloat Java_org_bmsforum_jni_FlightData_gety(JNIEnv *env, jobject obj);            // Ownship East (Ft)
	jfloat Java_org_bmsforum_jni_FlightData_getz(JNIEnv *env, jobject obj);            // Ownship Down (Ft) --- NOTE: use FlightData2 AAUZ for barometric altitude!
	jfloat Java_org_bmsforum_jni_FlightData_getxDot(JNIEnv *env, jobject obj);         // Ownship North Rate (ft/sec)
	jfloat Java_org_bmsforum_jni_FlightData_getyDot(JNIEnv *env, jobject obj);         // Ownship East Rate (ft/sec)
	jfloat Java_org_bmsforum_jni_FlightData_getzDot(JNIEnv *env, jobject obj);         // Ownship Down Rate (ft/sec)
	jfloat Java_org_bmsforum_jni_FlightData_getalpha(JNIEnv *env, jobject obj);        // Ownship AOA (Degrees)
	jfloat Java_org_bmsforum_jni_FlightData_getbeta(JNIEnv *env, jobject obj);         // Ownship Beta (Degrees)
	jfloat Java_org_bmsforum_jni_FlightData_getgamma(JNIEnv *env, jobject obj);        // Ownship Gamma (Radians)
	jfloat Java_org_bmsforum_jni_FlightData_getpitch(JNIEnv *env, jobject obj);        // Ownship Pitch (Radians)
	jfloat Java_org_bmsforum_jni_FlightData_getroll(JNIEnv *env, jobject obj);         // Ownship Pitch (Radians)
	jfloat Java_org_bmsforum_jni_FlightData_getyaw(JNIEnv *env, jobject obj);          // Ownship Pitch (Radians)
	jfloat Java_org_bmsforum_jni_FlightData_getmach(JNIEnv *env, jobject obj);         // Ownship Mach number
	jfloat Java_org_bmsforum_jni_FlightData_getkias(JNIEnv *env, jobject obj);         // Ownship Indicated Airspeed (Knots)
	jfloat Java_org_bmsforum_jni_FlightData_getvt(JNIEnv *env, jobject obj);           // Ownship True Airspeed (Ft/Sec)
	jfloat Java_org_bmsforum_jni_FlightData_getgs(JNIEnv *env, jobject obj);           // Ownship Normal Gs
	jfloat Java_org_bmsforum_jni_FlightData_getwindOffset(JNIEnv *env, jobject obj);   // Wind delta to FPM (Radians)
	jfloat Java_org_bmsforum_jni_FlightData_getnozzlePos(JNIEnv *env, jobject obj);    // Ownship engine nozzle percent open (0-100)
	//float nozzlePos2;   // MOVED TO FlightData2! Ownship engine nozzle2 percent open (0-100)
	jfloat Java_org_bmsforum_jni_FlightData_getinternalFuel(JNIEnv *env, jobject obj); // Ownship internal fuel (Lbs)
	jfloat Java_org_bmsforum_jni_FlightData_getexternalFuel(JNIEnv *env, jobject obj); // Ownship external fuel (Lbs)
	jfloat Java_org_bmsforum_jni_FlightData_getfuelFlow(JNIEnv *env, jobject obj);     // Ownship fuel flow (Lbs/Hour)
	jfloat Java_org_bmsforum_jni_FlightData_getrpm(JNIEnv *env, jobject obj);          // Ownship engine rpm (Percent 0-103)
	//float rpm2();         // MOVED TO FlightData2! Ownship engine rpm2 (Percent 0-103)
	jfloat Java_org_bmsforum_jni_FlightData_getftit(JNIEnv *env, jobject obj);         // Ownship Forward Turbine Inlet Temp (Degrees C)
	//float ftit2();        // MOVED TO FlightData2! Ownship Forward Turbine Inlet Temp2 (Degrees C)
	jfloat Java_org_bmsforum_jni_FlightData_getgearPos(JNIEnv *env, jobject obj);      // Ownship Gear position 0 = up, 1 = down;
	jfloat Java_org_bmsforum_jni_FlightData_getspeedBrake(JNIEnv *env, jobject obj);   // Ownship speed brake position 0 = closed, 1 = 60 Degrees open
	jfloat Java_org_bmsforum_jni_FlightData_getepuFuel(JNIEnv *env, jobject obj);      // Ownship EPU fuel (Percent 0-100)
	jfloat Java_org_bmsforum_jni_FlightData_getoilPressure(JNIEnv *env, jobject obj);  // Ownship Oil Pressure (Percent 0-100)
	//float oilPressure2(); // MOVED TO FlightData2! Ownship Oil Pressure2 (Percent 0-100)
	jint   Java_org_bmsforum_jni_FlightData_lightBits(JNIEnv *env, jobject obj);    // Cockpit Indicator Lights, one bit per bulb. See enum

	// These are inputs. Use them carefully
	// NB: these do not work when TrackIR device is enabled
	// NB2: launch falcon with the '-head' command line parameter to activate !
	jfloat Java_org_bmsforum_jni_FlightData_setheadPitch(JNIEnv *env, jobject obj, jfloat v);    // Head pitch offset from design eye (radians)
	jfloat Java_org_bmsforum_jni_FlightData_setheadRoll(JNIEnv *env, jobject obj, jfloat v);     // Head roll offset from design eye (radians)
	jfloat Java_org_bmsforum_jni_FlightData_setheadYaw(JNIEnv *env, jobject obj, jfloat v);      // Head yaw offset from design eye (radians)

	// new lights
	jint   Java_org_bmsforum_jni_FlightData_getlightBits2(JNIEnv *env, jobject obj);   // Cockpit Indicator Lights, one bit per bulb. See enum
	jint   Java_org_bmsforum_jni_FlightData_getlightBits3(JNIEnv *env, jobject obj);   // Cockpit Indicator Lights, one bit per bulb. See enum

	// chaff/flare
	jfloat Java_org_bmsforum_jni_FlightData_getChaffCount(JNIEnv *env, jobject obj);   // Number of Chaff left
	jfloat Java_org_bmsforum_jni_FlightData_getFlareCount(JNIEnv *env, jobject obj);   // Number of Flare left

	// landing gear
	jfloat Java_org_bmsforum_jni_FlightData_getNoseGearPos(JNIEnv *env, jobject obj);  // Position of the nose landinggear; caution: full down values defined in dat files
	jfloat Java_org_bmsforum_jni_FlightData_getLeftGearPos(JNIEnv *env, jobject obj);  // Position of the left landinggear; caution: full down values defined in dat files
	jfloat Java_org_bmsforum_jni_FlightData_getRightGearPos(JNIEnv *env, jobject obj); // Position of the right landinggear; caution: full down values defined in dat files

	// ADI values
	jfloat Java_org_bmsforum_jni_FlightData_getAdiIlsHorPos(JNIEnv *env, jobject obj); // Position of horizontal ILS bar
	jfloat Java_org_bmsforum_jni_FlightData_getAdiIlsVerPos(JNIEnv *env, jobject obj); // Position of vertical ILS bar

	// HSI states
	jint Java_org_bmsforum_jni_FlightData_getcourseState(JNIEnv *env, jobject obj);    // HSI_STA_CRS_STATE
	jint Java_org_bmsforum_jni_FlightData_getheadingState(JNIEnv *env, jobject obj);   // HSI_STA_HDG_STATE
	jint Java_org_bmsforum_jni_FlightData_gettotalStates(JNIEnv *env, jobject obj);    // HSI_STA_TOTAL_STATES; never set

	// HSI values
	jfloat Java_org_bmsforum_jni_FlightData_getcourseDeviation(JNIEnv *env, jobject obj);     // HSI_VAL_CRS_DEVIATION
	jfloat Java_org_bmsforum_jni_FlightData_getdesiredCourse(JNIEnv *env, jobject obj);       // HSI_VAL_DESIRED_CRS
	jfloat Java_org_bmsforum_jni_FlightData_getdistanceToBeacon(JNIEnv *env, jobject obj);    // HSI_VAL_DISTANCE_TO_BEACON
	jfloat Java_org_bmsforum_jni_FlightData_getbearingToBeacon(JNIEnv *env, jobject obj);     // HSI_VAL_BEARING_TO_BEACON
	jfloat Java_org_bmsforum_jni_FlightData_getcurrentHeading(JNIEnv *env, jobject obj);      // HSI_VAL_CURRENT_HEADING
	jfloat Java_org_bmsforum_jni_FlightData_getdesiredHeading(JNIEnv *env, jobject obj);      // HSI_VAL_DESIRED_HEADING
	jfloat Java_org_bmsforum_jni_FlightData_getdeviationLimit(JNIEnv *env, jobject obj);      // HSI_VAL_DEV_LIMIT
	jfloat Java_org_bmsforum_jni_FlightData_gethalfDeviationLimit(JNIEnv *env, jobject obj);  // HSI_VAL_HALF_DEV_LIMIT
	jfloat Java_org_bmsforum_jni_FlightData_getlocalizerCourse(JNIEnv *env, jobject obj);     // HSI_VAL_LOCALIZER_CRS
	jfloat Java_org_bmsforum_jni_FlightData_getairbaseX(JNIEnv *env, jobject obj);            // HSI_VAL_AIRBASE_X
	jfloat Java_org_bmsforum_jni_FlightData_getairbaseY(JNIEnv *env, jobject obj);            // HSI_VAL_AIRBASE_Y
	jfloat Java_org_bmsforum_jni_FlightData_gettotalValues(JNIEnv *env, jobject obj);         // HSI_VAL_TOTAL_VALUES; never set

	jfloat Java_org_bmsforum_jni_FlightData_getTrimPitch(JNIEnv *env, jobject obj);  // Value of trim in pitch axis, -0.5 to +0.5
	jfloat Java_org_bmsforum_jni_FlightData_getTrimRoll(JNIEnv *env, jobject obj);   // Value of trim in roll axis, -0.5 to +0.5
	jfloat Java_org_bmsforum_jni_FlightData_getTrimYaw(JNIEnv *env, jobject obj);    // Value of trim in yaw axis, -0.5 to +0.5

	// HSI flags
	jint Java_org_bmsforum_jni_FlightData_gethsiBits(JNIEnv *env, jobject obj);      // HSI flags

	//DED Lines
	jobjectArray Java_org_bmsforum_jni_FlightData_getDEDLines(JNIEnv *env, jobject obj);	//25 usable chars
	jobjectArray Java_org_bmsforum_jni_FlightData_getInvert(JNIEnv *env, jobject obj);	//25 usable chars

	//PFL Lines
	jobjectArray Java_org_bmsforum_jni_FlightData_getPFLLines(JNIEnv *env, jobject obj);  //25 usable chars
	jobjectArray Java_org_bmsforum_jni_FlightData_getPFLInvert(JNIEnv *env, jobject obj); //25 usable chars

	//TacanChannel
	jint Java_org_bmsforum_jni_FlightData_getUFCTChan(JNIEnv *env, jobject obj);
	jint Java_org_bmsforum_jni_FlightData_getAUXTChan(JNIEnv *env, jobject obj);

	// RWR
	jint Java_org_bmsforum_jni_FlightData_getRwrObjectCount(JNIEnv *env, jobject obj);
	jintArray Java_org_bmsforum_jni_FlightData_getRWRsymbol(JNIEnv *env, jobject obj);
	jfloatArray Java_org_bmsforum_jni_FlightData_getbearing(JNIEnv *env, jobject obj);
	jlongArray Java_org_bmsforum_jni_FlightData_getmissileActivity(JNIEnv *env, jobject obj);
	jlongArray Java_org_bmsforum_jni_FlightData_getmissileLaunch(JNIEnv *env, jobject obj);
	jlongArray Java_org_bmsforum_jni_FlightData_getselected(JNIEnv *env, jobject obj);
	jfloatArray Java_org_bmsforum_jni_FlightData_getlethality(JNIEnv *env, jobject obj);
	jlongArray Java_org_bmsforum_jni_FlightData_getnewDetection(JNIEnv *env, jobject obj);

	//fuel values
	jfloat Java_org_bmsforum_jni_FlightData_getfwd(JNIEnv *env, jobject obj);
	jfloat Java_org_bmsforum_jni_FlightData_getaft(JNIEnv *env, jobject obj);
	jfloat Java_org_bmsforum_jni_FlightData_gettotal(JNIEnv *env, jobject obj);

	jint Java_org_bmsforum_jni_FlightData_getVersionNum(JNIEnv *env, jobject obj);    // Version of FlightData mem area

	// New values added here for header file compatibility but not implemented
	// in this version of the code at present.
	jfloat Java_org_bmsforum_jni_FlightData_setheadX(JNIEnv *env, jobject obj, jfloat v);       // Head X offset from design eye (feet)
	jfloat Java_org_bmsforum_jni_FlightData_setheadY(JNIEnv *env, jobject obj, jfloat v);       // Head Y offset from design eye (feet)
	jfloat Java_org_bmsforum_jni_FlightData_setheadZ(JNIEnv *env, jobject obj, jfloat v);       // Head Z offset from design eye (feet)

	jint Java_org_bmsforum_jni_FlightData_getMainPower(JNIEnv *env, jobject obj);     // Main Power switch state, 0=down, 1=middle, 2=up
/**FlightData1 Methods END*/

/**FlightData2 Methods START*/
	// TACAN
	jboolean Java_org_bmsforum_jni_FlightData_ufcTacanIsAA(JNIEnv *env, jobject obj);
	jboolean Java_org_bmsforum_jni_FlightData_auxTacanIsAA(JNIEnv *env, jobject obj);
	jboolean Java_org_bmsforum_jni_FlightData_ufcTacanIsX(JNIEnv *env, jobject obj);
	jboolean Java_org_bmsforum_jni_FlightData_auxTacanIsX(JNIEnv *env, jobject obj);

	// ALTIMETER
	jboolean Java_org_bmsforum_jni_FlightData_isSetAlt(JNIEnv *env, jobject obj, jint mask);

	// POWER
	jboolean Java_org_bmsforum_jni_FlightData_isSetPower(JNIEnv *env, jobject obj, jint mask);

	// BLINKING LIGHTS
	jboolean Java_org_bmsforum_jni_FlightData_isSetBlink(JNIEnv *env, jobject obj, jint mask);

	// VERSION 1
	jfloat Java_org_bmsforum_jni_FlightData_getnozzlePos2(JNIEnv *env, jobject obj); // Ownship engine nozzle2 percent open (0-100)
	jfloat Java_org_bmsforum_jni_FlightData_getrpm2(JNIEnv *env, jobject obj); // Ownship engine rpm2 (Percent 0-103)
	jfloat Java_org_bmsforum_jni_FlightData_getftit2(JNIEnv *env, jobject obj); // Ownship Forward Turbine Inlet Temp2 (Degrees C)
	jfloat Java_org_bmsforum_jni_FlightData_getoilPressure2(JNIEnv *env, jobject obj); // Ownship Oil Pressure2 (Percent 0-100)
	jbyte Java_org_bmsforum_jni_FlightData_getnavMode(JNIEnv *env, jobject obj); // current mode selected for HSI/eHSI, see NavModes enum for details
	jfloat Java_org_bmsforum_jni_FlightData_getAAUZ(JNIEnv *env, jobject obj); // Ownship barometric altitude given by AAU (depends on calibration)
	jbyteArray Java_org_bmsforum_jni_FlightData_gettacanInfo(JNIEnv *env, jobject obj); // Tacan band/mode settings for UFC and AUX COMM

	// VERSION 2 / 7
	jint Java_org_bmsforum_jni_FlightData_getAltCalReading(JNIEnv *env, jobject obj);// barometric altitude calibration (depends on CalType)
	jint Java_org_bmsforum_jni_FlightData_getaltBits(JNIEnv *env, jobject obj);	// various altimeter bits, see AltBits enum for details
	jint Java_org_bmsforum_jni_FlightData_getpowerBits(JNIEnv *env, jobject obj);// Ownship power bus / generator states, see PowerBits enum for details
	jint Java_org_bmsforum_jni_FlightData_getblinkBits(JNIEnv *env, jobject obj);// Cockpit indicator lights blink status, see BlinkBits enum for details
	// NOTE: these bits indicate only *if* a lamp is blinking, in addition to the
	// existing on/off bits. It's up to the external program to implement the
	// *actual* blinking.
	jint Java_org_bmsforum_jni_FlightData_getcmdsMode(JNIEnv *env, jobject obj);// Ownship CMDS mode state, see CmdsModes enum for details
	jint Java_org_bmsforum_jni_FlightData_getBupUhfPreset(JNIEnv *env, jobject obj);// BUP UHF channel preset

	// VERSION 3
	jint Java_org_bmsforum_jni_FlightData_getBupUhfFreq(JNIEnv *env, jobject obj);// BUP UHF channel frequency
	jfloat Java_org_bmsforum_jni_FlightData_getcabinAlt(JNIEnv *env, jobject obj);// Ownship cabin altitude
	jfloat Java_org_bmsforum_jni_FlightData_gethydPressureA(JNIEnv *env, jobject obj);// Ownship Hydraulic Pressure A
	jfloat Java_org_bmsforum_jni_FlightData_gethydPressureB(JNIEnv *env, jobject obj);// Ownship Hydraulic Pressure B
	jint Java_org_bmsforum_jni_FlightData_getcurrentTime(JNIEnv *env, jobject obj);	// Current time in seconds (max 60 * 60 * 24)
	jshort Java_org_bmsforum_jni_FlightData_getvehicleACD(JNIEnv *env, jobject obj);// Ownship ACD index number, i.e. which aircraft type are we flying.
	jint Java_org_bmsforum_jni_FlightData_getVersionNum2(JNIEnv *env, jobject obj);	// Version of FlightData2 mem area

	// VERSION 4
	jfloat Java_org_bmsforum_jni_FlightData_getfuelFlow2(JNIEnv *env, jobject obj); // Ownship fuel flow2 (Lbs/Hour)

	// VERSION 5 / 8
	jbyteArray Java_org_bmsforum_jni_FlightData_getRwrInfo(JNIEnv *env, jobject obj); 		// New RWR Info
	jfloat Java_org_bmsforum_jni_FlightData_getlefPos(JNIEnv *env, jobject obj);     // Ownship LEF position
	jfloat Java_org_bmsforum_jni_FlightData_gettefPos(JNIEnv *env, jobject obj);     // Ownship TEF position

	// VERSION 6
	jfloat Java_org_bmsforum_jni_FlightData_getvtolPos(JNIEnv *env, jobject obj); // Ownship VTOL exhaust angle

	// VERSION 9
	jbyte Java_org_bmsforum_jni_FlightData_getpilotsOnline(JNIEnv *env, jobject obj); // Number of pilots in an MP session
	jobjectArray Java_org_bmsforum_jni_FlightData_getpilotsCallsign(JNIEnv *env, jobject obj); // List of pilots callsign connected to an MP session
	jbyteArray Java_org_bmsforum_jni_FlightData_getpilotsStatus(JNIEnv *env, jobject obj); // Status of the MP pilots, see enum FlyStates
/**FlightData2 Methods END*/

	jintArray Java_org_bmsforum_jni_FlightData_getTextureData(JNIEnv *env, jobject obj);
}

#endif /* BMS433_HPP_ */
