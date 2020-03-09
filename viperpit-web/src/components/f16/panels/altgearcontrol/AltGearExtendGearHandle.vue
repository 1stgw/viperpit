<template>
  <button-group
    id="ALT GEAR: Extend Gear Handle"
    description="ALT GEAR: Extend Gear Handle - Push"
    type="button"
  >
    <control
      id="altgearextendgearhandlepush"
      description="ALT GEAR: Extend Gear Handle - Push"
      label="Extend Gear"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "AltGearExtendGearHandle",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
