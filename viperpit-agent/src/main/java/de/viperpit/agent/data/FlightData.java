package de.viperpit.agent.data;

public class FlightData {
	
	public static final int FLIGHTDATA_VERSION = 117;
	public static final int RWRINFO_SIZE = 512;
	public static final int CALLSIGN_LEN = 12;
	public static final int MAX_CALLSIGNS = 32;
	
	static{
		try{
			System.loadLibrary("bms434");
		}catch(UnsatisfiedLinkError e){
			e.printStackTrace();
		}catch(SecurityException e){
			e.printStackTrace();
		}
	}
	
/**Native methods START*/
	private native boolean init();
	
	/**FlightData1 Methods START*/
	public native boolean isSet1(int mask);
	public native boolean isSet2(int mask);
	public native boolean isSet3(int mask);
	public native boolean isSetHSI(int mask);
	
	public native float getx();            // Ownship North (Ft)
	public native float gety();            // Ownship East (Ft)
	public native float getz();            // Ownship Down (Ft) --- NOTE: use FlightData2 AAUZ for barometric altitude!
	public native float getxDot();         // Ownship North Rate (ft/sec)
	public native float getyDot();         // Ownship East Rate (ft/sec)
	public native float getzDot();         // Ownship Down Rate (ft/sec)
	public native float getalpha();        // Ownship AOA (Degrees)
	public native float getbeta();         // Ownship Beta (Degrees)
	public native float getgamma();        // Ownship Gamma (Radians)
	public native float getpitch();        // Ownship Pitch (Radians)
	public native float getroll();         // Ownship Pitch (Radians)
	public native float getyaw();          // Ownship Pitch (Radians)
	public native float getmach();         // Ownship Mach number
	public native float getkias();         // Ownship Indicated Airspeed (Knots)
	public native float getvt();           // Ownship True Airspeed (Ft/Sec)
	public native float getgs();           // Ownship Normal Gs
	public native float getwindOffset();   // Wind delta to FPM (Radians)
	public native float getnozzlePos();    // Ownship engine nozzle percent open (0-100)
	//float nozzlePos2;   // MOVED TO FlightData2! Ownship engine nozzle2 percent open (0-100) 
	public native float getinternalFuel(); // Ownship internal fuel (Lbs)
	public native float getexternalFuel(); // Ownship external fuel (Lbs)
	public native float getfuelFlow();     // Ownship fuel flow (Lbs/Hour)
	public native float getrpm();          // Ownship engine rpm (Percent 0-103)
	//float rpm2();         // MOVED TO FlightData2! Ownship engine rpm2 (Percent 0-103)
	public native float getftit();         // Ownship Forward Turbine Inlet Temp (Degrees C)
	//float ftit2();        // MOVED TO FlightData2! Ownship Forward Turbine Inlet Temp2 (Degrees C)
	public native float getgearPos();      // Ownship Gear position 0 = up, 1 = down;
	public native float getspeedBrake();   // Ownship speed brake position 0 = closed, 1 = 60 Degrees open
	public native float getepuFuel();      // Ownship EPU fuel (Percent 0-100)
	public native float getoilPressure();  // Ownship Oil Pressure (Percent 0-100)
	//float oilPressure2(); // MOVED TO FlightData2! Ownship Oil Pressure2 (Percent 0-100)
	public native int   getlightBits();    // Cockpit Indicator Lights, one bit per bulb. See enum

	// These are inputs. Use them carefully
	// NB: these do not work when TrackIR device is enabled
	// NB2: launch falcon with the '-head' command line parameter to activate !
	public native float setheadPitch(float v);    // Head pitch offset from design eye (radians)
	public native float setheadRoll(float v);     // Head roll offset from design eye (radians)
	public native float setheadYaw(float v);      // Head yaw offset from design eye (radians)

	// new lights
	public native int getlightBits2();   // Cockpit Indicator Lights, one bit per bulb. See enum
	public native int getlightBits3();   // Cockpit Indicator Lights, one bit per bulb. See enum

	// chaff/flare
	public native float getChaffCount();   // Number of Chaff left
	public native float getFlareCount();   // Number of Flare left

	// landing gear
	public native float getNoseGearPos();  // Position of the nose landinggear; caution: full down values defined in dat files
	public native float getLeftGearPos();  // Position of the left landinggear; caution: full down values defined in dat files
	public native float getRightGearPos(); // Position of the right landinggear; caution: full down values defined in dat files

	// ADI values
	public native float getAdiIlsHorPos(); // Position of horizontal ILS bar
	public native float getAdiIlsVerPos(); // Position of vertical ILS bar

	// HSI states
	public native int getcourseState();    // HSI_STA_CRS_STATE
	public native int getheadingState();   // HSI_STA_HDG_STATE
	public native int gettotalStates();    // HSI_STA_TOTAL_STATES; never set

	// HSI values
	public native float getcourseDeviation();     // HSI_VAL_CRS_DEVIATION
	public native float getdesiredCourse();       // HSI_VAL_DESIRED_CRS
	public native float getdistanceToBeacon();    // HSI_VAL_DISTANCE_TO_BEACON
	public native float getbearingToBeacon();     // HSI_VAL_BEARING_TO_BEACON
	public native float getcurrentHeading();      // HSI_VAL_CURRENT_HEADING
	public native float getdesiredHeading();      // HSI_VAL_DESIRED_HEADING
	public native float getdeviationLimit();      // HSI_VAL_DEV_LIMIT
	public native float gethalfDeviationLimit();  // HSI_VAL_HALF_DEV_LIMIT
	public native float getlocalizerCourse();     // HSI_VAL_LOCALIZER_CRS
	public native float getairbaseX();            // HSI_VAL_AIRBASE_X
	public native float getairbaseY();            // HSI_VAL_AIRBASE_Y
	public native float gettotalValues();         // HSI_VAL_TOTAL_VALUES; never set

	public native float getTrimPitch();  // Value of trim in pitch axis, -0.5 to +0.5
	public native float getTrimRoll();   // Value of trim in roll axis, -0.5 to +0.5
	public native float getTrimYaw();    // Value of trim in yaw axis, -0.5 to +0.5

	// HSI flags
	public native int gethsiBits();      // HSI flags

	//DED Lines
	public native byte[][] getDEDLines();	//25 usable chars
	public native byte[][] getInvert();	//25 usable chars

	//PFL Lines
	public native byte[][] getPFLLines();  //25 usable chars
	public native byte[][] getPFLInvert(); //25 usable chars

	//TacanChannel
	public native int getUFCTChan();
	public native int getAUXTChan();

	// RWR
	public native int     	getRwrObjectCount();
	public native int[]   	getRWRsymbol();
	public native float[] 	getbearing();
	public native long[] 	getmissileActivity();
	public native long[] 	getmissileLaunch();
	public native long[] 	getselected();
	public native float[] 	getlethality();
	public native long[] 	getnewDetection();

	//fuel values
	public native float getfwd(); 
	public native float getaft(); 
	public native float gettotal();
		
	public native	int getVersionNum();    // Version of FlightData mem area

	// New values added here for header file compatibility but not implemented
	// in this version of the code at present.
	public native float setheadX(float v);       // Head X offset from design eye (feet)
	public native float setheadY(float v);       // Head Y offset from design eye (feet)
	public native float setheadZ(float v);       // Head Z offset from design eye (feet)

	public native int MainPower();     // Main Power switch state, 0=down, 1=middle, 2=up
	/**FlightData1 Methods END*/
	
	/**FlightData2 Methods START*/
	// TACAN
	public native boolean ufcTacanIsAA();
	public native boolean auxTacanIsAA();
	public native boolean ufcTacanIsX();
	public native boolean auxTacanIsX();

	// ALTIMETER
	public native boolean isSetAlt(int mask);

	// POWER
	public native boolean isSetPower(int mask);

	// BLINKING LIGHTS
	public native boolean isSetBlink(int mask);
		
	// VERSION 1
	public native float getnozzlePos2();       // Ownship engine nozzle2 percent open (0-100)
	public native float getrpm2();             // Ownship engine rpm2 (Percent 0-103)
	public native float getftit2();            // Ownship Forward Turbine Inlet Temp2 (Degrees C)
	public native float getoilPressure2();     // Ownship Oil Pressure2 (Percent 0-100)
	public native byte getnavMode();  			// current mode selected for HSI/eHSI, see NavModes enum for details
	public native float getAAUZ();             // Ownship barometric altitude given by AAU (depends on calibration)
	public native byte[] gettacanInfo(); // Tacan band/mode settings for UFC and AUX COMM

	// VERSION 2 / 7
	public native int getAltCalReading();	// barometric altitude calibration (depends on CalType)
	public native int getaltBits();			// various altimeter bits, see AltBits enum for details
	public native int getpowerBits();		// Ownship power bus / generator states, see PowerBits enum for details
	public native int getblinkBits();		// Cockpit indicator lights blink status, see BlinkBits enum for details
											// NOTE: these bits indicate only *if* a lamp is blinking, in addition to the
											// existing on/off bits. It's up to the external program to implement the
											// *actual* blinking.
	public native int getcmdsMode();		// Ownship CMDS mode state, see CmdsModes enum for details
	public native int getBupUhfPreset();	// BUP UHF channel preset

	// VERSION 3
	public native int getBupUhfFreq();		// BUP UHF channel frequency
	public native float getcabinAlt();		// Ownship cabin altitude
	public native float gethydPressureA();	// Ownship Hydraulic Pressure A
	public native float gethydPressureB();	// Ownship Hydraulic Pressure B
	public native int getcurrentTime();		// Current time in seconds (max 60 * 60 * 24)
	public native short getvehicleACD();	// Ownship ACD index number, i.e. which aircraft type are we flying.
	public native int getVersionNum2();		// Version of FlightData2 mem area

	// VERSION 4
	public native float getfuelFlow2();    // Ownship fuel flow2 (Lbs/Hour)

	// VERSION 5 / 8
	public native byte[] getRwrInfo(); 		// New RWR Info
	public native float getlefPos();        // Ownship LEF position
	public native float gettefPos();        // Ownship TEF position

	// VERSION 6
	public native float getvtolPos();      // Ownship VTOL exhaust angle

	// VERSION 9
	public native byte getpilotsOnline();  		// Number of pilots in an MP session
	public native byte[][] getpilotsCallsign(); // List of pilots callsign connected to an MP session
	public native byte[] getpilotsStatus();     // Status of the MP pilots, see enum FlyStates
	/**FlightData2 Methods END*/
	
	public native int[] getTextureData();
	
/**Native methods END*/	
	
	public FlightData(boolean verbose){
		if(verbose)
			System.out.println("Initializing Java BMS SharedMemory Wrapper");
		while(!init()){
			if(verbose) System.out.println("BMS not started. Waiting 1 second before rechecking.");
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
		if(verbose)
			System.out.println("Java BMS SharedMemory Wrapper Ready");
	}
	
	public enum LightBits{
		MasterCaution(0x1),  // Left eyebrow

		// Brow Lights
		TF(0x2), // Left eyebrow
		OXY_BROW(0x4), // repurposed for eyebrow OXY LOW (was OBS, unused)
		EQUIP_HOT(0x8), // Caution light; repurposed for cooling fault (was: not used)
		ONGROUND(0x10), // True if on ground: this is not a lamp bit!
		ENG_FIRE(0x20), // Right eyebrow; upper half of split face lamp
		CONFIG(0x40), // Stores config, caution panel
		HYD(0x80), // Right eyebrow; see also OIL (this lamp is not split face)
		Flcs_ABCD(0x100), // TEST panel FLCS channel lamps; repurposed, was OIL (see HYD; that lamp is not split face)
		FLCS(0x200), // Right eyebrow; was called DUAL which matches block 25, 30/32 and older 40/42
		CAN(0x400), // Right eyebrow
		T_L_CFG(0x800), // Right eyebrow

		// AOA Indexers
		AOAAbove(0x1000), AOAOn(0x2000), AOABelow(0x4000),

		// Refuel/NWS
		RefuelRDY(0x8000), RefuelAR(0x10000), RefuelDSC(0x20000),

		// Caution Lights
		FltControlSys(0x40000), LEFlaps(0x80000), EngineFault(0x100000), Overheat(
				0x200000), FuelLow(0x400000), Avionics(0x800000), RadarAlt(
				0x1000000), IFF(0x2000000), ECM(0x4000000), Hook(0x8000000), NWSFail(
				0x10000000), CabinPress(0x20000000),

		AutoPilotOn(0x40000000), // TRUE if is AP on. NB: This is not a lamp bit!
		TFR_STBY(0x80000000), // MISC panel; lower half of split face TFR lamp

		// Used with the MAL/IND light code to light up "everything"
		// please update this if you add/change bits!
		AllLampBitsOn(0xBFFFFFEF);
		
		private final int MASK;
		private LightBits(int m) {
			MASK = m;
		}
		
		public int getMask(){
			return this.MASK;
		}
	}

	public enum LightBits2{
	    // Threat Warning Prime
	    HandOff   (0x1),
	    Launch    (0x2),
	    PriMode   (0x4),
	    Naval     (0x8),
	    Unk       (0x10),
	    TgtSep    (0x20),

		// EWS
		Go		  (0x40),		// On and operating normally
		NoGo      (0x80),     // On but malfunction present
		Degr      (0x100),    // Status message: AUTO DEGR
		Rdy       (0x200),    // Status message: DISPENSE RDY
		ChaffLo   (0x400),    // Bingo chaff quantity reached
		FlareLo   (0x800),    // Bingo flare quantity reached

	    // Aux Threat Warning
	    AuxSrch   (0x1000),
	    AuxAct    (0x2000),
	    AuxLow    (0x4000),
	    AuxPwr    (0x8000),

	    // ECM
	    EcmPwr    (0x10000),
	    EcmFail   (0x20000),

	    // Caution Lights
	    FwdFuelLow   (0x40000),
	    AftFuelLow   (0x80000),

	    EPUOn        (0x100000),  // EPU panel; run light
	    JFSOn        (0x200000),  // Eng Jet Start panel; run light

	    // Caution panel
	    SEC            (0x400000),
	    OXY_LOW        (0x800000),
	    PROBEHEAT      (0x1000000),
	    SEAT_ARM       (0x2000000),
	    BUC            (0x4000000),
	    FUEL_OIL_HOT   (0x8000000),
	    ANTI_SKID      (0x10000000),

	    TFR_ENGAGED    (0x20000000),  // MISC panel; upper half of split face TFR lamp
	    GEARHANDLE     (0x40000000),  // Lamp in gear handle lights on fault or gear in motion
	    ENGINE         (0x80000000),  // Lower half of right eyebrow ENG FIRE/ENGINE lamp

	        // Used with the MAL/IND light code to light up "everything"
	        // please update this if you add/change bits!
		AllLampBits2On   (0xFFFFF03F),
		AllLampBits2OnExceptCarapace   (AllLampBits2On.getMask() ^ HandOff.getMask() ^ Launch.getMask() ^ PriMode.getMask() ^ Naval.getMask() ^ Unk.getMask() ^ TgtSep.getMask() ^ AuxSrch.getMask() ^ AuxAct.getMask() ^ AuxLow.getMask() ^ AuxPwr.getMask());

		private final int MASK;
		private LightBits2(int m){
	    	MASK=m;
	    }
		
		public int getMask(){
			return this.MASK;
		}
	};

	public enum LightBits3{
		
	    // Elec panel
	    FlcsPmg   (0x1),
	    MainGen   (0x2),
	    StbyGen   (0x4),
	    EpuGen    (0x8),
	    EpuPmg    (0x10),
	    ToFlcs    (0x20),
	    FlcsRly   (0x40),
	    BatFail   (0x80),

	    // EPU panel
	    Hydrazine   (0x100),
	    Air         (0x200),

	    // Caution panel
	    Elec_Fault   (0x400),
	    Lef_Fault    (0x800),

		OnGround	    (0x1000),   // weight-on-wheels
	    FlcsBitRun      (0x2000),   // FLT CONTROL panel RUN light (used to be Multi-engine fire light)
	    FlcsBitFail     (0x4000),   // FLT CONTROL panel FAIL light (used to be Lock light Cue; non-F-16)
	    DbuWarn         (0x8000),   // Right eyebrow DBU ON cell; was Shoot light cue; non-F16
	    NoseGearDown    (0x10000),  // Landing gear panel; on means down and locked
	    LeftGearDown    (0x20000),  // Landing gear panel; on means down and locked
	    RightGearDown   (0x40000),  // Landing gear panel; on means down and locked
		ParkBrakeOn     (0x100000), // Parking brake engaged; NOTE: not a lamp bit
	    Power_Off       (0x200000), // Set if there is no electrical power.  NB: not a lamp bit

		// Caution panel
		cadc	  (0x400000),
			
		// Left Aux console
		SpeedBrake   (0x800000),  // True if speed brake is in anything other than stowed position

	    // Threat Warning Prime - additional bits
		SysTest    (0x1000000),

		// Master Caution WILL come up (actual lightBit has 3sec delay like in RL),
		// usable for cockpit builders with RL equipment which has a delay on its own.
		// Will be set to false again as soon as the MasterCaution bit is set.
		MCAnnounced   (0x2000000),

		//MLGWOW is only for AFM , it means WOW switches on MLG are triggered => FLCS switches to WOWPitchRockGain
		MLGWOW   (0x4000000),
		NLGWOW   (0x8000000),

		ATF_Not_Engaged   (0x10000000),
			
		// Free bits in LightBits3		
		//0x20000000,
		//0x40000000,
		//0x80000000,

		// Used with the MAL/IND light code to light up "everything"
	    // please update this if you add/change bits!
		AllLampBits3On   (0x1147EFFF),
		AllLampBits3OnExceptCarapace   (AllLampBits3On.getMask() ^ SysTest.getMask());
	        
	    private final int MASK;
		private LightBits3(int m){
		   	MASK=m;
		}	
		public int getMask(){
			return this.MASK;
		}	
	};

	public enum HsiBits{
		
	    ToTrue          (0x01),    // HSI_FLAG_TO_TRUE =  (1, TO
	    IlsWarning      (0x02),    // HSI_FLAG_ILS_WARN
	    CourseWarning   (0x04),    // HSI_FLAG_CRS_WARN
	    Init            (0x08),    // HSI_FLAG_INIT
	    TotalFlags      (0x10),    // HSI_FLAG_TOTAL_FLAGS; never set
	    ADI_OFF         (0x20),    // ADI OFF Flag
	    ADI_AUX         (0x40),    // ADI AUX Flag
	    ADI_GS          (0x80),    // ADI GS FLAG
	    ADI_LOC         (0x100),   // ADI LOC FLAG
	    HSI_OFF         (0x200),   // HSI OFF Flag
	    BUP_ADI_OFF     (0x400),   // Backup ADI Off Flag
	    VVI             (0x800),   // VVI OFF Flag
	    AOA             (0x1000),  // AOA OFF Flag
	    AVTR            (0x2000),  // AVTR Light
		OuterMarker     (0x4000),  // MARKER beacon light for outer marker
		MiddleMarker    (0x8000),  // MARKER beacon light for middle marker
		FromTrue        (0x10000), // HSI_FLAG_TO_TRUE == 2, FROM

		Flying		    (0x80000000), // true if player is attached to an aircraft (i.e. not in UI state).  NOTE: Not a lamp bit

		// Used with the MAL/IND light code to light up "everything"
	    // please update this is you add/change bits!
	    AllLampHsiBitsOn   (0xE000);
	        
	    private final int MASK;
		private HsiBits(int m){
		   	MASK=m;
		}	
		public int getMask(){
			return this.MASK;
		}    
	};
	    
	// TACAN
	public enum TacanSources{
		UFC(0),
		AUX(1),
		NUMBER_OF_SOURCES(2);
		
		private final int ORDINAL;
		private TacanSources(int o){
			ORDINAL = 0;
		}
		public int getNumber(){
			return ORDINAL;
		}
	};

	public enum TacanBits{
		band(0x01),   // true in this bit position if band is X
		mode(0x02);   // true in this bit position if domain is air to air
		
		private final int MASK;
		private TacanBits(int m){
			MASK = m;
		}	
		public int getMask(){
			return this.MASK;
		}  
	};

	// ALTIMETER
	enum AltBits{
		CalType(0x01),	// true if calibration in inches of Mercury (Hg), false if in hectoPascal (hPa)
		PneuFlag(0x02);	// true if PNEU flag is visible
		private final int MASK;
		private AltBits(int m){
			MASK = m;
		}	
		public int getMask(){
			return this.MASK;
		} 
	};

	// POWER
	enum PowerBits{
		BusPowerBattery      (0x01),	// true if at least the battery bus is powered
		BusPowerEmergency    (0x02),	// true if at least the emergency bus is powered
		BusPowerEssential    (0x04),	// true if at least the essential bus is powered
		BusPowerNonEssential (0x08),	// true if at least the non-essential bus is powered
		MainGenerator        (0x10),	// true if the main generator is online
		StandbyGenerator     (0x20),	// true if the standby generator is online
		JetFuelStarter       (0x40);	// true if JFS is running, can be used for magswitch
		private final int MASK;
		private PowerBits(int m){
			MASK = m;
		}	
		public int getMask(){
			return this.MASK;
		} 	
	};

	// BLINKING LIGHTS - only indicating *IF* a lamp is blinking, not implementing the actual on/off/blinking pattern logic!
	enum BlinkBits{
		// currently working
		OuterMarker  (0x01),	// defined in HsiBits    - slow flashing for outer marker
		MiddleMarker (0x02),	// defined in HsiBits    - fast flashing for middle marker
		PROBEHEAT    (0x04),	// defined in LightBits2 - probeheat system is tested
		AuxSrch      (0x08),	// defined in LightBits2 - search function in NOT activated and a search radar is painting ownship
		Launch       (0x10),	// defined in LightBits2 - missile is fired at ownship
		PriMode      (0x20),	// defined in LightBits2 - priority mode is enabled but more than 5 threat emitters are detected
		Unk          (0x40),	// defined in LightBits2 - unknown is not active but EWS detects unknown radar

		// not working yet, defined for future use
		Elec_Fault   (0x80),	// defined in LightBits3 - non-resetting fault
		OXY_BROW     (0x100),	// defined in LightBits  - monitor fault during Obogs
		EPUOn        (0x200),	// defined in LightBits3 - abnormal EPU operation
		JFSOn_Slow   (0x400),	// defined in LightBits3 - slow blinking: non-critical failure
		JFSOn_Fast   (0x800);	// defined in LightBits3 - fast blinking: critical failure

		private final int MASK;
		private BlinkBits(int m){
			MASK = m;
		}	
		public int getMask(){
			return this.MASK;
		} 
	};

	// CMDS mode state
	enum CmdsModes{
		CmdsOFF,
		CmdsSTBY,
		CmdsMAN,
		CmdsSEMI,
		CmdsAUTO,
		CmdsBYP;
	};

	// HSI/eHSI mode state
	enum NavModes {
		ILS_TACAN,
		TACAN, 
		NAV,
		ILS_NAV;
	};

	// human pilot state
	enum FlyStates
	{
		IN_UI   , // UI      - in the UI
		LOADING , // UI>3D   - loading the sim data
		WAITING , // UI>3D   - waiting for other players
		FLYING  , // 3D      - flying
		DEAD    , // 3D>Dead - dead, waiting to respawn
		UNKNOWN	; // ???
	};
}
