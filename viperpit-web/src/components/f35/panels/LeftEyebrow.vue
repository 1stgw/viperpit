<template>
  <v-card outlined>
    <v-card-title>LEFT EYEBROW</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="EYE: MASTER CAUTION Button"
            description="EYE: MASTER CAUTION Button - Push"
            label="MASTER CAUTION"
            type="button"
          >
            <control
              id="eyeMasterCautionButtonPush"
              description="EYE: MASTER CAUTION Button - Push"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="EYE: F ACK Button"
            description="EYE: F ACK Button - Push"
            label="F ACK"
            type="button"
          >
            <control
              id="eyeFAckButtonPush"
              description="EYE: F ACK Button - Push"
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
  name: "LeftEyebrow",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
