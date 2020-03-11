<template>
  <switch-group
    id="ZERO: VMS Switch"
    description="ZERO: VMS Switch - ON"
    label="VMS"
    type="switch"
  >
    <control
      id="zerovmsswitchon"
      description="ZERO: VMS Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="zerovmsswitchinhibit"
      description="ZERO: VMS Switch - INHIBIT"
      label="INHIBIT"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "ZeroVmsSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
