<template>
  <button-group
    id="VIEWINT: HUD Only"
    description="VIEWINT: HUD Only"
    type="button"
  >
    <control
      id="viewinthudonly"
      description="VIEWINT: HUD Only"
      label="HUD Only"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "ViewintHudOnly",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
