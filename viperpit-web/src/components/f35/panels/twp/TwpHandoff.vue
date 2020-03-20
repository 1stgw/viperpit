<template>
  <button-group
    id="TWP: HANDOFF"
    description="TWP: HANDOFF - Push"
    type="button"
  >
    <control
      id="twpHandoffPush"
      description="TWP: HANDOFF - Push"
      label="HANDOFF"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "TwpHandoff",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
