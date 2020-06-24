<template>
  <div>
    <div v-if="controlGroupConfiguration.controlConfigurations.length > 1">
      <toggle-button-group :control-group-configuration="controlGroupConfiguration" />
    </div>
    <div v-else>
      <toggle-button :control-group-configuration="controlGroupConfiguration" />
    </div>
  </div>
</template>

<script>
import ToggleButton from "@/components/controls/ToggleButton";
import ToggleButtonGroup from "@/components/controls/ToggleButtonGroup";

export default {
  name: "ControlGroup",
  components: {
    ToggleButton,
    ToggleButtonGroup
  },
  props: {
    controlGroupConfiguration: {
      type: Object,
      required: true
    }
  }
};
</script>
