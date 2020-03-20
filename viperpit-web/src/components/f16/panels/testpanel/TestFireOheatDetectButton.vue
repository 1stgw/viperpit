<template>
  <button-group
    id="TEST: FIRE & OHEAT DETECT Button"
    description="TEST: FIRE & OHEAT DETECT Button - Hold"
    type="button"
  >
    <control
      id="testFireOheatDetectButtonHold"
      description="TEST: FIRE & OHEAT DETECT Button - Hold"
      label="FIRE & OHEAT DETECT"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TestFireOheatDetectButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
