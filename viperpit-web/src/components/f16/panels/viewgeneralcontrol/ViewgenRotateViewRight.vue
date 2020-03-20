<template>
  <button-group
    id="VIEWGEN: Rotate View Right"
    description="VIEWGEN: Rotate View Right"
    type="button"
  >
    <control
      id="viewgenRotateViewRight"
      description="VIEWGEN: Rotate View Right"
      label="Rotate View Right"
      type="button"
      role="right"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "ViewgenRotateViewRight",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
