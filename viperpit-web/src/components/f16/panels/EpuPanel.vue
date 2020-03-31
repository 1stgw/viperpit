<template>
  <v-card outlined>
    <v-card-title>EPU PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="EPU: EPU Switch"
            description="EPU: EPU Switch - ON"
            label="EPU"
            type="switch"
          >
            <control
              id="epuEpuSwitchOn"
              description="EPU: EPU Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="epuEpuSwitchNorm"
              description="EPU: EPU Switch - NORM"
              label="NORM"
              type="switch"
              role="on"
            />
            <control
              id="epuEpuSwitchOff"
              description="EPU: EPU Switch - OFF"
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
  name: "EpuPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
