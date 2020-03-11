<template>
  <switch-group
    id="MISC: RF Switch"
    description="MISC: RF Switch - NORM"
    label="RF"
    type="switch"
  >
    <control
      id="miscrfswitchnorm"
      description="MISC: RF Switch - NORM"
      label="NORM"
      type="switch"
      role="on"
    />
    <control
      id="miscrfswitchquiet"
      description="MISC: RF Switch - QUIET"
      label="QUIET"
      type="switch"
      role="none"
    />
    <control
      id="miscrfswitchsilent"
      description="MISC: RF Switch - SILENT"
      label="SILENT"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "MiscRfSwitch",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
