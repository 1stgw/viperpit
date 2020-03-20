<template>
  <button-group
    id="MAIN: HSI CRS Knob"
    description="MAIN: HSI CRS Knob - Increase (5°)"
    label="HSI CRS"
    type="button"
  >
    <control
      id="mainHsiCrsKnobIncrease5"
      description="MAIN: HSI CRS Knob - Increase (5°)"
      label="Increase (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainHsiCrsKnobDecrease5"
      description="MAIN: HSI CRS Knob - Decrease (5°)"
      label="Decrease (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainHsiCrsKnobIncrease1"
      description="MAIN: HSI CRS Knob - Increase (1°)"
      label="Increase (1°)"
      type="button"
      role="none"
    />
    <control
      id="mainHsiCrsKnobDecrease1"
      description="MAIN: HSI CRS Knob - Decrease (1°)"
      label="Decrease (1°)"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "MainHsiCrsKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
