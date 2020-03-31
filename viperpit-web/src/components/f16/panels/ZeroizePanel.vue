<template>
  <v-card outlined>
    <v-card-title>ZEROIZE PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="ZERO: VMS Switch"
            description="ZERO: VMS Switch - ON"
            label="VMS"
            type="switch"
          >
            <control
              id="zeroVmsSwitchOn"
              description="ZERO: VMS Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="zeroVmsSwitchInhibit"
              description="ZERO: VMS Switch - INHIBIT"
              label="INHIBIT"
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
  name: "ZeroizePanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
