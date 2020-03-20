<template>
  <button-group
    id="AUDIO1: COMM 2 Knob"
    description="AUDIO1: COMM 2 Knob - Volume Incr."
    label="COMM 2"
    type="button"
  >
    <control
      id="audio1Comm2KnobVolumeIncr"
      description="AUDIO1: COMM 2 Knob - Volume Incr."
      label="Volume Incr."
      type="button"
      role="up"
    />
    <control
      id="audio1Comm2KnobVolumeDecr"
      description="AUDIO1: COMM 2 Knob - Volume Decr."
      label="Volume Decr."
      type="button"
      role="down"
    />
    <control
      id="audio1Comm2KnobPowerOn"
      description="AUDIO1: COMM 2 Knob - Power On"
      label="Power On"
      type="button"
      role="on"
    />
    <control
      id="audio1Comm2KnobPowerOff"
      description="AUDIO1: COMM 2 Knob - Power Off"
      label="Power Off"
      type="button"
      role="off"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "Audio1Comm2Knob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
