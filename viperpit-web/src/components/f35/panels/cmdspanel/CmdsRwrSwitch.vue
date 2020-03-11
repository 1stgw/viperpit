<template>
  <switch-group
    id="CMDS: RWR Switch"
    description="CMDS: RWR Switch - Power ON"
    label="RWR"
    type="switch"
  >
    <control
      id="cmdsrwrswitchpoweron"
      description="CMDS: RWR Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsrwrswitchpoweroff"
      description="CMDS: RWR Switch - Power OFF"
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
  name: "CmdsRwrSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
