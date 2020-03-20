<template>
  <button-group
    id="AUDIO2: INTERCOM Knob"
    description="AUDIO2: INTERCOM Knob - Volume Incr."
    label="INTERCOM"
    type="button"
  >
    <control
      id="audio2IntercomKnobVolumeIncr"
      description="AUDIO2: INTERCOM Knob - Volume Incr."
      label="Volume Incr."
      type="button"
      role="up"
    />
    <control
      id="audio2IntercomKnobVolumeDecr"
      description="AUDIO2: INTERCOM Knob - Volume Decr."
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
  name: "Audio2IntercomKnob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
