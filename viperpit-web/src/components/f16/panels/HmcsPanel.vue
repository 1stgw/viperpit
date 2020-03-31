<template>
  <v-card outlined>
    <v-card-title>HMCS PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="HMCS: HMSC Knob"
            description="HMCS: HMSC Knob - Brightness Incr."
            label="HMSC"
            type="button"
          >
            <control
              id="hmcsHmscKnobBrightnessIncr"
              description="HMCS: HMSC Knob - Brightness Incr."
              label="Brightness Incr."
              type="button"
              role="up"
            />
            <control
              id="hmcsHmscKnobBrightnessDecr"
              description="HMCS: HMSC Knob - Brightness Decr."
              label="Brightness Decr."
              type="button"
              role="down"
            />
            <control
              id="hmcsHmscKnobOn"
              description="HMCS: HMSC Knob - ON"
              label="ON"
              type="button"
              role="on"
            />
            <control
              id="hmcsHmscKnobOff"
              description="HMCS: HMSC Knob - OFF"
              label="OFF"
              type="button"
              role="off"
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

export default {
  name: "HmcsPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
