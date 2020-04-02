<template>
  <v-card outlined>
    <v-card-title>AUDIO 2 PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="AUDIO2: INTERCOM Knob"
            description="AUDIO2: INTERCOM Knob - Volume Incr."
            label="INTERCOM"
            type="button"
          >
            <control
              id="audio2IntercomKnobVolumeIncr"
              description="AUDIO2: INTERCOM Knob - Volume Incr."
              label="Volume Incr."
              type="button"
              role="increase"
            />
            <control
              id="audio2IntercomKnobVolumeDecr"
              description="AUDIO2: INTERCOM Knob - Volume Decr."
              label="Volume Decr."
              type="button"
              role="decrease"
            />
          </button-group>
        </v-col>
        <v-col>
          <switch-group
            id="AUDIO2: ILS Knob"
            description="AUDIO2: ILS Knob - ON"
            label="ILS"
            type="switch"
          >
            <control
              id="audio2IlsKnobOn"
              description="AUDIO2: ILS Knob - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="audio2IlsKnobOff"
              description="AUDIO2: ILS Knob - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
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
  name: "Audio2Panel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
