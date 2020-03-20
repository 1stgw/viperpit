<template>
  <switch-group
    id="FUEL: ENG FEED Knob"
    description="FUEL: ENG FEED Knob - OFF"
    label="ENG FEED"
    type="switch"
  >
    <control
      id="fuelEngFeedKnobOff"
      description="FUEL: ENG FEED Knob - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="fuelEngFeedKnobNorm"
      description="FUEL: ENG FEED Knob - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="fuelEngFeedKnobAft"
      description="FUEL: ENG FEED Knob - AFT"
      label="AFT"
      type="switch"
      role="none"
    />
    <control
      id="fuelEngFeedKnobFwd"
      description="FUEL: ENG FEED Knob - FWD"
      label="FWD"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "FuelEngFeedKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
