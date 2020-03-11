<template>
  <button-group
    id="OXY: Setting 2"
    description="OXY: Setting 2 - ON (Pilot breathing)"
    label="Setting 2"
    type="button"
  >
    <control
      id="oxysetting2onpilotbreathing"
      description="OXY: Setting 2 - ON (Pilot breathing)"
      label="ON (Pilot breathing)"
      type="button"
      role="none"
    />
    <control
      id="oxysetting2offpilotbreathing"
      description="OXY: Setting 2 - OFF (Pilot breathing)"
      label="OFF (Pilot breathing)"
      type="button"
      role="none"
    />
  </button-group>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";

export default {
  name: "OxySetting2",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
