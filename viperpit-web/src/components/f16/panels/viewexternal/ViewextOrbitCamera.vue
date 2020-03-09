<template>
  <button-group
    id="VIEWEXT: Orbit Camera"
    description="VIEWEXT: Orbit Camera"
    type="button"
  >
    <control
      id="viewextorbitcamera"
      description="VIEWEXT: Orbit Camera"
      label="Orbit Camera"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "ViewextOrbitCamera",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
