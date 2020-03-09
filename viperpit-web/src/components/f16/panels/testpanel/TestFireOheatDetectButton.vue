<template>
  <button-group
    id="TEST: FIRE & OHEAT DETECT Button"
    description="TEST: FIRE & OHEAT DETECT Button - Hold"
    type="button"
  >
    <control
      id="testfireoheatdetectbuttonhold"
      description="TEST: FIRE & OHEAT DETECT Button - Hold"
      label="FIRE & OHEAT DETECT"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "TestFireOheatDetectButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
