<template>
  <button-group
    id="TEST: EPU/GEN Switch"
    description="TEST: EPU/GEN Switch - Hold"
    type="button"
  >
    <control
      id="testepugenswitchhold"
      description="TEST: EPU/GEN Switch - Hold"
      label="EPU/GEN"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "TestEpuGenSwitch",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
