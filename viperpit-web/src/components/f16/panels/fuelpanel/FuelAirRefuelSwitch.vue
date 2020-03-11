<template>
  <switch-group
    id="FUEL: AIR REFUEL Switch"
    description="FUEL: AIR REFUEL Switch - OPEN"
    label="AIR REFUEL"
    type="switch"
  >
    <control
      id="fuelairrefuelswitchopen"
      description="FUEL: AIR REFUEL Switch - OPEN"
      label="OPEN"
      type="switch"
      role="on"
    />
    <control
      id="fuelairrefuelswitchclose"
      description="FUEL: AIR REFUEL Switch - CLOSE"
      label="CLOSE"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "FuelAirRefuelSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
