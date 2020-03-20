<template>
  <switch-group
    id="HUD: Brightness Switch"
    description="HUD: Brightness Switch - DAY"
    label="Brightness"
    type="switch"
  >
    <control
      id="hudBrightnessSwitchDay"
      description="HUD: Brightness Switch - DAY"
      label="DAY"
      type="switch"
      role="none"
    />
    <control
      id="hudBrightnessSwitchAutoBrt"
      description="HUD: Brightness Switch - AUTO BRT"
      label="AUTO BRT"
      type="switch"
      role="none"
    />
    <control
      id="hudBrightnessSwitchNig"
      description="HUD: Brightness Switch - NIG"
      label="NIG"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "HudBrightnessSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
