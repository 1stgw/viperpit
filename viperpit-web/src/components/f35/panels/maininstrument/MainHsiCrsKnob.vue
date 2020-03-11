<template>
  <button-group
    id="MAIN: HSI CRS Knob"
    description="MAIN: HSI CRS Knob - Increase (5°)"
    label="HSI CRS"
    type="button"
  >
    <control
      id="mainhsicrsknobincrease5"
      description="MAIN: HSI CRS Knob - Increase (5°)"
      label="Increase (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainhsicrsknobdecrease5"
      description="MAIN: HSI CRS Knob - Decrease (5°)"
      label="Decrease (5°)"
      type="button"
      role="none"
    />
    <control
      id="mainhsicrsknobincrease1"
      description="MAIN: HSI CRS Knob - Increase (1°)"
      label="Increase (1°)"
      type="button"
      role="none"
    />
    <control
      id="mainhsicrsknobdecrease1"
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
