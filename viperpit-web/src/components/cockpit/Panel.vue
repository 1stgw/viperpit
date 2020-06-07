<template>
  <v-card outlined>
    <v-card-title>{{ panelConfiguration.label }}</v-card-title>
    <div>
      <div
        v-for="controlGroupConfiguration in panelConfiguration.controlGroupConfigurations"
        :key="controlGroupConfiguration.id"
      >
        <button-group :controlGroupConfiguration="controlGroupConfiguration" />
      </div>
    </div>
  </v-card>
</template>

<script>
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "Panel",
  components: {
    ButtonGroup
  },
  props: {
    panelConfiguration: {
      type: Object,
      required: true
    }
  }
};
</script>
