<template>
  <switch-group
    id="HUD: Velocity Switch"
    description="HUD: Velocity Switch - CAS"
    label="Velocity"
    type="switch"
  >
    <control
      id="hudVelocitySwitchCas"
      description="HUD: Velocity Switch - CAS"
      label="CAS"
      type="switch"
      role="none"
    />
    <control
      id="hudVelocitySwitchTas"
      description="HUD: Velocity Switch - TAS"
      label="TAS"
      type="switch"
      role="none"
    />
    <control
      id="hudVelocitySwitchGndSpd"
      description="HUD: Velocity Switch - GND SPD"
      label="GND SPD"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "HudVelocitySwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
