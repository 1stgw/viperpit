<template>
  <div>
    <p>{{ controlGroupConfiguration.label }}</p>
    <v-btn
      v-for="controlConfiguration in controlGroupConfiguration.controlConfigurations"
      :key="controlConfiguration.id"
      @click="toggleState(controlConfiguration.id)"
      outlined
    >
      <button-content :controlConfiguration="controlConfiguration" />
    </v-btn>
  </div>
</template>

<script>
import ButtonContent from "@/components/controls/ButtonContent";
import { mapActions } from "vuex";

export default {
  name: "StatelessButton",
  components: {
    ButtonContent
  },
  props: {
    controlGroupConfiguration: {
      type: Object,
      required: true
    }
  },
  methods: {
    ...mapActions(["toggleState"])
  }
};
</script>
