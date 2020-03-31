<template>
  <v-card outlined>
    <v-card-title>FUEL QTY PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
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
        </v-col>
        <v-col>
          <switch-group
            id="QTY: EXT FUEL TRANS Switch"
            description="QTY: EXT FUEL TRANS Switch - NORM"
            label="EXT FUEL TRANS"
            type="switch"
          >
            <control
              id="qtyExtFuelTransSwitchNorm"
              description="QTY: EXT FUEL TRANS Switch - NORM"
              label="NORM"
              type="switch"
              role="on"
            />
            <control
              id="qtyExtFuelTransSwitchWingFirst"
              description="QTY: EXT FUEL TRANS Switch - WING FIRST"
              label="WING FIRST"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "FuelQtyPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
