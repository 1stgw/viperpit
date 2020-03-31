<template>
  <v-card outlined>
    <v-card-title>MANUAL TRIM PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="TRIM: ROLL TRIM Wheel"
            description="TRIM: ROLL TRIM Wheel - L WING DN"
            label="ROLL TRIM"
            type="button"
          >
            <control
              id="trimRollTrimWheelLWingDn"
              description="TRIM: ROLL TRIM Wheel - L WING DN"
              label="L WING DN"
              type="button"
              role="down"
            />
            <control
              id="trimRollTrimWheelRWingDn"
              description="TRIM: ROLL TRIM Wheel - R WING DN"
              label="R WING DN"
              type="button"
              role="down"
            />
          </button-group>
        </v-col>
        <v-col>
          <switch-group
            id="TRIM: TRIM/AP DISC Switch"
            description="TRIM: TRIM/AP DISC Switch - DISC"
            label="TRIM/AP DISC"
            type="switch"
          >
            <control
              id="trimTrimApDiscSwitchDisc"
              description="TRIM: TRIM/AP DISC Switch - DISC"
              label="DISC"
              type="switch"
              role="none"
            />
            <control
              id="trimTrimApDiscSwitchNorm"
              description="TRIM: TRIM/AP DISC Switch - NORM"
              label="NORM"
              type="switch"
              role="on"
            />
          </switch-group>
        </v-col>
        <v-col>
          <button-group
            id="TRIM: YAW TRIM Knob"
            description="TRIM: YAW TRIM Knob - L"
            label="YAW TRIM"
            type="button"
          >
            <control
              id="trimYawTrimKnobL"
              description="TRIM: YAW TRIM Knob - L"
              label="L"
              type="button"
              role="left"
            />
            <control
              id="trimYawTrimKnobR"
              description="TRIM: YAW TRIM Knob - R"
              label="R"
              type="button"
              role="right"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="TRIM: PITCH TRIM Wheel"
            description="TRIM: PITCH TRIM Wheel - NOSE UP"
            label="PITCH TRIM"
            type="button"
          >
            <control
              id="trimPitchTrimWheelNoseUp"
              description="TRIM: PITCH TRIM Wheel - NOSE UP"
              label="NOSE UP"
              type="button"
              role="up"
            />
            <control
              id="trimPitchTrimWheelNoseDn"
              description="TRIM: PITCH TRIM Wheel - NOSE DN"
              label="NOSE DN"
              type="button"
              role="down"
            />
          </button-group>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "ManualTrimPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
