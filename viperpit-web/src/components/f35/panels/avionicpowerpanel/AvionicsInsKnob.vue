<template>
  <switch-group
    id="AVIONICS: INS Knob"
    description="AVIONICS: INS Knob - OFF"
    label="INS"
    type="switch"
  >
    <control
      id="avionicsInsKnobOff"
      description="AVIONICS: INS Knob - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="avionicsInsKnobNorm"
      description="AVIONICS: INS Knob - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="avionicsInsKnobNav"
      description="AVIONICS: INS Knob - NAV"
      label="NAV"
      type="switch"
      role="none"
    />
    <control
      id="avionicsInsKnobInFltAlign"
      description="AVIONICS: INS Knob - IN FLT ALIGN"
      label="IN FLT ALIGN"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "AvionicsInsKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
