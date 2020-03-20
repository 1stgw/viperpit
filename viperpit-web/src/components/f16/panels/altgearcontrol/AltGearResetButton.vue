<template>
  <button-group
    id="ALT GEAR: Reset Button"
    description="ALT GEAR: Reset Button - Push"
    type="button"
  >
    <control
      id="altGearResetButtonPush"
      description="ALT GEAR: Reset Button - Push"
      label="Reset"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "AltGearResetButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
