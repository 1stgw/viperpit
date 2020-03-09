<template>
  <button-group
    id="GEAR: HORN SILENCER Button"
    description="GEAR: HORN SILENCER Button - Push"
    type="button"
  >
    <control
      id="gearhornsilencerbuttonpush"
      description="GEAR: HORN SILENCER Button - Push"
      label="HORN SILENCER"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "GearHornSilencerButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
