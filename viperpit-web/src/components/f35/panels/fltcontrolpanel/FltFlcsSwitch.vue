<template>
  <button-group
    id="FLT: FLCS Switch"
    description="FLT: FLCS Switch - Hold"
    type="button"
  >
    <control
      id="fltflcsswitchhold"
      description="FLT: FLCS Switch - Hold"
      label="FLCS"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "FltFlcsSwitch",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
