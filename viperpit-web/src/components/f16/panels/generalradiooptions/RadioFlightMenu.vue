<template>
  <button-group
    id="RADIO: Flight Menu"
    description="RADIO: Flight Menu"
    type="button"
  >
    <control
      id="radioflightmenu"
      description="RADIO: Flight Menu"
      label="Flight Menu"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "../../controls/Control";
import ButtonGroup from "../../controls/ButtonGroup";

export default {
  name: "RadioFlightMenu",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
