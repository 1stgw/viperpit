<template>
  <v-card outlined>
    <v-card-title>TWA PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="TWA: POWER Button"
            description="TWA: POWER Button - On"
            label="POWER"
            type="button"
          >
            <control
              id="twaPowerButtonOn"
              description="TWA: POWER Button - On"
              label="On"
              type="button"
              role="on"
            />
            <control
              id="twaPowerButtonOff"
              description="TWA: POWER Button - Off"
              label="Off"
              type="button"
              role="off"
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
  name: "TwaPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
