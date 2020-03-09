<template>
  <button-group
    id="VIEWEXT: Flyby Camera"
    description="VIEWEXT: Flyby Camera"
    type="button"
  >
    <control
      id="viewextflybycamera"
      description="VIEWEXT: Flyby Camera"
      label="Flyby Camera"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "ViewextFlybyCamera",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
