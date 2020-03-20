<template>
  <switch-group
    id="FUEL: MASTER Switch"
    description="FUEL: MASTER Switch - ON"
    label="MASTER"
    type="switch"
  >
    <control
      id="fuelMasterSwitchOn"
      description="FUEL: MASTER Switch - ON"
      label="ON"
      type="switch"
      role="on"
    />
    <control
      id="fuelMasterSwitchOff"
      description="FUEL: MASTER Switch - OFF"
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
  name: "FuelMasterSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
