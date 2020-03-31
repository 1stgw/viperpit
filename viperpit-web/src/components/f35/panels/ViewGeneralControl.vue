<template>
  <v-card outlined>
    <v-card-title>VIEW GENERAL CONTROL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="VIEWGEN: Rotate View Up"
            description="VIEWGEN: Rotate View Up"
            label="Rotate View Up"
            type="button"
          >
            <control
              id="viewgenRotateViewUp"
              description="VIEWGEN: Rotate View Up"
              label="UP"
              type="button"
              role="up"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWGEN: Rotate View Down"
            description="VIEWGEN: Rotate View Down"
            label="Rotate View Down"
            type="button"
          >
            <control
              id="viewgenRotateViewDown"
              description="VIEWGEN: Rotate View Down"
              label="DOWN"
              type="button"
              role="down"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWGEN: Rotate View Left"
            description="VIEWGEN: Rotate View Left"
            label="Rotate View Left"
            type="button"
          >
            <control
              id="viewgenRotateViewLeft"
              description="VIEWGEN: Rotate View Left"
              label="LEFT"
              type="button"
              role="left"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="VIEWGEN: Rotate View Right"
            description="VIEWGEN: Rotate View Right"
            label="Rotate View Right"
            type="button"
          >
            <control
              id="viewgenRotateViewRight"
              description="VIEWGEN: Rotate View Right"
              label="RIGHT"
              type="button"
              role="right"
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
  name: "ViewGeneralControl",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
