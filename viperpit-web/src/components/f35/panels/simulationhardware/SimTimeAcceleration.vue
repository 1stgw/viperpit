<template>
  <button-group
    id="SIM: Time Acceleration"
    description="SIM: Time Acceleration - Toggle 2x"
    label="Time Acceleration"
    type="button"
  >
    <control
      id="simtimeaccelerationtoggle2x"
      description="SIM: Time Acceleration - Toggle 2x"
      label="Toggle 2x"
      type="button"
      role="none"
    />
    <control
      id="simtimeaccelerationtoggle4x"
      description="SIM: Time Acceleration - Toggle 4x"
      label="Toggle 4x"
      type="button"
      role="none"
    />
    <control
      id="simtimeaccelerationstepup"
      description="SIM: Time Acceleration - Step Up"
      label="Step Up"
      type="button"
      role="up"
    />
    <control
      id="simtimeaccelerationstepdown"
      description="SIM: Time Acceleration - Step Down"
      label="Step Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "SimTimeAcceleration",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
