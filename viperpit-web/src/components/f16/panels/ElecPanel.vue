<template>
  <v-card outlined>
    <v-card-title>ELEC PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="ELEC: MAIN PWR Switch"
            description="ELEC: MAIN PWR Switch - MAIN"
            label="MAIN PWR"
            type="switch"
          >
            <control
              id="elecMainPwrSwitchMain"
              description="ELEC: MAIN PWR Switch - MAIN"
              label="MAIN"
              type="switch"
              role="on"
            />
            <control
              id="elecMainPwrSwitchBatt"
              description="ELEC: MAIN PWR Switch - BATT"
              label="BATT"
              type="switch"
              role="none"
            />
            <control
              id="elecMainPwrSwitchOff"
              description="ELEC: MAIN PWR Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <button-group
            id="ELEC: CAUTION RESET Button"
            description="ELEC: CAUTION RESET Button - Push"
            label="CAUTION RESET"
            type="button"
          >
            <control
              id="elecCautionResetButtonPush"
              description="ELEC: CAUTION RESET Button - Push"
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
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "ElecPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
