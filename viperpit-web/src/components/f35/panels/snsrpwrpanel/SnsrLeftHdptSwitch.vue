<template>
  <switch-group
    id="SNSR: LEFT HDPT Switch"
    description="SNSR: LEFT HDPT Switch - ON"
    label="LEFT HDPT"
    type="switch"
  >
    <control
      id="snsrlefthdptswitchon"
      description="SNSR: LEFT HDPT Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="snsrlefthdptswitchoff"
      description="SNSR: LEFT HDPT Switch - OFF"
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
  name: "SnsrLeftHdptSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
