<template>
  <div>
    <p>{{ controlGroupConfiguration.label }}</p>
    <v-btn-toggle v-model="selected">
      <v-btn
        v-for="controlConfiguration in controlGroupConfiguration.controlConfigurations"
        :key="controlConfiguration.id"
        @click="toggleState(controlConfiguration.id)"
        outlined
        mandatory
        color="light-green"
      >
        <button-content :controlConfiguration="controlConfiguration" />
      </v-btn>
    </v-btn-toggle>
  </div>
</template>

<script>
import ButtonContent from "@/components/controls/ButtonContent";
import { mapActions } from "vuex";

export default {
  name: "StatelessButtonGroup",
  components: {
    ButtonContent
  },
  props: {
    controlGroupConfiguration: {
      type: Object,
      required: true
    }
  },
  computed: {
    selected: {
      get: function() {
        return null;
      },
      // eslint-disable-next-line no-unused-vars
      set: function(newValue) {}
    }
  },
  methods: {
    ...mapActions(["toggleState"])
  }
};
</script>
