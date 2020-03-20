<template>
  <button-group id="SIM: Chat" description="SIM: Chat" type="button">
    <control
      id="simChat"
      description="SIM: Chat"
      label="Chat"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "SimChat",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
