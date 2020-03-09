<template>
  <button-group
    id="ALT GEAR: Reset Alt Gear"
    description="ALT GEAR: Reset Alt Gear - Push"
    type="button"
  >
    <control
      id="altgearresetaltgearpush"
      description="ALT GEAR: Reset Alt Gear - Push"
      label="Reset Alt Gear"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "AltGearResetAltGear",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
