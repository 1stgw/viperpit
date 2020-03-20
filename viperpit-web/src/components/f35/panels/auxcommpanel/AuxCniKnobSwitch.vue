<template>
  <switch-group
    id="AUX: CNI Knob Switch"
    description="AUX: CNI Knob Switch - BACKUP"
    label="CNI Knob"
    type="switch"
  >
    <control
      id="auxCniKnobSwitchBackup"
      description="AUX: CNI Knob Switch - BACKUP"
      label="BACKUP"
      type="switch"
      role="none"
    />
    <control
      id="auxCniKnobSwitchUfc"
      description="AUX: CNI Knob Switch - UFC"
      label="UFC"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "AuxCniKnobSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
