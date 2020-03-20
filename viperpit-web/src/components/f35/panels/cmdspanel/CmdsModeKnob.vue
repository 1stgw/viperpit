<template>
  <switch-group
    id="CMDS: MODE Knob"
    description="CMDS: MODE Knob - OFF"
    label="MODE"
    type="switch"
  >
    <control
      id="cmdsModeKnobOff"
      description="CMDS: MODE Knob - OFF"
      label="OFF"
      type="switch"
      role="off"
    />
    <control
      id="cmdsModeKnobStby"
      description="CMDS: MODE Knob - STBY"
      label="STBY"
      type="switch"
      role="none"
    />
    <control
      id="cmdsModeKnobMan"
      description="CMDS: MODE Knob - MAN"
      label="MAN"
      type="switch"
      role="none"
    />
    <control
      id="cmdsModeKnobSemi"
      description="CMDS: MODE Knob - SEMI"
      label="SEMI"
      type="switch"
      role="none"
    />
    <control
      id="cmdsModeKnobAuto"
      description="CMDS: MODE Knob - AUTO"
      label="AUTO"
      type="switch"
      role="none"
    />
    <control
      id="cmdsModeKnobByp"
      description="CMDS: MODE Knob - BYP"
      label="BYP"
      type="switch"
      role="none"
    />
  </switch-group>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "CmdsModeKnob",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
