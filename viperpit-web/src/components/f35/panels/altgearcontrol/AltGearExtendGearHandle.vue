<template>
  <button-group
    id="ALT GEAR: Extend Gear Handle"
    description="ALT GEAR: Extend Gear Handle - Push"
    type="button"
  >
    <control
      id="altGearExtendGearHandlePush"
      description="ALT GEAR: Extend Gear Handle - Push"
      label="Extend Gear"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "AltGearExtendGearHandle",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
