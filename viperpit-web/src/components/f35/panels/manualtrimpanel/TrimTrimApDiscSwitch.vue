<template>
  <switch-group
    id="TRIM: TRIM/AP DISC Switch"
    description="TRIM: TRIM/AP DISC Switch - DISC"
    label="TRIM/AP DISC"
    type="switch"
  >
    <control
      id="trimtrimapdiscswitchdisc"
      description="TRIM: TRIM/AP DISC Switch - DISC"
      label="DISC"
      type="switch"
      role="none"
    />
    <control
      id="trimtrimapdiscswitchnorm"
      description="TRIM: TRIM/AP DISC Switch - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "TrimTrimApDiscSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
