<template>
  <switch-group
    id="FLT: ALT FLAPS Switch"
    description="FLT: ALT FLAPS Switch - EXTEND"
    label="ALT FLAPS"
    type="switch"
  >
    <control
      id="fltaltflapsswitchextend"
      description="FLT: ALT FLAPS Switch - EXTEND"
      label="EXTEND"
      type="switch"
      role="none"
    />
    <control
      id="fltaltflapsswitchnorm"
      description="FLT: ALT FLAPS Switch - NORM"
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
  name: "FltAltFlapsSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
