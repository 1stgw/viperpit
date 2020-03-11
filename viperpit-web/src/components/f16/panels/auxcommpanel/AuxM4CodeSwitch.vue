<template>
  <switch-group
    id="AUX: M-4 CODE Switch"
    description="AUX: M-4 CODE Switch - ZERO"
    label="M-4 CODE"
    type="switch"
  >
    <control
      id="auxm4codeswitchzero"
      description="AUX: M-4 CODE Switch - ZERO"
      label="ZERO"
      type="switch"
      role="none"
    />
    <control
      id="auxm4codeswitchhold"
      description="AUX: M-4 CODE Switch - HOLD"
      label="HOLD"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "AuxM4CodeSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
