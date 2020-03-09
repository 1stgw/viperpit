<template>
  <button-group
    id="SEAT: Safety Lever"
    description="SEAT: Safety Lever - Armed"
    label="Safety Lever"
    type="button"
  >
    <control
      id="seatsafetyleverarmed"
      description="SEAT: Safety Lever - Armed"
      label="Armed"
      type="button"
      role="none"
    />
    <control
      id="seatsafetyleverlocked"
      description="SEAT: Safety Lever - Locked"
      label="Locked"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "SeatSafetyLever",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
