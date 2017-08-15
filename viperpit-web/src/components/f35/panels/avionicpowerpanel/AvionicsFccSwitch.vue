<template>
  <switch-group
    id="AVIONICS: FCC Switch"
    description="AVIONICS: FCC Switch - ON"
    label="FCC" 
    type="switch">
    <control
      id="avionicsfccswitchon"
      description="AVIONICS: FCC Switch - ON"
      label="ON"
      type="switch"
      role="on"/>
    <control
      id="avionicsfccswitchoff"
      description="AVIONICS: FCC Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'AvionicsFccSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
