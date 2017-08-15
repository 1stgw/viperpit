<template>
  <switch-group
    id="AVIONICS: INS Knob"
    description="AVIONICS: INS Knob - OFF"
    label="INS" 
    type="switch">
    <control
      id="avionicsinsknoboff"
      description="AVIONICS: INS Knob - OFF"
      label="OFF"
      type="switch"
      role="off"/>
    <control
      id="avionicsinsknobnorm"
      description="AVIONICS: INS Knob - NORM"
      label="NORM"
      type="switch"
      role="on"/>
    <control
      id="avionicsinsknobnav"
      description="AVIONICS: INS Knob - NAV"
      label="NAV"
      type="switch"
      role="none"/>
    <control
      id="avionicsinsknobinfltalign"
      description="AVIONICS: INS Knob - IN FLT ALIGN"
      label="IN FLT ALIGN"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'AvionicsInsKnob',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
