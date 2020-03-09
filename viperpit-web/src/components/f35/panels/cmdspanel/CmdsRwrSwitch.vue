<template>
  <switch-group
    id="CMDS: RWR Switch"
    description="CMDS: RWR Switch - ON"
    label="RWR"
    type="switch"
  >
    <control
      id="cmdsrwrswitchon"
      description="CMDS: RWR Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsrwrswitchoff"
      description="CMDS: RWR Switch - OFF"
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
  name: "CmdsRwrSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
