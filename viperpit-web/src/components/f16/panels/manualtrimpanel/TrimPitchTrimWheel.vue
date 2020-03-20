<template>
  <button-group
    id="TRIM: PITCH TRIM Wheel"
    description="TRIM: PITCH TRIM Wheel - NOSE UP"
    label="PITCH TRIM"
    type="button"
  >
    <control
      id="trimPitchTrimWheelNoseUp"
      description="TRIM: PITCH TRIM Wheel - NOSE UP"
      label="NOSE UP"
      type="button"
      role="up"
    />
    <control
      id="trimPitchTrimWheelNoseDn"
      description="TRIM: PITCH TRIM Wheel - NOSE DN"
      label="NOSE DN"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TrimPitchTrimWheel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
