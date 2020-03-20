<template>
  <button-group
    id="VIEWINT: Glance Backward"
    description="VIEWINT: Glance Backward"
    type="button"
  >
    <control
      id="viewintGlanceBackward"
      description="VIEWINT: Glance Backward"
      label="Glance Backward"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "ViewintGlanceBackward",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
