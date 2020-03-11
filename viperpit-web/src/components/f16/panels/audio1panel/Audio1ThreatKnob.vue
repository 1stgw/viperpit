<template>
  <button-group
    id="AUDIO1: THREAT Knob"
    description="AUDIO1: THREAT Knob - Volume Incr."
    label="THREAT"
    type="button"
  >
    <control
      id="audio1threatknobvolumeincr"
      description="AUDIO1: THREAT Knob - Volume Incr."
      label="Volume Incr."
      type="button"
      role="up"
    />
    <control
      id="audio1threatknobvolumedecr"
      description="AUDIO1: THREAT Knob - Volume Decr."
      label="Volume Decr."
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "Audio1ThreatKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
