<template>
  <div>
    <p>{{ controlGroupConfiguration.label }}</p>
    <v-btn-toggle v-model="selected" :class="orientation" dense>
      <v-btn
        v-for="controlConfiguration in controlGroupConfiguration.controlConfigurations"
        :key="controlConfiguration.id"
        :value="controlConfiguration.id"
        outlined
        @click="toggleState(controlConfiguration.id)"
      >
        <button-content :control-configuration="controlConfiguration" />
      </v-btn>
    </v-btn-toggle>
  </div>
</template>

<style scoped>
.v-btn-toggle.vertical > .v-btn.v-btn:first-child {
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
  border-bottom-left-radius: 0px;
  border-bottom-right-radius: 0px;
}

.v-btn-toggle.vertical > .v-btn {
  border-bottom-width: 0px;
}

.v-btn-toggle.vertical > .v-btn.v-btn:not(:first-child) {
  border-radius: 0;
  border-left-width: 1px;
  border-right-width: 1px;
}

.v-btn-toggle.vertical > .v-btn.v-btn:last-child {
  border-bottom-width: 1px;
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  border-bottom-left-radius: 4px;
  border-bottom-right-radius: 4px;
}

.v-btn-toggle.vertical {
  flex-direction: column;
}
</style>

<script>
import ButtonContent from "@/components/controls/ButtonContent";
import { mapActions } from "vuex";

export default {
  name: "ToggleButtonGroup",
  components: {
    ButtonContent
  },
  props: {
    controlGroupConfiguration: {
      type: Object,
      required: true
    },
    vertical: {
      type: Boolean,
      required: false,
      default: false
    }
  },
  computed: {
    orientation: function () {
      if (this.vertical) {
        return "vertical";
      } else {
        return "horizontal";
      }
    },
    selected: {
      get: function () {
        if (this.controlGroupConfiguration.stateful) {
          const selected = this.$store.getters.getControlConfigurationWithActiveState(this.controlGroupConfiguration);
          if (selected) {
            return selected.id;
          }
        }
        return null;
      },
      // eslint-disable-next-line no-unused-vars
      set: function (newValue) {}
    }
  },
  methods: {
    ...mapActions(["toggleState"])
  }
};
</script>
