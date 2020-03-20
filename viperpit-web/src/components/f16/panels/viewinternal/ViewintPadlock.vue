<template>
  <button-group
    id="VIEWINT: Padlock"
    description="VIEWINT: Padlock"
    type="button"
  >
    <control
      id="viewintPadlock"
      description="VIEWINT: Padlock"
      label="Padlock"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "ViewintPadlock",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
