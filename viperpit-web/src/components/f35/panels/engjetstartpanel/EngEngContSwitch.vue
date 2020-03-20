<template>
  <switch-group
    id="ENG: ENG CONT Switch"
    description="ENG: ENG CONT Switch - PRI"
    label="ENG CONT"
    type="switch"
  >
    <control
      id="engEngContSwitchPri"
      description="ENG: ENG CONT Switch - PRI"
      label="PRI"
      type="switch"
      role="none"
    />
    <control
      id="engEngContSwitchSec"
      description="ENG: ENG CONT Switch - SEC"
      label="SEC"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "EngEngContSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
