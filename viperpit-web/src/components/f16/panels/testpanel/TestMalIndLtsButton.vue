<template>
  <button-group
    id="TEST: MAL & IND LTS Button"
    description="TEST: MAL & IND LTS Button - Hold"
    type="button"
  >
    <control
      id="testmalindltsbuttonhold"
      description="TEST: MAL & IND LTS Button - Hold"
      label="MAL & IND LTS"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TestMalIndLtsButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
