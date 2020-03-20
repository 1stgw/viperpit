<template>
  <switch-group
    id="AUDIO2: ILS Knob"
    description="AUDIO2: ILS Knob - ON"
    label="ILS"
    type="switch"
  >
    <control
      id="audio2IlsKnobOn"
      description="AUDIO2: ILS Knob - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="audio2IlsKnobOff"
      description="AUDIO2: ILS Knob - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "Audio2IlsKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
