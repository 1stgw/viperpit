<template>
  <switch-group
    id="SNSR: FCR Switch"
    description="SNSR: FCR Switch - ON"
    label="FCR" 
    type="switch">
    <control
      id="snsrfcrswitchon"
      description="SNSR: FCR Switch - ON"
      label="ON"
      type="switch"
      role="on"/>
    <control
      id="snsrfcrswitchoff"
      description="SNSR: FCR Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'SnsrFcrSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
