<template>
  <button-group
    id="MAIN: Altimeter Pressure Knob"
    description="MAIN: Altimeter Pressure Knob - Incr. (1°)"
    label="Altimeter Pressure"
    type="button"
  >
    <control
      id="mainaltimeterpressureknobincr1"
      description="MAIN: Altimeter Pressure Knob - Incr. (1°)"
      label="Incr. (1°)"
      type="button"
      role="none"
    />
    <control
      id="mainaltimeterpressureknobincr5"
      description="MAIN: Altimeter Pressure Knob - Incr. (5°)"
      label="Incr. (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainaltimeterpressureknobdecr5"
      description="MAIN: Altimeter Pressure Knob - Decr. (5°)"
      label="Decr. (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainaltimeterpressureknobdecr1"
      description="MAIN: Altimeter Pressure Knob - Decr. (1°)"
      label="Decr. (1°)"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "MainAltimeterPressureKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
