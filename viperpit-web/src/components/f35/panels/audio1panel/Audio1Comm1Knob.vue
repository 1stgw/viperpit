<template>
  <button-group
    id="AUDIO1: COMM 1 Knob"
    description="AUDIO1: COMM 1 Knob - Volume Incr."
    label="COMM 1"
    type="button"
  >
    <control
      id="audio1Comm1KnobVolumeIncr"
      description="AUDIO1: COMM 1 Knob - Volume Incr."
      label="Volume Incr."
      type="button"
      role="up"
    />
    <control
      id="audio1Comm1KnobVolumeDecr"
      description="AUDIO1: COMM 1 Knob - Volume Decr."
      label="Volume Decr."
      type="button"
      role="down"
    />
    <control
      id="audio1Comm1KnobPowerOn"
      description="AUDIO1: COMM 1 Knob - Power On"
      label="Power On"
      type="button"
      role="on"
    />
    <control
      id="audio1Comm1KnobPowerOff"
      description="AUDIO1: COMM 1 Knob - Power Off"
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
  name: "Audio1Comm1Knob",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
