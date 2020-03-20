<template>
  <switch-group
    id="HUD: DEPR RET Switch"
    description="HUD: DEPR RET Switch - STBY"
    label="DEPR RET"
    type="switch"
  >
    <control
      id="hudDeprRetSwitchStby"
      description="HUD: DEPR RET Switch - STBY"
      label="STBY"
      type="switch"
      role="none"
    />
    <control
      id="hudDeprRetSwitchPri"
      description="HUD: DEPR RET Switch - PRI"
      label="PRI"
      type="switch"
      role="none"
    />
    <control
      id="hudDeprRetSwitchOff"
      description="HUD: DEPR RET Switch - OFF"
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
  name: "HudDeprRetSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
