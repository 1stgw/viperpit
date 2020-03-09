<template>
  <switch-group
    id="SNSR: RDR ALT Switch"
    description="SNSR: RDR ALT Switch - ON"
    label="RDR ALT"
    type="switch"
  >
    <control
      id="snsrrdraltswitchon"
      description="SNSR: RDR ALT Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="snsrrdraltswitchstdby"
      description="SNSR: RDR ALT Switch - STDBY"
      label="STDBY"
      type="switch"
      role="none"
    />
    <control
      id="snsrrdraltswitchoff"
      description="SNSR: RDR ALT Switch - OFF"
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
  name: "SnsrRdrAltSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
