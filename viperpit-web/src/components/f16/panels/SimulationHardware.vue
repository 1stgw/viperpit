<template>
  <div class="card card-default">
    <div class="card-heading">SIMULATION & HARDWARE</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
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
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group id="SIM: Chat" description="SIM: Chat" type="button">
              <control
                id="simChat"
                description="SIM: Chat"
                label="Chat"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="SIM: Toggle Exit Sim Menu"
              description="SIM: Toggle Exit Sim Menu"
              type="button"
            >
              <control
                id="simToggleExitSimMenu"
                description="SIM: Toggle Exit Sim Menu"
                label="Toggle Exit Sim Menu"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
      </div>
    </div>
  </div>
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
