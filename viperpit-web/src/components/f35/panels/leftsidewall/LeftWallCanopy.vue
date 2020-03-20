<template>
  <button-group
    id="LEFT WALL: CANOPY"
    description="LEFT WALL: CANOPY - Open"
    label="CANOPY"
    type="button"
  >
    <control
      id="leftWallCanopyOpen"
      description="LEFT WALL: CANOPY - Open"
      label="Open"
      type="button"
      role="none"
    />
    <control
      id="leftWallCanopyClose"
      description="LEFT WALL: CANOPY - Close"
      label="Close"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "LeftWallCanopy",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
