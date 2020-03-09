<template>
  <switch-group
    id="AVIONICS: UFC Switch"
    description="AVIONICS: UFC Switch - ON"
    label="UFC"
    type="switch"
  >
    <control
      id="avionicsufcswitchon"
      description="AVIONICS: UFC Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="avionicsufcswitchoff"
      description="AVIONICS: UFC Switch - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "AvionicsUfcSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
