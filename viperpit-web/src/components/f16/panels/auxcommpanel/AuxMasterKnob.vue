<template>
  <switch-group
    id="AUX: MASTER Knob"
    description="AUX: MASTER Knob - OFF"
    label="MASTER"
    type="switch"
  >
    <control
      id="auxmasterknoboff"
      description="AUX: MASTER Knob - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="auxmasterknobstby"
      description="AUX: MASTER Knob - STBY"
      label="STBY"
      type="switch"
      role="none"
    />
    <control
      id="auxmasterknoblow"
      description="AUX: MASTER Knob - LOW"
      label="LOW"
      type="switch"
      role="none"
    />
    <control
      id="auxmasterknobnorm"
      description="AUX: MASTER Knob - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="auxmasterknobemer"
      description="AUX: MASTER Knob - EMER"
      label="EMER"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "AuxMasterKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
