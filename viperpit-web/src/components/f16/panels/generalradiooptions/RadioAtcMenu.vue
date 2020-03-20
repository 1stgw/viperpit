<template>
  <button-group
    id="RADIO: ATC Menu"
    description="RADIO: ATC Menu"
    type="button"
  >
    <control
      id="radioAtcMenu"
      description="RADIO: ATC Menu"
      label="ATC Menu"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "RadioAtcMenu",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
