package de.viperpit.agent.data.jna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * JNA Wrapper for library <b>IVibeData</b><br>
 * This file was autogenerated by
 * <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that
 * <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a
 * few opensource projects.</a>.<br>
 * For help, please visit
 * <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> ,
 * <a href="http://rococoa.dev.java.net/">Rococoa</a>, or
 * <a href="http://jna.dev.java.net/">JNA</a>.
 */
public interface IVibeDataLibrary extends Library {
	/** *** "FalconIntellivibeSharedMemoryArea" *** */
	public static class IntellivibeData extends Structure {
		/** how many AA missiles fired. */
		public byte AAMissileFired;
		/** how many maveric/rockets fired */
		public byte AGMissileFired;
		/** how many bombs dropped */
		public byte BombDropped;
		/** how many flares dropped */
		public byte FlareDropped;
		/** how many chaff dropped */
		public byte ChaffDropped;
		/** how many bullets shot */
		public byte BulletsFired;
		/** Collisions */
		public int CollisionCounter;
		/** gun is firing */
		public byte IsFiringGun;
		/** Ending the flight from 3d */
		public byte IsEndFlight;
		/** we've ejected */
		public byte IsEjecting;
		/** In 3D? */
		public byte In3D;
		/** sim paused? */
		public byte IsPaused;
		/** sim frozen? */
		public byte IsFrozen;
		/** are G limits being exceeded? */
		public byte IsOverG;
		/** are we on the ground */
		public byte IsOnGround;
		/** Did we exit Falcon? */
		public byte IsExitGame;
		/** what gforce we are feeling */
		public float Gforce;
		/** where the eye is in relationship to the plane */
		public float eyex;
		/** where the eye is in relationship to the plane */
		public float eyey;
		/** where the eye is in relationship to the plane */
		public float eyez;
		/** 1 to 8 depending on quadrant. Make this into an enum later */
		public int lastdamage;
		/** how big the hit was. */
		public float damageforce;
		public int whendamage;

		public IntellivibeData() {
			super();
		}

		protected List<String> getFieldOrder() {
			return Arrays.asList("AAMissileFired", "AGMissileFired", "BombDropped", "FlareDropped", "ChaffDropped",
					"BulletsFired", "CollisionCounter", "IsFiringGun", "IsEndFlight", "IsEjecting", "In3D", "IsPaused",
					"IsFrozen", "IsOverG", "IsOnGround", "IsExitGame", "Gforce", "eyex", "eyey", "eyez", "lastdamage",
					"damageforce", "whendamage");
		}

		public IntellivibeData(Pointer peer) {
			super(peer);
		}

		public static class ByReference extends IntellivibeData implements Structure.ByReference {

		};

		public static class ByValue extends IntellivibeData implements Structure.ByValue {

		};
	};
}
