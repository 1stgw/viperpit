<template>
  <switch-group
    id="EXT: POSITION Switch"
    description="EXT: POSITION Switch - FLASH"
    label="POSITION"
    type="switch"
  >
    <control
      id="extpositionswitchflash"
      description="EXT: POSITION Switch - FLASH"
      label="FLASH"
      type="switch"
      role="none"
    />
    <control
      id="extpositionswitchsteady"
      description="EXT: POSITION Switch - STEADY"
      label="STEADY"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "ExtPositionSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
