<template>
  <button-group
    id="Radio-Next Menu Tanker"
    description="Radio-Next Menu Tanker"
    type="button"
  >
    <control
      id="radionextmenutanker"
      description="Radio-Next Menu Tanker"
      label="Next Menu Tanker"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "RadioNextMenuTanker",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
