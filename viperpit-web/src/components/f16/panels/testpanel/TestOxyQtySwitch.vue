<template>
  <button-group
    id="TEST: OXY QTY Switch"
    description="TEST: OXY QTY Switch - Hold"
    type="button"
  >
    <control
      id="testOxyQtySwitchHold"
      description="TEST: OXY QTY Switch - Hold"
      label="OXY QTY"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TestOxyQtySwitch",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
