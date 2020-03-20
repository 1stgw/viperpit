<template>
  <button-group
    id="SIM: Time Acceleration"
    description="SIM: Time Acceleration - Toggle 2x"
    label="Time Acceleration"
    type="button"
  >
    <control
      id="simTimeAccelerationToggle2x"
      description="SIM: Time Acceleration - Toggle 2x"
      label="Toggle 2x"
      type="button"
      role="none"
    />
    <control
      id="simTimeAccelerationToggle4x"
      description="SIM: Time Acceleration - Toggle 4x"
      label="Toggle 4x"
      type="button"
      role="none"
    />
    <control
      id="simTimeAccelerationStepUp"
      description="SIM: Time Acceleration - Step Up"
      label="Step Up"
      type="button"
      role="up"
    />
    <control
      id="simTimeAccelerationStepDown"
      description="SIM: Time Acceleration - Step Down"
      label="Step Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "SimTimeAcceleration",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
