<template>
  <switch-group
    id="CMDS: JETT Switch"
    description="CMDS: JETT Switch - ON"
    label="JETT"
    type="switch"
  >
    <control
      id="cmdsjettswitchon"
      description="CMDS: JETT Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="cmdsjettswitchoff"
      description="CMDS: JETT Switch - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "CmdsJettSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
