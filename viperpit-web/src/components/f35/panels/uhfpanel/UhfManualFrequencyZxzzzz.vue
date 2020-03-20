<template>
  <button-group
    id="UHF: Manual Frequency _X_.___"
    description="UHF: Manual Frequency _X_.___ - Cycle Up"
    label="Manual Frequency _X_.___"
    type="button"
  >
    <control
      id="uhfManualFrequencyZxzzzzCycleUp"
      description="UHF: Manual Frequency _X_.___ - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"
    />
    <control
      id="uhfManualFrequencyZxzzzzCycleDown"
      description="UHF: Manual Frequency _X_.___ - Cycle Down"
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
  name: "UhfManualFrequencyZxzzzz",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
