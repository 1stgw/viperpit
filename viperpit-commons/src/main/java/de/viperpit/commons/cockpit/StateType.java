package de.viperpit.commons.cockpit;

public enum StateType {

	AIR("air"), RAMP("ramp"), TAXI("taxi");

	private final String label;

	private StateType(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public boolean isAir() {
		return AIR.equals(this);
	}

	public boolean isRamp() {
		return RAMP.equals(this);
	}

	public boolean isTaxi() {
		return TAXI.equals(this);
	}

}