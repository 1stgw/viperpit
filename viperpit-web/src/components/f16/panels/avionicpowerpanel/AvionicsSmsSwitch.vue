<template>
  <switch-group
    id="AVIONICS: SMS Switch"
    description="AVIONICS: SMS Switch - ON"
    label="SMS"
    type="switch"
  >
    <control
      id="avionicsSmsSwitchOn"
      description="AVIONICS: SMS Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="avionicsSmsSwitchOff"
      description="AVIONICS: SMS Switch - OFF"
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
  name: "AvionicsSmsSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
