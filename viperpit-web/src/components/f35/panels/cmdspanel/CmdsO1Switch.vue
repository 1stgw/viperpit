<template>
  <switch-group
    id="CMDS: O1 Switch"
    description="CMDS: O1 Switch - Power ON"
    label="O1"
    type="switch"
  >
    <control
      id="cmdso1switchpoweron"
      description="CMDS: O1 Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdso1switchpoweroff"
      description="CMDS: O1 Switch - Power OFF"
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
  name: "CmdsO1Switch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
