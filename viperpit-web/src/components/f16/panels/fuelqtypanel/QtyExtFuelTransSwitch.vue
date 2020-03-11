<template>
  <switch-group
    id="QTY: EXT FUEL TRANS Switch"
    description="QTY: EXT FUEL TRANS Switch - NORM"
    label="EXT FUEL TRANS"
    type="switch"
  >
    <control
      id="qtyextfueltransswitchnorm"
      description="QTY: EXT FUEL TRANS Switch - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="qtyextfueltransswitchwingfirst"
      description="QTY: EXT FUEL TRANS Switch - WING FIRST"
      label="WING FIRST"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "QtyExtFuelTransSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
