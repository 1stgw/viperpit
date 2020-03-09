<template>
  <switch-group
    id="CMDS: O1 Switch"
    description="CMDS: O1 Switch - ON"
    label="O1"
    type="switch"
  >
    <control
      id="cmdso1switchon"
      description="CMDS: O1 Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdso1switchoff"
      description="CMDS: O1 Switch - OFF"
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
  name: "CmdsO1Switch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
