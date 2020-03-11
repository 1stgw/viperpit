<template>
  <switch-group
    id="CMDS: MWS Switch"
    description="CMDS: MWS Switch - Power ON"
    label="MWS"
    type="switch"
  >
    <control
      id="cmdsmwsswitchpoweron"
      description="CMDS: MWS Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsmwsswitchpoweroff"
      description="CMDS: MWS Switch - Power OFF"
      label="Power OFF"
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
