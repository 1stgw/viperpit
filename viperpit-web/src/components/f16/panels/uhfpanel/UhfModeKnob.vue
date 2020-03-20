<template>
  <switch-group
    id="UHF: MODE Knob"
    description="UHF: MODE Knob - MNL"
    label="MODE"
    type="switch"
  >
    <control
      id="uhfModeKnobMnl"
      description="UHF: MODE Knob - MNL"
      label="MNL"
      type="switch"
      role="none"
    />
    <control
      id="uhfModeKnobPreset"
      description="UHF: MODE Knob - PRESET"
      label="PRESET"
      type="switch"
      role="none"
    />
    <control
      id="uhfModeKnobGrd"
      description="UHF: MODE Knob - GRD"
      label="GRD"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "UhfModeKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
