<template>
  <button-group
    id="TRIM: ROLL TRIM Wheel"
    description="TRIM: ROLL TRIM Wheel - L WING DN"
    label="ROLL TRIM"
    type="button"
  >
    <control
      id="trimRollTrimWheelLWingDn"
      description="TRIM: ROLL TRIM Wheel - L WING DN"
      label="L WING DN"
      type="button"
      role="down"
    />
    <control
      id="trimRollTrimWheelRWingDn"
      description="TRIM: ROLL TRIM Wheel - R WING DN"
      label="R WING DN"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TrimRollTrimWheel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
