<template>
  <switch-group
    id="UHF: FUNCTION Knob"
    description="UHF: FUNCTION Knob - OFF"
    label="FUNCTION"
    type="switch"
  >
    <control
      id="uhfFunctionKnobOff"
      description="UHF: FUNCTION Knob - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="uhfFunctionKnobMain"
      description="UHF: FUNCTION Knob - MAIN"
      label="MAIN"
      type="switch"
      role="on"
    />
    <control
      id="uhfFunctionKnobBoth"
      description="UHF: FUNCTION Knob - BOTH"
      label="BOTH"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "UhfFunctionKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
