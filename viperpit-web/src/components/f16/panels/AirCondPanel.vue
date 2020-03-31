<template>
  <v-card outlined>
    <v-card-title>AIR COND PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="AIR: AIR SOURCE Knob"
            description="AIR: AIR SOURCE Knob - OFF"
            label="AIR SOURCE"
            type="switch"
          >
            <control
              id="airAirSourceKnobOff"
              description="AIR: AIR SOURCE Knob - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
            <control
              id="airAirSourceKnobNorm"
              description="AIR: AIR SOURCE Knob - NORM"
              label="NORM"
              type="switch"
              role="on"
            />
            <control
              id="airAirSourceKnobDump"
              description="AIR: AIR SOURCE Knob - DUMP"
              label="DUMP"
              type="switch"
              role="none"
            />
            <control
              id="airAirSourceKnobRam"
              description="AIR: AIR SOURCE Knob - RAM"
              label="RAM"
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
  name: "AirCondPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
