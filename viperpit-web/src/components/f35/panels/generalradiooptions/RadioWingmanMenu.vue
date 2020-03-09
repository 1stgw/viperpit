<template>
  <button-group
    id="RADIO: Wingman Menu"
    description="RADIO: Wingman Menu"
    type="button"
  >
    <control
      id="radiowingmanmenu"
      description="RADIO: Wingman Menu"
      label="Wingman Menu"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "RadioWingmanMenu",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
