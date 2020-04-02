<template>
  <v-card outlined>
    <v-card-title>RWR</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="RWR: Brightness Knob"
            description="RWR: Brightness Knob - Increase"
            label="Brightness"
            type="button"
          >
            <control
              id="rwrBrightnessKnobIncrease"
              description="RWR: Brightness Knob - Increase"
              label="Increase"
              type="button"
              role="increase"
            />
            <control
              id="rwrBrightnessKnobDecrease"
              description="RWR: Brightness Knob - Decrease"
              label="Decrease"
              type="button"
              role="decrease"
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
  name: "Rwr",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
