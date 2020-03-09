<template>
  <switch-group
    id="HUD: Altitude Switch"
    description="HUD: Altitude Switch - RADAR"
    label="Altitude"
    type="switch"
  >
    <control
      id="hudaltitudeswitchradar"
      description="HUD: Altitude Switch - RADAR"
      label="RADAR"
      type="switch"
      role="none"
    />
    <control
      id="hudaltitudeswitchbaro"
      description="HUD: Altitude Switch - BARO"
      label="BARO"
      type="switch"
      role="none"
    />
    <control
      id="hudaltitudeswitchauto"
      description="HUD: Altitude Switch - AUTO"
      label="AUTO"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "HudAltitudeSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
