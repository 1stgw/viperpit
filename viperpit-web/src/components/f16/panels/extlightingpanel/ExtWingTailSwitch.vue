<template>
  <switch-group
    id="EXT: WING/TAIL Switch"
    description="EXT: WING/TAIL Switch - BRT"
    label="WING/TAIL"
    type="switch"
  >
    <control
      id="extWingTailSwitchBrt"
      description="EXT: WING/TAIL Switch - BRT"
      label="BRT"
      type="switch"
      role="none"
    />
    <control
      id="extWingTailSwitchOff"
      description="EXT: WING/TAIL Switch - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "ExtWingTailSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
