<template>
  <switch-group
    id="SNSR: RIGHT HDPT Switch"
    description="SNSR: RIGHT HDPT Switch - ON"
    label="RIGHT HDPT"
    type="switch"
  >
    <control
      id="snsrrighthdptswitchon"
      description="SNSR: RIGHT HDPT Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="snsrrighthdptswitchoff"
      description="SNSR: RIGHT HDPT Switch - OFF"
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
  name: "SnsrRightHdptSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
