<template>
  <button-group
    id="VIEWGEN: Rotate View Up"
    description="VIEWGEN: Rotate View Up"
    type="button"
  >
    <control
      id="viewgenrotateviewup"
      description="VIEWGEN: Rotate View Up"
      label="Rotate View Up"
      type="button"
      role="up"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "ViewgenRotateViewUp",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
