<template>
  <switch-group
    id="AUX: M-4 CODE Switch"
    description="AUX: M-4 CODE Switch - ZERO"
    label="M-4 CODE"
    type="switch"
  >
    <control
      id="auxM4CodeSwitchZero"
      description="AUX: M-4 CODE Switch - ZERO"
      label="ZERO"
      type="switch"
      role="none"
    />
    <control
      id="auxM4CodeSwitchHold"
      description="AUX: M-4 CODE Switch - HOLD"
      label="HOLD"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "AuxM4CodeSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
