<template>
  <button-group
    id="TWP: UNKNOWN"
    description="TWP: UNKNOWN - Toggle"
    type="button"
  >
    <control
      id="twpunknowntoggle"
      description="TWP: UNKNOWN - Toggle"
      label="UNKNOWN"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "TwpUnknown",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
