<template>
  <switch-group
    id="CMDS: FL Switch"
    description="CMDS: FL Switch - ON"
    label="FL"
    type="switch"
  >
    <control
      id="cmdsflswitchon"
      description="CMDS: FL Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsflswitchoff"
      description="CMDS: FL Switch - OFF"
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
  name: "CmdsFlSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
