<template>
  <switch-group
    id="AUX: CNI Knob Switch"
    description="AUX: CNI Knob Switch - BACKUP"
    label="CNI Knob"
    type="switch"
  >
    <control
      id="auxcniknobswitchbackup"
      description="AUX: CNI Knob Switch - BACKUP"
      label="BACKUP"
      type="switch"
      role="none"
    />
    <control
      id="auxcniknobswitchufc"
      description="AUX: CNI Knob Switch - UFC"
      label="UFC"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "AuxCniKnobSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
