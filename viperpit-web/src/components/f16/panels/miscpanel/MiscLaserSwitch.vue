<template>
  <switch-group
    id="MISC: LASER Switch"
    description="MISC: LASER Switch - ARM"
    label="LASER"
    type="switch"
  >
    <control
      id="miscLaserSwitchArm"
      description="MISC: LASER Switch - ARM"
      label="ARM"
      type="switch"
      role="none"
    />
    <control
      id="miscLaserSwitchOff"
      description="MISC: LASER Switch - OFF"
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
  name: "MiscLaserSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
