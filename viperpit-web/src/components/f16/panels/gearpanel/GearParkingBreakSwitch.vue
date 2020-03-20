<template>
  <switch-group
    id="GEAR: PARKING BREAK Switch"
    description="GEAR: PARKING BREAK Switch - ON"
    label="PARKING BREAK"
    type="switch"
  >
    <control
      id="gearParkingBreakSwitchOn"
      description="GEAR: PARKING BREAK Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="gearParkingBreakSwitchOff"
      description="GEAR: PARKING BREAK Switch - OFF"
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
  name: "GearParkingBreakSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
