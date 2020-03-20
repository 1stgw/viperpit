<template>
  <button-group
    id="UHF: Manual Frequency ___._XX"
    description="UHF: Manual Frequency ___._XX - Cycle Up"
    label="Manual Frequency ___._XX"
    type="button"
  >
    <control
      id="uhfManualFrequencyZzzzxxCycleUp"
      description="UHF: Manual Frequency ___._XX - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"
    />
    <control
      id="uhfManualFrequencyZzzzxxCycleDown"
      description="UHF: Manual Frequency ___._XX - Cycle Down"
      label="Cycle Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "UhfManualFrequencyZzzzxx",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
