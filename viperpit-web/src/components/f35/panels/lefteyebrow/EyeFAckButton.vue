<template>
  <button-group
    id="EYE: F ACK Button"
    description="EYE: F ACK Button - Push"
    type="button"
  >
    <control
      id="eyefackbuttonpush"
      description="EYE: F ACK Button - Push"
      label="F ACK"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "EyeFAckButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
