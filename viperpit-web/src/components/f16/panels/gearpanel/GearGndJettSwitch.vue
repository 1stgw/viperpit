<template>
  <switch-group
    id="GEAR: GND JETT Switch"
    description="GEAR: GND JETT Switch - ENABLE"
    label="GND JETT"
    type="switch"
  >
    <control
      id="gearGndJettSwitchEnable"
      description="GEAR: GND JETT Switch - ENABLE"
      label="ENABLE"
      type="switch"
      role="on"
    />
    <control
      id="gearGndJettSwitchOff"
      description="GEAR: GND JETT Switch - OFF"
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
  name: "GearGndJettSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
