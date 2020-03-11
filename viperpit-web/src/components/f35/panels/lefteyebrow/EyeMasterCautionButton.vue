<template>
  <button-group
    id="EYE: MASTER CAUTION Button"
    description="EYE: MASTER CAUTION Button - Push"
    type="button"
  >
    <control
      id="eyemastercautionbuttonpush"
      description="EYE: MASTER CAUTION Button - Push"
      label="MASTER CAUTION"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "EyeMasterCautionButton",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
