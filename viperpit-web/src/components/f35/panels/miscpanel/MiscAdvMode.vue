<template>
  <button-group
    id="MISC: ADV MODE"
    description="MISC: ADV MODE - Toggle TFR On / Off"
    type="button"
  >
    <control
      id="miscAdvModeToggleTfrOnOff"
      description="MISC: ADV MODE - Toggle TFR On / Off"
      label="ADV MODE"
      type="button"
      role="off"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "MiscAdvMode",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
