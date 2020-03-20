<template>
  <button-group
    id="MPO: MANUAL PITCH Switch"
    description="MPO: MANUAL PITCH Switch - Hold"
    type="button"
  >
    <control
      id="mpoManualPitchSwitchHold"
      description="MPO: MANUAL PITCH Switch - Hold"
      label="MANUAL PITCH"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "MpoManualPitchSwitch",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
