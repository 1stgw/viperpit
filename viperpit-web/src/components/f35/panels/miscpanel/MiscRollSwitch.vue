<template>
  <switch-group
    id="MISC: ROLL Switch"
    description="MISC: ROLL Switch - HDG SEL"
    label="ROLL"
    type="switch"
  >
    <control
      id="miscRollSwitchHdgSel"
      description="MISC: ROLL Switch - HDG SEL"
      label="HDG SEL"
      type="switch"
      role="none"
    />
    <control
      id="miscRollSwitchAttHold"
      description="MISC: ROLL Switch - ATT HOLD"
      label="ATT HOLD"
      type="switch"
      role="none"
    />
    <control
      id="miscRollSwitchStrgSel"
      description="MISC: ROLL Switch -  STRG SEL"
      label="STRG SEL"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "MiscRollSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
