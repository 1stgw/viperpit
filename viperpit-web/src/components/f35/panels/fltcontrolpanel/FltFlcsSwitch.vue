<template>
  <button-group
    id="FLT: FLCS Switch"
    description="FLT: FLCS Switch - Hold"
    type="button"
  >
    <control
      id="fltFlcsSwitchHold"
      description="FLT: FLCS Switch - Hold"
      label="FLCS"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "FltFlcsSwitch",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
