<template>
  <v-card outlined>
    <v-card-title>ECM PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="ECM: OPR Switch"
            description="ECM: OPR Switch - OPR"
            label="OPR"
            type="switch"
          >
            <control
              id="ecmOprSwitchOpr"
              description="ECM: OPR Switch - OPR"
              label="OPR"
              type="switch"
              role="on"
            />
            <control
              id="ecmOprSwitchOff"
              description="ECM: OPR Switch - OFF"
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
  name: "EcmPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
