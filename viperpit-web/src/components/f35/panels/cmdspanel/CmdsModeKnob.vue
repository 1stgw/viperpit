<template>
  <switch-group
    id="CMDS: MODE Knob"
    description="CMDS: MODE Knob - OFF"
    label="MODE" 
    type="switch">
    <control
      id="cmdsmodeknoboff"
      description="CMDS: MODE Knob - OFF"
      label="OFF"
      type="switch"
      role="off"/>
    <control
      id="cmdsmodeknobstby"
      description="CMDS: MODE Knob - STBY"
      label="STBY"
      type="switch"
      role="none"/>
    <control
      id="cmdsmodeknobman"
      description="CMDS: MODE Knob - MAN"
      label="MAN"
      type="switch"
      role="none"/>
    <control
      id="cmdsmodeknobsemi"
      description="CMDS: MODE Knob - SEMI"
      label="SEMI"
      type="switch"
      role="none"/>
    <control
      id="cmdsmodeknobauto"
      description="CMDS: MODE Knob - AUTO"
      label="AUTO"
      type="switch"
      role="none"/>
    <control
      id="cmdsmodeknobbyp"
      description="CMDS: MODE Knob - BYP"
      label="BYP"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'CmdsModeKnob',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
