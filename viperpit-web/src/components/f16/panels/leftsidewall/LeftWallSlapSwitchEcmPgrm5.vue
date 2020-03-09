<template>
  <button-group
    id="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
    description="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
    type="button"
  >
    <control
      id="leftwallslapswitchecmpgrm5"
      description="LEFT WALL: SLAP Switch (ECM-PGRM # 5)"
      label="SLAP Switch (ECM-PGRM # 5)"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "LeftWallSlapSwitchEcmPgrm5",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
