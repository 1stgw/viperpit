<template>
  <div>
    <p>{{ controlGroupConfiguration.label }}</p>
    <v-btn
      v-for="controlConfiguration in controlGroupConfiguration.controlConfigurations"
      :key="controlConfiguration.id"
      outlined
      @mousedown="startStateChange(controlConfiguration.id)"
      @mouseup="endStateChange(controlConfiguration.id)"
      @ontouchstart="startStateChange(controlConfiguration.id)"
      @ontouchend="endStateChange(controlConfiguration.id)"
    >
      <button-content :control-configuration="controlConfiguration" />
    </v-btn>
  </div>
</template>

<script>
import ButtonContent from "@/components/controls/ButtonContent";
import { mapActions } from "vuex";

export default {
  name: "ToggleButton",
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
    ...mapActions(["endStateChange", "startStateChange"])
  }
};
</script>
