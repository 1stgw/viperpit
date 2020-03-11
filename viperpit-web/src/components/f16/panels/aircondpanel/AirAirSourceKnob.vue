<template>
  <switch-group
    id="AIR: AIR SOURCE Knob"
    description="AIR: AIR SOURCE Knob - OFF"
    label="AIR SOURCE"
    type="switch"
  >
    <control
      id="airairsourceknoboff"
      description="AIR: AIR SOURCE Knob - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="airairsourceknobnorm"
      description="AIR: AIR SOURCE Knob - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="airairsourceknobdump"
      description="AIR: AIR SOURCE Knob - DUMP"
      label="DUMP"
      type="switch"
      role="none"
    />
    <control
      id="airairsourceknobram"
      description="AIR: AIR SOURCE Knob - RAM"
      label="RAM"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "AirAirSourceKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
