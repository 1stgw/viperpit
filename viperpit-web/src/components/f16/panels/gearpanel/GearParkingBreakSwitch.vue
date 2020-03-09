<template>
  <switch-group
    id="GEAR: PARKING BREAK Switch"
    description="GEAR: PARKING BREAK Switch - ON"
    label="PARKING BREAK"
    type="switch"
  >
    <control
      id="gearparkingbreakswitchon"
      description="GEAR: PARKING BREAK Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="gearparkingbreakswitchoff"
      description="GEAR: PARKING BREAK Switch - OFF"
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
  name: "GearParkingBreakSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
