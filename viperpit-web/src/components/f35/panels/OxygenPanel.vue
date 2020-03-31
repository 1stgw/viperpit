<template>
  <v-card outlined>
    <v-card-title>OXYGEN PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="OXY: Setting 2"
            description="OXY: Setting 2 - ON (Pilot breathing)"
            label="Setting 2"
            type="button"
          >
            <control
              id="oxySetting2OnPilotBreathing"
              description="OXY: Setting 2 - ON (Pilot breathing)"
              label="ON (Pilot breathing)"
              type="button"
              role="none"
            />
            <control
              id="oxySetting2OffPilotBreathing"
              description="OXY: Setting 2 - OFF (Pilot breathing)"
              label="OFF (Pilot breathing)"
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
  name: "OxygenPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
