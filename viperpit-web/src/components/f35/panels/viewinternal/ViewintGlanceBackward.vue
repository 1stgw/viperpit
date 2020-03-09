<template>
  <button-group
    id="VIEWINT: Glance Backward"
    description="VIEWINT: Glance Backward"
    type="button"
  >
    <control
      id="viewintglancebackward"
      description="VIEWINT: Glance Backward"
      label="Glance Backward"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "ViewintGlanceBackward",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
