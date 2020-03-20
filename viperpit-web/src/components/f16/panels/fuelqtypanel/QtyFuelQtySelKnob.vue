<template>
  <switch-group
    id="QTY: FUEL QTY SEL Knob"
    description="QTY: FUEL QTY SEL Knob - TEST"
    label="FUEL QTY SEL"
    type="switch"
  >
    <control
      id="qtyFuelQtySelKnobTest"
      description="QTY: FUEL QTY SEL Knob - TEST"
      label="TEST"
      type="switch"
      role="none"
    />
    <control
      id="qtyFuelQtySelKnobNorm"
      description="QTY: FUEL QTY SEL Knob - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="qtyFuelQtySelKnobRsvr"
      description="QTY: FUEL QTY SEL Knob - RSVR"
      label="RSVR"
      type="switch"
      role="none"
    />
    <control
      id="qtyFuelQtySelKnobIntWing"
      description="QTY: FUEL QTY SEL Knob - INT WING"
      label="INT WING"
      type="switch"
      role="none"
    />
    <control
      id="qtyFuelQtySelKnobExtWing"
      description="QTY: FUEL QTY SEL Knob - EXT WING"
      label="EXT WING"
      type="switch"
      role="none"
    />
    <control
      id="qtyFuelQtySelKnobExtCtr"
      description="QTY: FUEL QTY SEL Knob - EXT CTR"
      label="EXT CTR"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "QtyFuelQtySelKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
