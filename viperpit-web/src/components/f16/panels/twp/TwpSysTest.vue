<template>
  <button-group
    id="TWP: SYS TEST"
    description="TWP: SYS TEST - Push"
    type="button"
  >
    <control
      id="twpSysTestPush"
      description="TWP: SYS TEST - Push"
      label="SYS TEST"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TwpSysTest",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
