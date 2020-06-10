package de.viperpit.generator;

@SuppressWarnings("all")
public class State extends AbstractJsonized {
	public Boolean getRamp() {
		return (Boolean) wrap(delegate.get("ramp"), Boolean.class);
	}

	public void setRamp(final Boolean ramp) {
		delegate.add("ramp", unWrap(ramp, Boolean.class));
	}

	public Boolean getGround() {
		return (Boolean) wrap(delegate.get("ground"), Boolean.class);
	}

	public void setGround(final Boolean ground) {
		delegate.add("ground", unWrap(ground, Boolean.class));
	}

	public Boolean getAir() {
		return (Boolean) wrap(delegate.get("air"), Boolean.class);
	}

	public void setAir(final Boolean air) {
		delegate.add("air", unWrap(air, Boolean.class));
	}
}
