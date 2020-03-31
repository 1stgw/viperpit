<template>
  <v-card outlined>
    <v-card-title>SIMULATION & HARDWARE</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="SIM: Time Acceleration"
            description="SIM: Time Acceleration - Toggle 2x"
            label="Time Acceleration"
            type="button"
          >
            <control
              id="simTimeAccelerationToggle2x"
              description="SIM: Time Acceleration - Toggle 2x"
              label="Toggle 2x"
              type="button"
              role="none"
            />
            <control
              id="simTimeAccelerationToggle4x"
              description="SIM: Time Acceleration - Toggle 4x"
              label="Toggle 4x"
              type="button"
              role="none"
            />
            <control
              id="simTimeAccelerationStepUp"
              description="SIM: Time Acceleration - Step Up"
              label="Step Up"
              type="button"
              role="up"
            />
            <control
              id="simTimeAccelerationStepDown"
              description="SIM: Time Acceleration - Step Down"
              label="Step Down"
              type="button"
              role="down"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="SIM: Chat"
            description="SIM: Chat"
            label="Chat"
            type="button"
          >
            <control
              id="simChat"
              description="SIM: Chat"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="SIM: Toggle Exit Sim Menu"
            description="SIM: Toggle Exit Sim Menu"
            label="Toggle Exit Sim Menu"
            type="button"
          >
            <control
              id="simToggleExitSimMenu"
              description="SIM: Toggle Exit Sim Menu"
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
  name: "SimulationHardware",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
