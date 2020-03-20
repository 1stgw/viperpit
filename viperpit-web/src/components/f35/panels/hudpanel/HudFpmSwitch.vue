<template>
  <switch-group
    id="HUD: FPM Switch"
    description="HUD: FPM Switch - ATT/FPM"
    label="FPM"
    type="switch"
  >
    <control
      id="hudFpmSwitchAttFpm"
      description="HUD: FPM Switch - ATT/FPM"
      label="ATT/FPM"
      type="switch"
      role="none"
    />
    <control
      id="hudFpmSwitchFpm"
      description="HUD: FPM Switch - FPM"
      label="FPM"
      type="switch"
      role="none"
    />
    <control
      id="hudFpmSwitchOff"
      description="HUD: FPM Switch - OFF"
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
  name: "HudFpmSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
