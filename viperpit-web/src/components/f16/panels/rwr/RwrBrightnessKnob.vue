<template>
  <button-group
    id="RWR: Brightness Knob"
    description="RWR: Brightness Knob - Increase"
    label="Brightness"
    type="button"
  >
    <control
      id="rwrbrightnessknobincrease"
      description="RWR: Brightness Knob - Increase"
      label="Increase"
      type="button"
      role="up"
    />
    <control
      id="rwrbrightnessknobdecrease"
      description="RWR: Brightness Knob - Decrease"
      label="Decrease"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "RwrBrightnessKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
