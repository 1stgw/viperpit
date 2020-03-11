<template>
  <button-group
    id="RADIO: Element Menu"
    description="RADIO: Element Menu"
    type="button"
  >
    <control
      id="radioelementmenu"
      description="RADIO: Element Menu"
      label="Element Menu"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "RadioElementMenu",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
