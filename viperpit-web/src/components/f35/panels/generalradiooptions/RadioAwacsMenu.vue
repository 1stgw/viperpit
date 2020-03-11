<template>
  <button-group
    id="RADIO: AWACS Menu"
    description="RADIO: AWACS Menu"
    type="button"
  >
    <control
      id="radioawacsmenu"
      description="RADIO: AWACS Menu"
      label="AWACS Menu"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "RadioAwacsMenu",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
