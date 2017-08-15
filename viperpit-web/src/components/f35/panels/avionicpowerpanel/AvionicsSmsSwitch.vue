<template>
  <switch-group
    id="AVIONICS: SMS Switch"
    description="AVIONICS: SMS Switch - ON"
    label="SMS" 
    type="switch">
    <control
      id="avionicssmsswitchon"
      description="AVIONICS: SMS Switch - ON"
      label="ON"
      type="switch"
      role="on"/>
    <control
      id="avionicssmsswitchoff"
      description="AVIONICS: SMS Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'AvionicsSmsSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
