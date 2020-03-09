<template>
  <button-group
    id="CKPIT: Wheel Brakes"
    description="CKPIT: Wheel Brakes - Hold"
    type="button"
  >
    <control
      id="ckpitwheelbrakeshold"
      description="CKPIT: Wheel Brakes - Hold"
      label="Wheel Brakes"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "CkpitWheelBrakes",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
