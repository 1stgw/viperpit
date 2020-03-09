<template>
  <button-group
    id="ALT GEAR: Extend Alt Gear"
    description="ALT GEAR: Extend Alt Gear - Push"
    type="button"
  >
    <control
      id="altgearextendaltgearpush"
      description="ALT GEAR: Extend Alt Gear - Push"
      label="Extend Alt Gear"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "AltGearExtendAltGear",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
