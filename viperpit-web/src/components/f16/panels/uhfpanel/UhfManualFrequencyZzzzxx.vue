<template>
  <button-group
    id="UHF: Manual Frequency ___._XX"
    description="UHF: Manual Frequency ___._XX - Cycle Up"
    label="Manual Frequency ___._XX"
    type="button"
  >
    <control
      id="uhfmanualfrequencyxxcycleup"
      description="UHF: Manual Frequency ___._XX - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"
    />
    <control
      id="uhfmanualfrequencyxxcycledown"
      description="UHF: Manual Frequency ___._XX - Cycle Down"
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
  name: "UhfManualFrequencyZzzzxx",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
