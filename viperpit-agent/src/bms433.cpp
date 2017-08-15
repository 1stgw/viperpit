//============================================================================
// Name        : 33.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include "BMS433.hpp"
using namespace std;

//FalconTexturesSharedMemoryArea

int main() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
/*
	FlightData* flightData;

	do {
		flightDataMemHandle = OpenFileMapping(FILE_MAP_ALL_ACCESS, TRUE,
				TEXT("FalconSharedMemoryArea"));
		if(!flightDataMemHandle)
			cout << "Unable to open file. Is Falcon Running?\n" << endl;
		else
			cout << "Got Shared Memory" << endl;
	} while (!flightDataMemHandle);

	flightData = (FlightData*)MapViewOfFile(flightDataMemHandle, FILE_MAP_ALL_ACCESS, 0, 0, 0);

	while (TRUE) {
		//		cout <<flightData->IsSet(FlightData::AOAOn)<<endl;
		cout << flightData->gs << endl;
		for (int i = 0; i < 5; i++) {
			for (int x = 0; x < 25; x++)
				cout << flightData->DEDLines[i][x] << ",";
			cout << endl;
		}


	// Close shared memory area
	if (flightData) {
		UnmapViewOfFile(flightData);
		flightData = NULL;
	}
	CloseHandle(flightDataMemHandle);
*/

	do {
		textureDataMemHandle = OpenFileMapping(FILE_MAP_ALL_ACCESS, TRUE,
				TEXT("FalconTexturesSharedMemoryArea"));
		if (!textureDataMemHandle)
			cout << "Unable to open file. Is Falcon Running?\n" << endl;
		else
			cout << "Got Shared Memory" << endl;
	} while (!textureDataMemHandle);

	textureData = (long*)MapViewOfFile(textureDataMemHandle, FILE_MAP_READ, 0, 0, 0);

	if (textureData != NULL) {

		/* Get and print memory region size */
		MEMORY_BASIC_INFORMATION info;
		memset(&info, 0, sizeof(MEMORY_BASIC_INFORMATION));
		VirtualQuery(textureData, &info, sizeof(MEMORY_BASIC_INFORMATION));
		printf("Shared memory size of %s is %ld bytes\n",
				"FalconTexturesSharedMemoryArea", (long) info.RegionSize);
	}

//	while(TRUE){
		int l = 0;
		for(int i = l*1200; i<l*1200+1200; i++){
			cout<<textureData[i]<<",";
		}
		cout<<endl;
//	}

	// Close shared memory area
	if (textureData) {
		UnmapViewOfFile(textureData);
		textureData = NULL;
	}
	CloseHandle(textureDataMemHandle);

	return EXIT_SUCCESS;
}

extern "C"{
jboolean Java_org_bmsforum_jni_FlightData_init(JNIEnv *env, jobject obj) {
	bool loaded = true;
	// Opening FalconSharedMemoryArea
	flightDataMemHandle = OpenFileMapping(FILE_MAP_ALL_ACCESS, TRUE,
			TEXT("FalconSharedMemoryArea"));
	if (!flightDataMemHandle) {
		loaded = false;
	} else{
		flightData = (FlightData*) MapViewOfFile(flightDataMemHandle,
				FILE_MAP_ALL_ACCESS, 0, 0, 0);
	}

	// Opening FalconSharedMemoryArea2
	flightData2MemHandle = OpenFileMapping(FILE_MAP_ALL_ACCESS, TRUE,
			TEXT("FalconSharedMemoryArea2"));
	if (!flightData2MemHandle) {
		loaded = false;
	} else{
		flightData2 = (FlightData2*) MapViewOfFile(flightData2MemHandle,
				FILE_MAP_ALL_ACCESS, 0, 0, 0);
	}

	// Opening FalconSharedOsbMemoryArea
	OSBDataMemHandle = OpenFileMapping(FILE_MAP_ALL_ACCESS, TRUE,
			TEXT("FalconSharedOsbMemoryArea"));
	if (!OSBDataMemHandle) {
		loaded = false;
	} else{
		osbData = (OSBData*) MapViewOfFile(OSBDataMemHandle,
				FILE_MAP_ALL_ACCESS, 0, 0, 0);
	}

	// Opening FalconTexturesSharedMemoryArea
	textureDataMemHandle = OpenFileMapping(FILE_MAP_READ, TRUE,
				TEXT("FalconTexturesSharedMemoryArea"));
	if (!textureDataMemHandle) {
		loaded = false;
	} else {
		textureData = (long*) MapViewOfFile(textureDataMemHandle,
				FILE_MAP_READ, 0, 0, 0);
	}

	if(!loaded){
		cout << "Unable to open file. Is Falcon Running?" << endl;
		Java_org_bmsforum_jni_FlightData_dispose(env, obj);
	}else{
		cout << "Got BSM SharedMemoryArea" << endl;
	}
	return loaded;
}
jboolean Java_org_bmsforum_jni_FlightData_dispose(JNIEnv *env, jobject obj){
	bool allClose = true;
	if (flightData) {
		UnmapViewOfFile(flightData);
		flightData = NULL;
	}

	if(!CloseHandle(flightDataMemHandle)) allClose = false;
	if (flightData2) {
		UnmapViewOfFile(flightData2);
		flightData2 = NULL;
	}
	if(!CloseHandle(flightData2MemHandle)) allClose = false;

	if (osbData) {
		UnmapViewOfFile(osbData);
		osbData = NULL;
	}
	if(!CloseHandle(OSBDataMemHandle)) allClose = false;

	if (textureData) {
		UnmapViewOfFile(textureData);
		textureData = NULL;
	}
	if(!CloseHandle(textureDataMemHandle)) allClose = false;
	return allClose;
}
/**FlightData1 Methods START*/
jboolean Java_org_bmsforum_jni_FlightData_isSet1(JNIEnv *env, jobject obj,
		jint mask) {
	if (flightData == NULL)
		return false;
	return flightData->IsSet(mask);
}
jboolean Java_org_bmsforum_jni_FlightData_isSet2(JNIEnv *env, jobject obj,
		jint mask) {
	if (flightData == NULL)
		return false;
	return flightData->IsSet2(mask);
	return false;
}
jboolean Java_org_bmsforum_jni_FlightData_isSet3(JNIEnv *env, jobject obj,
		jint mask) {
	if (flightData == NULL)
		return false;
	return flightData->IsSet3(mask);
	return false;
}
jboolean Java_org_bmsforum_jni_FlightData_isSetHSI(JNIEnv *env, jobject obj,
		jint mask) {
	if (flightData == NULL)
		return false;
	return flightData->IsSetHsi(mask);
	return false;
}
jfloat Java_org_bmsforum_jni_FlightData_getx(JNIEnv *env, jobject obj) {
	return flightData->x;
}
jfloat Java_org_bmsforum_jni_FlightData_gety(JNIEnv *env, jobject obj) {
	return flightData->y;
}
jfloat Java_org_bmsforum_jni_FlightData_getz(JNIEnv *env, jobject obj) {
	return flightData->z;
}
jfloat Java_org_bmsforum_jni_FlightData_getxDot(JNIEnv *env, jobject obj) {
	return flightData->xDot;
}
jfloat Java_org_bmsforum_jni_FlightData_getyDot(JNIEnv *env, jobject obj) {
	return flightData->yDot;
}
jfloat Java_org_bmsforum_jni_FlightData_getzDot(JNIEnv *env, jobject obj) {
	return flightData->zDot;
}
jfloat Java_org_bmsforum_jni_FlightData_getalpha(JNIEnv *env, jobject obj) {
	return flightData->alpha;
}
jfloat Java_org_bmsforum_jni_FlightData_getbeta(JNIEnv *env, jobject obj) {
	return flightData->beta;
}
jfloat Java_org_bmsforum_jni_FlightData_getgamma(JNIEnv *env, jobject obj) {
	return flightData->gamma;
}
jfloat Java_org_bmsforum_jni_FlightData_getpitch(JNIEnv *env, jobject obj) {
	return flightData->pitch;
}
jfloat Java_org_bmsforum_jni_FlightData_getroll(JNIEnv *env, jobject obj) {
	return flightData->roll;
}
jfloat Java_org_bmsforum_jni_FlightData_getyaw(JNIEnv *env, jobject obj) {
	return flightData->yaw;
}
jfloat Java_org_bmsforum_jni_FlightData_getmach(JNIEnv *env, jobject obj) {
	return flightData->mach;
}
jfloat Java_org_bmsforum_jni_FlightData_getkias(JNIEnv *env, jobject obj) {
	return flightData->kias;
}
jfloat Java_org_bmsforum_jni_FlightData_getvt(JNIEnv *env, jobject obj) {
	return flightData->vt;
}
jfloat Java_org_bmsforum_jni_FlightData_getgs(JNIEnv *env, jobject obj) {
	return flightData->gs;
}
jfloat Java_org_bmsforum_jni_FlightData_getwindOffset(JNIEnv *env,
		jobject obj) {
	return flightData->windOffset;
}
jfloat Java_org_bmsforum_jni_FlightData_getnozzlePos(JNIEnv *env, jobject obj) {
	return flightData->nozzlePos;
}
jfloat Java_org_bmsforum_jni_FlightData_getinternalFuel(JNIEnv *env,
		jobject obj) {
	return flightData->internalFuel;
}
jfloat Java_org_bmsforum_jni_FlightData_getexternalFuel(JNIEnv *env,
		jobject obj) {
	return flightData->externalFuel;
}
jfloat Java_org_bmsforum_jni_FlightData_getfuelFlow(JNIEnv *env, jobject obj) {
	return flightData->fuelFlow;
}
jfloat Java_org_bmsforum_jni_FlightData_getrpm(JNIEnv *env, jobject obj) {
	return flightData->rpm;
}
jfloat Java_org_bmsforum_jni_FlightData_getftit(JNIEnv *env, jobject obj) {
	return flightData->ftit;
}
jfloat Java_org_bmsforum_jni_FlightData_getgearPos(JNIEnv *env, jobject obj) {
	return flightData->gearPos;
}
jfloat Java_org_bmsforum_jni_FlightData_getspeedBrake(JNIEnv *env,
		jobject obj) {
	return flightData->speedBrake;
}
jfloat Java_org_bmsforum_jni_FlightData_getepuFuel(JNIEnv *env, jobject obj) {
	return flightData->epuFuel;
}
jfloat Java_org_bmsforum_jni_FlightData_getoilPressure(JNIEnv *env,
		jobject obj) {
	return flightData->oilPressure;
}
jint Java_org_bmsforum_jni_FlightData_lightBits(JNIEnv *env, jobject obj) {
	return flightData->lightBits;
}
jfloat Java_org_bmsforum_jni_FlightData_setheadPitch(JNIEnv *env, jobject obj,
		jfloat v) {
	float l = flightData->headPitch;
	flightData->headPitch = v;
	return l;
}
jfloat Java_org_bmsforum_jni_FlightData_setheadRoll(JNIEnv *env, jobject obj,
		jfloat v) {
	float l = flightData->headRoll;
	flightData->headRoll = v;
	return l;
}
jfloat Java_org_bmsforum_jni_FlightData_setheadYaw(JNIEnv *env, jobject obj,
		jfloat v) {
	float l = flightData->headYaw;
	flightData->headYaw = v;
	return l;
}
jint Java_org_bmsforum_jni_FlightData_getlightBits2(JNIEnv *env, jobject obj) {
	return flightData->lightBits2;
}
jint Java_org_bmsforum_jni_FlightData_getlightBits3(JNIEnv *env, jobject obj) {
	return flightData->lightBits3;
}
jfloat Java_org_bmsforum_jni_FlightData_getChaffCount(JNIEnv *env,
		jobject obj) {
	return flightData->ChaffCount;
}
jfloat Java_org_bmsforum_jni_FlightData_getFlareCount(JNIEnv *env,
		jobject obj) {
	return flightData->FlareCount;
}
jfloat Java_org_bmsforum_jni_FlightData_getNoseGearPos(JNIEnv *env,
		jobject obj) {
	return flightData->NoseGearPos;
}
jfloat Java_org_bmsforum_jni_FlightData_getLeftGearPos(JNIEnv *env,
		jobject obj) {
	return flightData->LeftGearPos;
}
jfloat Java_org_bmsforum_jni_FlightData_getRightGearPos(JNIEnv *env,
		jobject obj) {
	return flightData->RightGearPos;
}
jfloat Java_org_bmsforum_jni_FlightData_getAdiIlsHorPos(JNIEnv *env,
		jobject obj) {
	return flightData->AdiIlsHorPos;
}
jfloat Java_org_bmsforum_jni_FlightData_getAdiIlsVerPos(JNIEnv *env,
		jobject obj) {
	return flightData->AdiIlsVerPos;
}
jint Java_org_bmsforum_jni_FlightData_getcourseState(JNIEnv *env, jobject obj) {
	return flightData->courseState;
}
jint Java_org_bmsforum_jni_FlightData_getheadingState(JNIEnv *env,
		jobject obj) {
	return flightData->headingState;
}
jint Java_org_bmsforum_jni_FlightData_gettotalStates(JNIEnv *env, jobject obj) {
	return flightData->totalStates;
}
jfloat Java_org_bmsforum_jni_FlightData_getcourseDeviation(JNIEnv *env,
		jobject obj) {
	return flightData->courseDeviation;
}
jfloat Java_org_bmsforum_jni_FlightData_getdesiredCourse(JNIEnv *env,
		jobject obj) {
	return flightData->desiredCourse;
}
jfloat Java_org_bmsforum_jni_FlightData_getdistanceToBeacon(JNIEnv *env,
		jobject obj) {
	return flightData->distanceToBeacon;
}
jfloat Java_org_bmsforum_jni_FlightData_getbearingToBeacon(JNIEnv *env,
		jobject obj) {
	return flightData->bearingToBeacon;
}
jfloat Java_org_bmsforum_jni_FlightData_getcurrentHeading(JNIEnv *env,
		jobject obj) {
	return flightData->currentHeading;
}
jfloat Java_org_bmsforum_jni_FlightData_getdesiredHeading(JNIEnv *env,
		jobject obj) {
	return flightData->desiredHeading;
}
jfloat Java_org_bmsforum_jni_FlightData_getdeviationLimit(JNIEnv *env,
		jobject obj) {
	return flightData->deviationLimit;
}
jfloat Java_org_bmsforum_jni_FlightData_gethalfDeviationLimit(JNIEnv *env,
		jobject obj) {
	return flightData->halfDeviationLimit;
}
jfloat Java_org_bmsforum_jni_FlightData_getlocalizerCourse(JNIEnv *env,
		jobject obj) {
	return flightData->localizerCourse;
}
jfloat Java_org_bmsforum_jni_FlightData_getairbaseX(JNIEnv *env, jobject obj) {
	return flightData->airbaseX;
}
jfloat Java_org_bmsforum_jni_FlightData_getairbaseY(JNIEnv *env, jobject obj) {
	return flightData->airbaseY;
}
jfloat Java_org_bmsforum_jni_FlightData_gettotalValues(JNIEnv *env,
		jobject obj) {
	return flightData->totalValues;
}
jfloat Java_org_bmsforum_jni_FlightData_getTrimPitch(JNIEnv *env, jobject obj) {
	return flightData->TrimPitch;
}
jfloat Java_org_bmsforum_jni_FlightData_getTrimRoll(JNIEnv *env, jobject obj) {
	return flightData->TrimRoll;
}
jfloat Java_org_bmsforum_jni_FlightData_getTrimYaw(JNIEnv *env, jobject obj) {
	return flightData->TrimYaw;
}
jint Java_org_bmsforum_jni_FlightData_gethsiBits(JNIEnv *env, jobject obj) {
	return flightData->hsiBits;
}
jobjectArray Java_org_bmsforum_jni_FlightData_getDEDLines(JNIEnv *env, jobject obj){
	jclass charClass = env->FindClass("[B");
	if (charClass == NULL) {
		return NULL;
	}
	// Create the returnable 2D array
	jobjectArray out = env->NewObjectArray((jsize) 5, charClass, 0);
	// Go through the firs dimension and add the second dimension arrays
	for (unsigned int i = 0; i < 5; i++) {
		jbyteArray charArray = env->NewByteArray(26);
	    env->SetByteArrayRegion(charArray, (jsize) 0, (jsize) 26, (jbyte*) (flightData->DEDLines[i]));
	    env->SetObjectArrayElement(out, (jsize) i, charArray);
	    env->DeleteLocalRef(charArray);
	}
	return out;
}
jobjectArray Java_org_bmsforum_jni_FlightData_getInvert(JNIEnv *env, jobject obj){
	jclass charClass = env->FindClass("[B");
	if (charClass == NULL) {
		return NULL;
	}
	// Create the returnable 2D array
	jobjectArray out = env->NewObjectArray((jsize) 5, charClass, 0);
	// Go through the firs dimension and add the second dimension arrays
	for (unsigned int i = 0; i < 5; i++) {
		jbyteArray charArray = env->NewByteArray(26);
	    env->SetByteArrayRegion(charArray, (jsize) 0, (jsize) 26, (jbyte*) (flightData->Invert[i]));
	    env->SetObjectArrayElement(out, (jsize) i, charArray);
	    env->DeleteLocalRef(charArray);
	}
	return out;
}
jobjectArray Java_org_bmsforum_jni_FlightData_getPFLLines(JNIEnv *env, jobject obj){
	jclass charClass = env->FindClass("[B");
	if (charClass == NULL) {
		return NULL;
	}
	// Create the returnable 2D array
	jobjectArray out = env->NewObjectArray((jsize) 5, charClass, 0);
	// Go through the firs dimension and add the second dimension arrays
	for (unsigned int i = 0; i < 5; i++) {
		jbyteArray charArray = env->NewByteArray(26);
	    env->SetByteArrayRegion(charArray, (jsize) 0, (jsize) 26, (jbyte*) (flightData->PFLLines[i]));
	    env->SetObjectArrayElement(out, (jsize) i, charArray);
	    env->DeleteLocalRef(charArray);
	}
	return out;
}
jobjectArray Java_org_bmsforum_jni_FlightData_getPFLInvert(JNIEnv *env, jobject obj){
	jclass charClass = env->FindClass("[B");
	if (charClass == NULL) {
		return NULL;
	}
	// Create the returnable 2D array
	jobjectArray out = env->NewObjectArray((jsize) 5, charClass, 0);
	// Go through the firs dimension and add the second dimension arrays
	for (unsigned int i = 0; i < 5; i++) {
		jbyteArray charArray = env->NewByteArray(26);
	    env->SetByteArrayRegion(charArray, (jsize) 0, (jsize) 26, (jbyte*) (flightData->PFLInvert[i]));
	    env->SetObjectArrayElement(out, (jsize) i, charArray);
	    env->DeleteLocalRef(charArray);
	}
	return out;
}
jint Java_org_bmsforum_jni_FlightData_getUFCTChan(JNIEnv *env, jobject obj) {
	return flightData->UFCTChan;
}
jint Java_org_bmsforum_jni_FlightData_getAUXTChan(JNIEnv *env, jobject obj) {
	return flightData->AUXTChan;
}
jint Java_org_bmsforum_jni_FlightData_getRwrObjectCount(JNIEnv *env, jobject obj) {
	return flightData->RwrObjectCount;
}
jintArray Java_org_bmsforum_jni_FlightData_getRWRsymbol(JNIEnv *env, jobject obj) {
	jintArray out = env->NewIntArray(40);
	env->SetIntArrayRegion(out, (jsize) 0, (jsize) 40, (jint*) flightData->RWRsymbol);
	return out;
}
jfloatArray Java_org_bmsforum_jni_FlightData_getbearing(JNIEnv *env, jobject obj){
	jfloatArray out = env->NewFloatArray(40);
	env->SetFloatArrayRegion(out, (jsize)0, (jsize)40, (jfloat*) flightData->bearing);
	return out;
}
jlongArray	Java_org_bmsforum_jni_FlightData_getmissileActivity(JNIEnv *env, jobject obj){
	jlongArray out = env->NewLongArray(40);
	env->SetLongArrayRegion(out, (jsize)0, (jsize)40, (jlong*) flightData->missileActivity);
	return out;
}
jlongArray 	Java_org_bmsforum_jni_FlightData_getmissileLaunch(JNIEnv *env, jobject obj){
	jlongArray out = env->NewLongArray(40);
	env->SetLongArrayRegion(out, (jsize)0, (jsize)40, (jlong*) flightData->missileLaunch);
	return out;
}
jlongArray	Java_org_bmsforum_jni_FlightData_getselected(JNIEnv *env, jobject obj){
	jlongArray out = env->NewLongArray(40);
	env->SetLongArrayRegion(out, (jsize)0, (jsize)40, (jlong*) flightData->selected);
	return out;
}
jfloatArray Java_org_bmsforum_jni_FlightData_getlethality(JNIEnv *env, jobject obj){
	jfloatArray out = env->NewFloatArray(40);
	env->SetFloatArrayRegion(out, (jsize)0, (jsize)40, (jfloat*) flightData->lethality);
	return out;
}
jlongArray 	Java_org_bmsforum_jni_FlightData_getnewDetection(JNIEnv *env, jobject obj){
	jlongArray out = env->NewLongArray(40);
	env->SetLongArrayRegion(out, (jsize)0, (jsize)40, (jlong*) flightData->newDetection);
	return out;
}
jfloat Java_org_bmsforum_jni_FlightData_getfwd(JNIEnv *env, jobject obj){
	return flightData->fwd;
}
jfloat Java_org_bmsforum_jni_FlightData_getaft(JNIEnv *env, jobject obj){
	return flightData->aft;
}
jfloat Java_org_bmsforum_jni_FlightData_gettotal(JNIEnv *env, jobject obj){
	return flightData->total;
}
jint Java_org_bmsforum_jni_FlightData_getVersionNum(JNIEnv *env, jobject obj){
	return flightData->VersionNum;
}
jfloat Java_org_bmsforum_jni_FlightData_setheadX(JNIEnv *env, jobject obj, jfloat v){
	float l = flightData->headX;
	flightData->headX = v;
	return l;
}
jfloat Java_org_bmsforum_jni_FlightData_setheadY(JNIEnv *env, jobject obj, jfloat v){
	float l = flightData->headY;
	flightData->headY = v;
	return l;
}
jfloat Java_org_bmsforum_jni_FlightData_setheadZ(JNIEnv *env, jobject obj, jfloat v){
	float l = flightData->headZ;
	flightData->headZ = v;
	return l;
}
jint Java_org_bmsforum_jni_FlightData_getMainPower(JNIEnv *env, jobject obj){
	return flightData->MainPower;
}
/**FlightData1 Methods END*/
/**FlightData2 Methods START*/
jboolean Java_org_bmsforum_jni_FlightData_ufcTacanIsAA(JNIEnv *env, jobject obj){
	return flightData2->UfcTacanIsAA();
}
jboolean Java_org_bmsforum_jni_FlightData_auxTacanIsAA(JNIEnv *env, jobject obj){
	return flightData2->AuxTacanIsAA();
}
jboolean Java_org_bmsforum_jni_FlightData_ufcTacanIsX(JNIEnv *env, jobject obj){
	return flightData2->UfcTacanIsX();
}
jboolean Java_org_bmsforum_jni_FlightData_auxTacanIsX(JNIEnv *env, jobject obj){
	return flightData2->AuxTacanIsX();
}
jboolean Java_org_bmsforum_jni_FlightData_isSetAlt(JNIEnv *env, jobject obj, jint mask){
	return flightData2->IsSetAlt(mask);
}
jboolean Java_org_bmsforum_jni_FlightData_isSetPower(JNIEnv *env, jobject obj, jint mask){
	return flightData2->IsSetPower(mask);
}
jboolean Java_org_bmsforum_jni_FlightData_isSetBlink(JNIEnv *env, jobject obj, jint mask){
	return flightData2->IsSetBlink(mask);
}
jfloat Java_org_bmsforum_jni_FlightData_getnozzlePos2(JNIEnv *env, jobject obj){
	return flightData2->nozzlePos2;
}
jfloat Java_org_bmsforum_jni_FlightData_getrpm2(JNIEnv *env, jobject obj){
	return flightData2->rpm2;
}
jfloat Java_org_bmsforum_jni_FlightData_getftit2(JNIEnv *env, jobject obj){
	return flightData2->ftit2;
}
jfloat Java_org_bmsforum_jni_FlightData_getoilPressure2(JNIEnv *env, jobject obj){
	return flightData2->oilPressure2;
}
jbyte Java_org_bmsforum_jni_FlightData_getnavMode(JNIEnv *env, jobject obj){
	return flightData2->navMode;
}
jfloat Java_org_bmsforum_jni_FlightData_getAAUZ(JNIEnv *env, jobject obj){
	return flightData2->AAUZ;
}
jbyteArray Java_org_bmsforum_jni_FlightData_gettacanInfo(JNIEnv *env, jobject obj){
	jbyteArray out = env->NewByteArray(FlightData2::NUMBER_OF_SOURCES);
	env->SetByteArrayRegion(out, (jsize)0, (jsize)FlightData2::NUMBER_OF_SOURCES, (jbyte*) flightData2->tacanInfo);
	return out;
}
jint Java_org_bmsforum_jni_FlightData_getAltCalReading(JNIEnv *env, jobject obj){
	return flightData2->AltCalReading;
}
jint Java_org_bmsforum_jni_FlightData_getaltBits(JNIEnv *env, jobject obj){
	return flightData2->altBits;
}
jint Java_org_bmsforum_jni_FlightData_getpowerBits(JNIEnv *env, jobject obj){
	return flightData2->powerBits;
}
jint Java_org_bmsforum_jni_FlightData_getblinkBits(JNIEnv *env, jobject obj){
	return flightData2->blinkBits;
}
jint Java_org_bmsforum_jni_FlightData_getcmdsMode(JNIEnv *env, jobject obj){
	return flightData2->cmdsMode;
}
jint Java_org_bmsforum_jni_FlightData_getBupUhfPreset(JNIEnv *env, jobject obj){
	return flightData2->BupUhfPreset;
}
jint Java_org_bmsforum_jni_FlightData_getBupUhfFreq(JNIEnv *env, jobject obj){
	return flightData2->BupUhfFreq;
}
jfloat Java_org_bmsforum_jni_FlightData_getcabinAlt(JNIEnv *env, jobject obj){
	return flightData2->cabinAlt;
}
jfloat Java_org_bmsforum_jni_FlightData_gethydPressureA(JNIEnv *env, jobject obj){
	return flightData2->hydPressureA;
}
jfloat Java_org_bmsforum_jni_FlightData_gethydPressureB(JNIEnv *env, jobject obj){
	return flightData2->hydPressureB;
}
jint Java_org_bmsforum_jni_FlightData_getcurrentTime(JNIEnv *env, jobject obj){
	return flightData2->currentTime;
}
jshort Java_org_bmsforum_jni_FlightData_getvehicleACD(JNIEnv *env, jobject obj){
	return flightData2->vehicleACD;
}
jint Java_org_bmsforum_jni_FlightData_getVersionNum2(JNIEnv *env, jobject obj){
	return flightData2->VersionNum;
}
jfloat Java_org_bmsforum_jni_FlightData_getfuelFlow2(JNIEnv *env, jobject obj){
	return flightData2->fuelFlow2;
}
jbyteArray Java_org_bmsforum_jni_FlightData_getRwrInfo(JNIEnv *env, jobject obj){
	jbyteArray out = env->NewByteArray(RWRINFO_SIZE);
	env->SetByteArrayRegion(out, (jsize)0, (jsize)RWRINFO_SIZE, (jbyte*) flightData2->RwrInfo);
	return out;
}
jfloat Java_org_bmsforum_jni_FlightData_getlefPos(JNIEnv *env, jobject obj){
	return flightData2->lefPos;
}
jfloat Java_org_bmsforum_jni_FlightData_gettefPos(JNIEnv *env, jobject obj){
	return flightData2->tefPos;
}
jfloat Java_org_bmsforum_jni_FlightData_getvtolPos(JNIEnv *env, jobject obj){
	return flightData2->vtolPos;
}
jbyte Java_org_bmsforum_jni_FlightData_getpilotsOnline(JNIEnv *env, jobject obj){
	return flightData2->pilotsOnline;
}
jobjectArray Java_org_bmsforum_jni_FlightData_getpilotsCallsign(JNIEnv *env, jobject obj){
	jclass charClass = env->FindClass("[B");
	if (charClass == NULL) {
		return NULL;
	}
	// Create the returnable 2D array
	jobjectArray out = env->NewObjectArray((jsize) MAX_CALLSIGNS, charClass, 0);
	// Go through the firs dimension and add the second dimension arrays
	for (unsigned int i = 0; i < MAX_CALLSIGNS; i++) {
		jbyteArray charArray = env->NewByteArray(CALLSIGN_LEN);
	    env->SetByteArrayRegion(charArray, (jsize) 0, (jsize) CALLSIGN_LEN, (jbyte*) (flightData2->pilotsCallsign[i]));
	    env->SetObjectArrayElement(out, (jsize) i, charArray);
	    env->DeleteLocalRef(charArray);
	}
	return out;
}
jbyteArray Java_org_bmsforum_jni_FlightData_getpilotsStatus(JNIEnv *env, jobject obj){
	jbyteArray out = env->NewByteArray(MAX_CALLSIGNS);
	env->SetByteArrayRegion(out, (jsize)0, (jsize)MAX_CALLSIGNS, (jbyte*) flightData2->pilotsStatus);
	return out;
}
/**FlightData2 Methods END*/

jintArray Java_org_bmsforum_jni_FlightData_getTextureData(JNIEnv *env, jobject obj){
	jintArray out = env->NewIntArray(1200*1200);
	env->SetIntArrayRegion(out, (jsize)0, (jsize)1200*1200, (jint*) textureData+32);
	return out;
}

}
