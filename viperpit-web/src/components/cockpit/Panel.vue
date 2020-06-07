<template>
  <v-card outlined>
    <v-card-title>{{ panelConfiguration.label }}</v-card-title>
    <v-container>
      <v-row justify="center">
        <v-col
          v-for="controlGroupConfiguration in panelConfiguration.controlGroupConfigurations"
          :key="controlGroupConfiguration.id"
          cols="auto"
        >
          <control-group
            :controlGroupConfiguration="controlGroupConfiguration"
          />
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import ControlGroup from "@/components/controls/ControlGroup";

export default {
  name: "Panel",
  components: {
    ControlGroup
  },
  props: {
    panelConfiguration: {
      type: Object,
      required: true
    }
  }
};
</script>
