<template>
  <v-card outlined>
    <v-card-title>VIEW INTERNAL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="VIEWINT: Padlock"
            description="VIEWINT: Padlock"
            label="Padlock"
            type="button"
          >
            <control
              id="viewintPadlock"
              description="VIEWINT: Padlock"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWINT: HUD Only"
            description="VIEWINT: HUD Only"
            label="HUD Only"
            type="button"
          >
            <control
              id="viewintHudOnly"
              description="VIEWINT: HUD Only"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWINT: Snap (3D) Cockpit"
            description="VIEWINT: Snap (3D) Cockpit"
            label="Snap (3D) Cockpit"
            type="button"
          >
            <control
              id="viewintSnap3dCockpit"
              description="VIEWINT: Snap (3D) Cockpit"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWINT: Pan (3D) Cockpit"
            description="VIEWINT: Pan (3D) Cockpit"
            label="Pan (3D) Cockpit"
            type="button"
          >
            <control
              id="viewintPan3dCockpit"
              description="VIEWINT: Pan (3D) Cockpit"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWINT: Glance Forward"
            description="VIEWINT: Glance Forward"
            label="Glance Forward"
            type="button"
          >
            <control
              id="viewintGlanceForward"
              description="VIEWINT: Glance Forward"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWINT: Glance Backward"
            description="VIEWINT: Glance Backward"
            label="Glance Backward"
            type="button"
          >
            <control
              id="viewintGlanceBackward"
              description="VIEWINT: Glance Backward"
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
  name: "ViewInternal",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
