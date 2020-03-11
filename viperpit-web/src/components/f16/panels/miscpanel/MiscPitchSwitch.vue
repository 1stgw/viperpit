<template>
  <switch-group
    id="MISC: PITCH Switch"
    description="MISC: PITCH Switch - ALT HOLD"
    label="PITCH"
    type="switch"
  >
    <control
      id="miscpitchswitchalthold"
      description="MISC: PITCH Switch - ALT HOLD"
      label="ALT HOLD"
      type="switch"
      role="none"
    />
    <control
      id="miscpitchswitchapoff"
      description="MISC: PITCH Switch - A/P OFF"
      label="A/P OFF"
      type="switch"
      role="off"
    />
    <control
      id="miscpitchswitchatthold"
      description="MISC: PITCH Switch - ATT HOLD"
      label="ATT HOLD"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "MiscPitchSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
