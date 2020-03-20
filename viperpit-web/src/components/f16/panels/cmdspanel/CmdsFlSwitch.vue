<template>
  <switch-group
    id="CMDS: FL Switch"
    description="CMDS: FL Switch - Power ON"
    label="FL"
    type="switch"
  >
    <control
      id="cmdsFlSwitchPowerOn"
      description="CMDS: FL Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsFlSwitchPowerOff"
      description="CMDS: FL Switch - Power OFF"
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
  name: "CmdsFlSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
