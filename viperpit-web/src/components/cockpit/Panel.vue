<template>
  <v-card v-if="panelConfiguration" outlined>
    <v-container>
      <v-row justify="center">
        <v-col
          v-for="controlGroupConfiguration in panelConfiguration.controlGroupConfigurations"
          :key="controlGroupConfiguration.id"
          cols="auto"
        >
          <control-group :control-group-configuration="controlGroupConfiguration" />
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import Vue from "vue";
import ControlGroup from "@/components/controls/ControlGroup";

export default Vue.extend({
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Panel",
  components: {
    ControlGroup
  },
  props: {
    panelConfiguration: {
      type: Object,
      required: false,
      default: null
    }
  }
});
</script>
