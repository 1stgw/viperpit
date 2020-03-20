<template>
  <switch-group
    id="CMDS: O2 Switch"
    description="CMDS: O2 Switch - Power ON"
    label="O2"
    type="switch"
  >
    <control
      id="cmdsO2SwitchPowerOn"
      description="CMDS: O2 Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsO2SwitchPowerOff"
      description="CMDS: O2 Switch - Power OFF"
      label="Power OFF"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "CmdsO2Switch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
