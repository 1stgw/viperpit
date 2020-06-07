<template>
  <div class="button-group">
    <p>{{ controlGroupConfiguration.label }}</p>
    <v-btn-toggle v-model="getSelected.id" :value="getSelected.id">
      <v-btn
        v-for="controlConfiguration in controlGroupConfiguration.controlConfigurations"
        :key="controlConfiguration.id"
        :value="controlConfiguration.id"
        @click="toggleState(controlConfiguration.id)"
        outlined
        color="light-green"
      >
        <div v-if="controlConfiguration.role === 'up'">
          <v-icon>mdi-menu-up</v-icon>
        </div>
        <div v-else-if="controlConfiguration.role === 'down'">
          <v-icon>mdi-menu-down</v-icon>
        </div>
        <div v-else-if="controlConfiguration.role === 'increase'">
          <v-icon>mdi-plus</v-icon>
        </div>
        <div v-else-if="controlConfiguration.role === 'decrease'">
          <v-icon>mdi-minus</v-icon>
        </div>
        <div v-else-if="controlConfiguration.role === 'left'">
          <v-icon>mdi-menu-left</v-icon>
        </div>
        <div v-else-if="controlConfiguration.role === 'right'">
          <v-icon>mdi-menu-right</v-icon>
        </div>
        <div v-else>{{ controlConfiguration.label }}</div>
      </v-btn>
    </v-btn-toggle>
  </div>
</template>

<script>
import { mapActions } from "vuex";

export default {
  name: "ButtonGroup",
  props: {
    controlGroupConfiguration: {
      type: Object,
      required: true
    }
  },
  computed: {
    getSelected() {
      return this.$store.getters.getControlConfigurationWithActiveState(
        this.controlGroupConfiguration
      );
    }
  },
  methods: {
    ...mapActions(["toggleState"])
  }
};
</script>
