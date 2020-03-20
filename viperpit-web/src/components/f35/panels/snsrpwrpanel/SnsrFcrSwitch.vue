<template>
  <switch-group
    id="SNSR: FCR Switch"
    description="SNSR: FCR Switch - ON"
    label="FCR"
    type="switch"
  >
    <control
      id="snsrFcrSwitchOn"
      description="SNSR: FCR Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="snsrFcrSwitchOff"
      description="SNSR: FCR Switch - OFF"
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
  name: "SnsrFcrSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
