<template>
  <switch-group
    id="EXT: MASTER Switch"
    description="EXT: MASTER Switch - NORM"
    label="MASTER"
    type="switch"
  >
    <control
      id="extmasterswitchnorm"
      description="EXT: MASTER Switch - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="extmasterswitchoff"
      description="EXT: MASTER Switch - OFF"
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
  name: "ExtMasterSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
