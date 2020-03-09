<template>
  <switch-group
    id="CMDS: O2 Switch"
    description="CMDS: O2 Switch - ON"
    label="O2"
    type="switch"
  >
    <control
      id="cmdso2switchon"
      description="CMDS: O2 Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdso2switchoff"
      description="CMDS: O2 Switch - OFF"
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
  name: "CmdsO2Switch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
