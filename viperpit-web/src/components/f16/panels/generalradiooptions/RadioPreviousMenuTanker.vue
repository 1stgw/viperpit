<template>
  <button-group
    id="Radio-Previous Menu Tanker"
    description="Radio-Previous Menu Tanker"
    type="button"
  >
    <control
      id="radioPreviousMenuTanker"
      description="Radio-Previous Menu Tanker"
      label="Previous Menu Tanker"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "RadioPreviousMenuTanker",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
