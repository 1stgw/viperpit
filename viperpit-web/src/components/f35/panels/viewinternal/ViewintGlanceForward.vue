<template>
  <button-group
    id="VIEWINT: Glance Forward"
    description="VIEWINT: Glance Forward"
    type="button"
  >
    <control
      id="viewintGlanceForward"
      description="VIEWINT: Glance Forward"
      label="Glance Forward"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "ViewintGlanceForward",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
