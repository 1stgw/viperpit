<template>
  <switch-group
    id="INSTR: MODE Knob"
    description="INSTR: MODE Knob - ILS/TCN"
    label="MODE"
    type="switch"
  >
    <control
      id="instrModeKnobIlsTcn"
      description="INSTR: MODE Knob - ILS/TCN"
      label="ILS/TCN"
      type="switch"
      role="none"
    />
    <control
      id="instrModeKnobTcn"
      description="INSTR: MODE Knob - TCN"
      label="TCN"
      type="switch"
      role="none"
    />
    <control
      id="instrModeKnobNav"
      description="INSTR: MODE Knob - NAV"
      label="NAV"
      type="switch"
      role="none"
    />
    <control
      id="instrModeKnobIlsNav"
      description="INSTR: MODE Knob - ILS/NAV"
      label="ILS/NAV"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "InstrModeKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
