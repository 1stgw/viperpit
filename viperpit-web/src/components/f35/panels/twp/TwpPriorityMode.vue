<template>
  <button-group
    id="TWP: PRIORITY MODE"
    description="TWP: PRIORITY MODE - Toggle"
    type="button"
  >
    <control
      id="twpprioritymodetoggle"
      description="TWP: PRIORITY MODE - Toggle"
      label="PRIORITY MODE"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "TwpPriorityMode",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
