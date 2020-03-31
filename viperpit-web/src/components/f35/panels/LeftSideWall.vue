<template>
  <v-card outlined>
    <v-card-title>LEFT SIDE WALL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
            description="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
            label="SLAP Switch (ECM-PGRM # 5)"
            type="button"
          >
            <control
              id="leftWallSlapSwitchEcmPgrm5"
              description="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="LEFT WALL: CANOPY"
            description="LEFT WALL: CANOPY - Open"
            label="CANOPY"
            type="button"
          >
            <control
              id="leftWallCanopyOpen"
              description="LEFT WALL: CANOPY - Open"
              label="Open"
              type="button"
              role="none"
            />
            <control
              id="leftWallCanopyClose"
              description="LEFT WALL: CANOPY - Close"
              label="Close"
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
  name: "LeftSideWall",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
