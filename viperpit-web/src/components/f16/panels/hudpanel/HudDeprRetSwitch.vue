<template>
  <switch-group
    id="HUD: DEPR RET Switch"
    description="HUD: DEPR RET Switch - STBY"
    label="DEPR RET"
    type="switch"
  >
    <control
      id="huddeprretswitchstby"
      description="HUD: DEPR RET Switch - STBY"
      label="STBY"
      type="switch"
      role="none"
    />
    <control
      id="huddeprretswitchpri"
      description="HUD: DEPR RET Switch - PRI"
      label="PRI"
      type="switch"
      role="none"
    />
    <control
      id="huddeprretswitchoff"
      description="HUD: DEPR RET Switch - OFF"
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
  name: "HudDeprRetSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
