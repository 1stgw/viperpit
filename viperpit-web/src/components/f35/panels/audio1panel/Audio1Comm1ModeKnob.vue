<template>
  <switch-group
    id="AUDIO1: COMM 1 Mode Knob"
    description="AUDIO1: COMM 1 Mode Knob - SQL"
    label="COMM 1 Mode" 
    type="switch">
    <control
      id="audio1comm1modeknobsql"
      description="AUDIO1: COMM 1 Mode Knob - SQL"
      label="SQL"
      type="switch"
      role="none"/>
    <control
      id="audio1comm1modeknobgd"
      description="AUDIO1: COMM 1 Mode Knob - GD"
      label="GD"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'Audio1Comm1ModeKnob',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
