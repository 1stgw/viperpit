<template>
  <switch-group
    id="GEAR: LIGHTS Switch"
    description="GEAR: LIGHTS Switch - LANDING"
    label="LIGHTS"
    type="switch"
  >
    <control
      id="gearLightsSwitchLanding"
      description="GEAR: LIGHTS Switch - LANDING"
      label="LANDING"
      type="switch"
      role="none"
    />
    <control
      id="gearLightsSwitchOff"
      description="GEAR: LIGHTS Switch - OFF"
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
  name: "GearLightsSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
