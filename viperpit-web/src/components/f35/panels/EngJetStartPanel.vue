<template>
  <v-card outlined>
    <v-card-title>ENG & JET START PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="ENG: JFS Switch"
            description="ENG: JFS Switch - OFF"
            label="JFS"
            type="switch"
          >
            <control
              id="engJfsSwitchOff"
              description="ENG: JFS Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
            <control
              id="engJfsSwitchStart2"
              description="ENG: JFS Switch - START 2"
              label="START 2"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="ENG: ENG CONT Switch"
            description="ENG: ENG CONT Switch - PRI"
            label="ENG CONT"
            type="switch"
          >
            <control
              id="engEngContSwitchPri"
              description="ENG: ENG CONT Switch - PRI"
              label="PRI"
              type="switch"
              role="none"
            />
            <control
              id="engEngContSwitchSec"
              description="ENG: ENG CONT Switch - SEC"
              label="SEC"
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
  name: "EngJetStartPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
