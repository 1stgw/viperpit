<template>
  <switch-group
    id="AUDIO1: COMM 2 Mode Knob"
    description="AUDIO1: COMM 2 Mode Knob - SQL"
    label="COMM 2 Mode"
    type="switch"
  >
    <control
      id="audio1comm2modeknobsql"
      description="AUDIO1: COMM 2 Mode Knob - SQL"
      label="SQL"
      type="switch"
      role="none"
    />
    <control
      id="audio1comm2modeknobgd"
      description="AUDIO1: COMM 2 Mode Knob - GD"
      label="GD"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "Audio1Comm2ModeKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
