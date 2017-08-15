<template>
  <switch-group
    id="INSTR: MODE Knob"
    description="INSTR: MODE Knob - ILS/TCN"
    label="MODE" 
    type="switch">
    <control
      id="instrmodeknobilstcn"
      description="INSTR: MODE Knob - ILS/TCN"
      label="ILS/TCN"
      type="switch"
      role="none"/>
    <control
      id="instrmodeknobtcn"
      description="INSTR: MODE Knob - TCN"
      label="TCN"
      type="switch"
      role="none"/>
    <control
      id="instrmodeknobnav"
      description="INSTR: MODE Knob - NAV"
      label="NAV"
      type="switch"
      role="none"/>
    <control
      id="instrmodeknobilsnav"
      description="INSTR: MODE Knob - ILS/NAV"
      label="ILS/NAV"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'InstrModeKnob',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
