<template>
  <button-group
    id="SIM: Toggle Exit Sim Menu"
    description="SIM: Toggle Exit Sim Menu"
    type="button"
  >
    <control
      id="simtoggleexitsimmenu"
      description="SIM: Toggle Exit Sim Menu"
      label="Toggle Exit Sim Menu"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "SimToggleExitSimMenu",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
