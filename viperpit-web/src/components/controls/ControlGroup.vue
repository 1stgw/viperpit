<template>
  <div>
    <div v-if="controlGroupConfiguration.stateful">
      <stateful-button-group
        :controlGroupConfiguration="controlGroupConfiguration"
      />
    </div>
    <div v-else>
      <div v-if="controlGroupConfiguration.controlConfigurations.length > 1">
        <stateless-button-group
          :controlGroupConfiguration="controlGroupConfiguration"
        />
      </div>
      <div v-else>
        <stateless-button
          :controlGroupConfiguration="controlGroupConfiguration"
        />
      </div>
    </div>
  </div>
</template>

<script>
import StatefulButtonGroup from "@/components/controls/StatefulButtonGroup";
import StatelessButton from "@/components/controls/StatelessButton";
import StatelessButtonGroup from "@/components/controls/StatelessButtonGroup";

export default {
  name: "ControlGroup",
  components: {
    StatelessButton,
    StatefulButtonGroup,
    StatelessButtonGroup
  },
  props: {
    controlGroupConfiguration: {
      type: Object,
      required: true
    }
  }
};
</script>
