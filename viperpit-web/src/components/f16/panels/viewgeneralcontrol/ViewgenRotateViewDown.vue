<template>
  <button-group
    id="VIEWGEN: Rotate View Down"
    description="VIEWGEN: Rotate View Down"
    type="button"
  >
    <control
      id="viewgenrotateviewdown"
      description="VIEWGEN: Rotate View Down"
      label="Rotate View Down"
      type="button"
      role="down"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "ViewgenRotateViewDown",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
