<template>
  <button-group id="SIM: Chat" description="SIM: Chat" type="button">
    <control
      id="simchat"
      description="SIM: Chat"
      label="Chat"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "SimChat",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
