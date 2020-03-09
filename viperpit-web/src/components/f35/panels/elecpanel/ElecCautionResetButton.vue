<template>
  <button-group
    id="ELEC: CAUTION RESET Button"
    description="ELEC: CAUTION RESET Button - Push"
    type="button"
  >
    <control
      id="eleccautionresetbuttonpush"
      description="ELEC: CAUTION RESET Button - Push"
      label="CAUTION RESET"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "ElecCautionResetButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
