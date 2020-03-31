<template>
  <v-card outlined>
    <v-card-title>AUDIO 1 PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="AUDIO1: COMM 1 Knob"
            description="AUDIO1: COMM 1 Knob - Volume Incr."
            label="COMM 1"
            type="button"
          >
            <control
              id="audio1Comm1KnobVolumeIncr"
              description="AUDIO1: COMM 1 Knob - Volume Incr."
              label="Volume Incr."
              type="button"
              role="up"
            />
            <control
              id="audio1Comm1KnobVolumeDecr"
              description="AUDIO1: COMM 1 Knob - Volume Decr."
              label="Volume Decr."
              type="button"
              role="down"
            />
            <control
              id="audio1Comm1KnobPowerOn"
              description="AUDIO1: COMM 1 Knob - Power On"
              label="Power On"
              type="button"
              role="on"
            />
            <control
              id="audio1Comm1KnobPowerOff"
              description="AUDIO1: COMM 1 Knob - Power Off"
              label="Power Off"
              type="button"
              role="off"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="AUDIO1: COMM 2 Knob"
            description="AUDIO1: COMM 2 Knob - Volume Incr."
            label="COMM 2"
            type="button"
          >
            <control
              id="audio1Comm2KnobVolumeIncr"
              description="AUDIO1: COMM 2 Knob - Volume Incr."
              label="Volume Incr."
              type="button"
              role="up"
            />
            <control
              id="audio1Comm2KnobVolumeDecr"
              description="AUDIO1: COMM 2 Knob - Volume Decr."
              label="Volume Decr."
              type="button"
              role="down"
            />
            <control
              id="audio1Comm2KnobPowerOn"
              description="AUDIO1: COMM 2 Knob - Power On"
              label="Power On"
              type="button"
              role="on"
            />
            <control
              id="audio1Comm2KnobPowerOff"
              description="AUDIO1: COMM 2 Knob - Power Off"
              label="Power Off"
              type="button"
              role="off"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="AUDIO1: MSL Knob"
            description="AUDIO1: MSL Knob - Volume Incr."
            label="MSL"
            type="button"
          >
            <control
              id="audio1MslKnobVolumeIncr"
              description="AUDIO1: MSL Knob - Volume Incr."
              label="Volume Incr."
              type="button"
              role="up"
            />
            <control
              id="audio1MslKnobVolumeDecr"
              description="AUDIO1: MSL Knob - Volume Decr."
              label="Volume Decr."
              type="button"
              role="down"
            />
          </button-group>
        </v-col>
        <v-col>
          <switch-group
            id="AUDIO1: COMM 1 Mode Knob"
            description="AUDIO1: COMM 1 Mode Knob - SQL"
            label="COMM 1 Mode"
            type="switch"
          >
            <control
              id="audio1Comm1ModeKnobSql"
              description="AUDIO1: COMM 1 Mode Knob - SQL"
              label="SQL"
              type="switch"
              role="none"
            />
            <control
              id="audio1Comm1ModeKnobGd"
              description="AUDIO1: COMM 1 Mode Knob - GD"
              label="GD"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="AUDIO1: COMM 2 Mode Knob"
            description="AUDIO1: COMM 2 Mode Knob - SQL"
            label="COMM 2 Mode"
            type="switch"
          >
            <control
              id="audio1Comm2ModeKnobSql"
              description="AUDIO1: COMM 2 Mode Knob - SQL"
              label="SQL"
              type="switch"
              role="none"
            />
            <control
              id="audio1Comm2ModeKnobGd"
              description="AUDIO1: COMM 2 Mode Knob - GD"
              label="GD"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
        <v-col>
          <button-group
            id="AUDIO1: THREAT Knob"
            description="AUDIO1: THREAT Knob - Volume Incr."
            label="THREAT"
            type="button"
          >
            <control
              id="audio1ThreatKnobVolumeIncr"
              description="AUDIO1: THREAT Knob - Volume Incr."
              label="Volume Incr."
              type="button"
              role="up"
            />
            <control
              id="audio1ThreatKnobVolumeDecr"
              description="AUDIO1: THREAT Knob - Volume Decr."
              label="Volume Decr."
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
  name: "Audio1Panel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
