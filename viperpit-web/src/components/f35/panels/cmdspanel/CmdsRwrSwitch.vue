<template>
  <switch-group
    id="CMDS: RWR Switch"
    description="CMDS: RWR Switch - Power ON"
    label="RWR"
    type="switch"
  >
    <control
      id="cmdsRwrSwitchPowerOn"
      description="CMDS: RWR Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsRwrSwitchPowerOff"
      description="CMDS: RWR Switch - Power OFF"
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
  name: "CmdsRwrSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
