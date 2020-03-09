<template>
  <button-group
    id="VIEWGEN: Rotate View Right"
    description="VIEWGEN: Rotate View Right"
    type="button"
  >
    <control
      id="viewgenrotateviewright"
      description="VIEWGEN: Rotate View Right"
      label="Rotate View Right"
      type="button"
      role="right"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "ViewgenRotateViewRight",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
