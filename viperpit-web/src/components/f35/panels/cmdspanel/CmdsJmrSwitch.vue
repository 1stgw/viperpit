<template>
  <switch-group
    id="CMDS: JMR Switch"
    description="CMDS: JMR Switch - Power ON"
    label="JMR"
    type="switch"
  >
    <control
      id="cmdsjmrswitchpoweron"
      description="CMDS: JMR Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsjmrswitchpoweroff"
      description="CMDS: JMR Switch - Power OFF"
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
  name: "CmdsJmrSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
