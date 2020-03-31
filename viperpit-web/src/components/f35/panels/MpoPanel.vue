<template>
  <v-card outlined>
    <v-card-title>MPO PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="MPO: MANUAL PITCH Switch"
            description="MPO: MANUAL PITCH Switch - Hold"
            label="MANUAL PITCH"
            type="button"
          >
            <control
              id="mpoManualPitchSwitchHold"
              description="MPO: MANUAL PITCH Switch - Hold"
              label="PUSH"
              type="button"
              role="none"
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
  name: "MpoPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
