<template>
  <switch-group
    id="CMDS: MWS Switch"
    description="CMDS: MWS Switch - ON"
    label="MWS"
    type="switch"
  >
    <control
      id="cmdsmwsswitchon"
      description="CMDS: MWS Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsmwsswitchoff"
      description="CMDS: MWS Switch - OFF"
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
  name: "CmdsMwsSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
