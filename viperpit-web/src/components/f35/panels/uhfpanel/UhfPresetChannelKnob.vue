<template>
  <button-group
    id="UHF: PRESET CHANNEL Knob"
    description="UHF: PRESET CHANNEL Knob - Cycle Up"
    label="PRESET CHANNEL"
    type="button"
  >
    <control
      id="uhfpresetchannelknobcycleup"
      description="UHF: PRESET CHANNEL Knob - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"
    />
    <control
      id="uhfpresetchannelknobcycledown"
      description="UHF: PRESET CHANNEL Knob - Cycle Down"
      label="Cycle Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "UhfPresetChannelKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
