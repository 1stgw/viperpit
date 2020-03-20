<template>
  <button-group
    id="GEAR: HORN SILENCER Button"
    description="GEAR: HORN SILENCER Button - Push"
    type="button"
  >
    <control
      id="gearHornSilencerButtonPush"
      description="GEAR: HORN SILENCER Button - Push"
      label="HORN SILENCER"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "GearHornSilencerButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
