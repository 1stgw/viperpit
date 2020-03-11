<template>
  <switch-group
    id="FLT: DIGITAL Switch"
    description="FLT: DIGITAL Switch - BACKUP"
    label="DIGITAL"
    type="switch"
  >
    <control
      id="fltdigitalswitchbackup"
      description="FLT: DIGITAL Switch - BACKUP"
      label="BACKUP"
      type="switch"
      role="none"
    />
    <control
      id="fltdigitalswitchoff"
      description="FLT: DIGITAL Switch - OFF"
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
  name: "FltDigitalSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
