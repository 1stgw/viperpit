<template>
  <v-card outlined>
    <v-card-title>{{ panelConfiguration.label }}</v-card-title>
    <div>
      <div
        v-for="controlGroupConfiguration in panelConfiguration.controlGroupConfigurations"
        :key="controlGroupConfiguration.id"
      >
        <control-group :controlGroupConfiguration="controlGroupConfiguration" />
      </div>
    </div>
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
