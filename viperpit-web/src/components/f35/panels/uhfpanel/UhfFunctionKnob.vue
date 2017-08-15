<template>
  <switch-group
    id="UHF: FUNCTION Knob"
    description="UHF: FUNCTION Knob - OFF"
    label="FUNCTION" 
    type="switch">
    <control
      id="uhffunctionknoboff"
      description="UHF: FUNCTION Knob - OFF"
      label="OFF"
      type="switch"
      role="off"/>
    <control
      id="uhffunctionknobmain"
      description="UHF: FUNCTION Knob - MAIN"
      label="MAIN"
      type="switch"
      role="on"/>
    <control
      id="uhffunctionknobboth"
      description="UHF: FUNCTION Knob - BOTH"
      label="BOTH"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'UhfFunctionKnob',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
