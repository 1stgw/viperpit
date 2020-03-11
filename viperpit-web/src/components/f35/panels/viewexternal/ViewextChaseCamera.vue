<template>
  <button-group
    id="VIEWEXT: Chase Camera"
    description="VIEWEXT: Chase Camera"
    type="button"
  >
    <control
      id="viewextchasecamera"
      description="VIEWEXT: Chase Camera"
      label="Chase Camera"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "ViewextChaseCamera",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
