<template>
  <button-group
    id="UHF: Manual Frequency __X.___"
    description="UHF: Manual Frequency __X.___ - Cycle Up"
    label="Manual Frequency __X.___"
    type="button"
  >
    <control
      id="uhfManualFrequencyZzxzzzCycleUp"
      description="UHF: Manual Frequency __X.___ - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"
    />
    <control
      id="uhfManualFrequencyZzxzzzCycleDown"
      description="UHF: Manual Frequency __X.___ - Cycle Down"
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
  name: "UhfManualFrequencyZzxzzz",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
