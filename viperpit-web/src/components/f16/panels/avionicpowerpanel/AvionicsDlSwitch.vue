<template>
  <switch-group
    id="AVIONICS: DL Switch"
    description="AVIONICS: DL Switch - ON"
    label="DL"
    type="switch"
  >
    <control
      id="avionicsdlswitchon"
      description="AVIONICS: DL Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="avionicsdlswitchoff"
      description="AVIONICS: DL Switch - OFF"
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
  name: "AvionicsDlSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
