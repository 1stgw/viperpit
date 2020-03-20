<template>
  <switch-group
    id="AVIONICS: UFC Switch"
    description="AVIONICS: UFC Switch - ON"
    label="UFC"
    type="switch"
  >
    <control
      id="avionicsUfcSwitchOn"
      description="AVIONICS: UFC Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="avionicsUfcSwitchOff"
      description="AVIONICS: UFC Switch - OFF"
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
  name: "AvionicsUfcSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
