<template>
  <v-card outlined>
    <v-card-title>VIEW EXTERNAL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="VIEWEXT: Orbit Camera"
            description="VIEWEXT: Orbit Camera"
            label="Orbit Camera"
            type="button"
          >
            <control
              id="viewextOrbitCamera"
              description="VIEWEXT: Orbit Camera"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWEXT: Satellite Camera"
            description="VIEWEXT: Satellite Camera"
            label="Satellite Camera"
            type="button"
          >
            <control
              id="viewextSatelliteCamera"
              description="VIEWEXT: Satellite Camera"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWEXT: Flyby Camera"
            description="VIEWEXT: Flyby Camera"
            label="Flyby Camera"
            type="button"
          >
            <control
              id="viewextFlybyCamera"
              description="VIEWEXT: Flyby Camera"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWEXT: Chase Camera"
            description="VIEWEXT: Chase Camera"
            label="Chase Camera"
            type="button"
          >
            <control
              id="viewextChaseCamera"
              description="VIEWEXT: Chase Camera"
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
  name: "ViewExternal",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
