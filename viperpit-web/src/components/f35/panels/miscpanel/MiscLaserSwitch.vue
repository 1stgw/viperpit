<template>
  <switch-group
    id="MISC: LASER Switch"
    description="MISC: LASER Switch - ARM"
    label="LASER"
    type="switch"
  >
    <control
      id="misclaserswitcharm"
      description="MISC: LASER Switch - ARM"
      label="ARM"
      type="switch"
      role="none"
    />
    <control
      id="misclaserswitchoff"
      description="MISC: LASER Switch - OFF"
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
  name: "MiscLaserSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
