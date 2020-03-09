<template>
  <button-group
    id="UHF: Manual Frequency __X.___"
    description="UHF: Manual Frequency __X.___ - Cycle Up"
    label="Manual Frequency __X.___"
    type="button"
  >
    <control
      id="uhfmanualfrequencyxcycleup"
      description="UHF: Manual Frequency __X.___ - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"
    />
    <control
      id="uhfmanualfrequencyxcycledown"
      description="UHF: Manual Frequency __X.___ - Cycle Down"
      label="Cycle Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "UhfManualFrequencyZzxzzz",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
