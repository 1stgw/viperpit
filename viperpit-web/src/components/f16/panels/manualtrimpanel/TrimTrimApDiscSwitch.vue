<template>
  <switch-group
    id="TRIM: TRIM/AP DISC Switch"
    description="TRIM: TRIM/AP DISC Switch - DISC"
    label="TRIM/AP DISC"
    type="switch"
  >
    <control
      id="trimTrimApDiscSwitchDisc"
      description="TRIM: TRIM/AP DISC Switch - DISC"
      label="DISC"
      type="switch"
      role="none"
    />
    <control
      id="trimTrimApDiscSwitchNorm"
      description="TRIM: TRIM/AP DISC Switch - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "TrimTrimApDiscSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
