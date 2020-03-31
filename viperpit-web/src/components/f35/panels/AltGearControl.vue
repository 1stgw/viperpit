<template>
  <v-card outlined>
    <v-card-title>ALT GEAR CONTROL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="ALT GEAR: Extend Gear Handle"
            description="ALT GEAR: Extend Gear Handle - Push"
            label="Extend Gear"
            type="button"
          >
            <control
              id="altGearExtendGearHandlePush"
              description="ALT GEAR: Extend Gear Handle - Push"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="ALT GEAR: Reset Button"
            description="ALT GEAR: Reset Button - Push"
            label="Reset"
            type="button"
          >
            <control
              id="altGearResetButtonPush"
              description="ALT GEAR: Reset Button - Push"
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
  name: "AltGearControl",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
