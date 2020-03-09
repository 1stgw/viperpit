<template>
  <button-group
    id="UHF: Manual Frequency _X_.___"
    description="UHF: Manual Frequency _X_.___ - Cycle Up"
    label="Manual Frequency _X_.___"
    type="button"
  >
    <control
      id="uhfmanualfrequencyxcycleup"
      description="UHF: Manual Frequency _X_.___ - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"
    />
    <control
      id="uhfmanualfrequencyxcycledown"
      description="UHF: Manual Frequency _X_.___ - Cycle Down"
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
  name: "UhfManualFrequencyZxzzzz",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
