<template>
  <v-card outlined>
    <v-card-title>EXT LIGHTING PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="EXT: ANTI COLLISION Switch"
            description="EXT: ANTI COLLISION Switch - ON"
            label="ANTI COLLISION"
            type="switch"
          >
            <control
              id="extAntiCollisionSwitchOn"
              description="EXT: ANTI COLLISION Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="extAntiCollisionSwitchOff"
              description="EXT: ANTI COLLISION Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="EXT: POSITION Switch"
            description="EXT: POSITION Switch - FLASH"
            label="POSITION"
            type="switch"
          >
            <control
              id="extPositionSwitchFlash"
              description="EXT: POSITION Switch - FLASH"
              label="FLASH"
              type="switch"
              role="none"
            />
            <control
              id="extPositionSwitchSteady"
              description="EXT: POSITION Switch - STEADY"
              label="STEADY"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="EXT: WING/TAIL Switch"
            description="EXT: WING/TAIL Switch - BRT"
            label="WING/TAIL"
            type="switch"
          >
            <control
              id="extWingTailSwitchBrt"
              description="EXT: WING/TAIL Switch - BRT"
              label="BRT"
              type="switch"
              role="none"
            />
            <control
              id="extWingTailSwitchOff"
              description="EXT: WING/TAIL Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="EXT: MASTER Switch"
            description="EXT: MASTER Switch - NORM"
            label="MASTER"
            type="switch"
          >
            <control
              id="extMasterSwitchNorm"
              description="EXT: MASTER Switch - NORM"
              label="NORM"
              type="switch"
              role="on"
            />
            <control
              id="extMasterSwitchOff"
              description="EXT: MASTER Switch - OFF"
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
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "ExtLightingPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
