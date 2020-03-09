<template>
  <switch-group
    id="CMDS: PRGM Knob"
    description="CMDS: PRGM Knob - 1"
    label="PRGM"
    type="switch"
  >
    <control
      id="cmdsprgmknob1"
      description="CMDS: PRGM Knob - 1"
      label="1"
      type="switch"
      role="none"
    />
    <control
      id="cmdsprgmknob2"
      description="CMDS: PRGM Knob - 2"
      label="2"
      type="switch"
      role="none"
    />
    <control
      id="cmdsprgmknob3"
      description="CMDS: PRGM Knob - 3"
      label="3"
      type="switch"
      role="none"
    />
    <control
      id="cmdsprgmknob4"
      description="CMDS: PRGM Knob - 4"
      label="4"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "../../controls/Control";
import SwitchGroup from "../../controls/SwitchGroup";

export default {
  name: "CmdsPrgmKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
