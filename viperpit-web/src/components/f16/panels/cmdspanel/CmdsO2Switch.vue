<template>
  <switch-group
    id="CMDS: O2 Switch"
    description="CMDS: O2 Switch - Power ON"
    label="O2"
    type="switch"
  >
    <control
      id="cmdso2switchpoweron"
      description="CMDS: O2 Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdso2switchpoweroff"
      description="CMDS: O2 Switch - Power OFF"
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
  name: "CmdsO2Switch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
