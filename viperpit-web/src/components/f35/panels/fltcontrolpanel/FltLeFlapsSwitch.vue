<template>
  <switch-group
    id="FLT: LE FLAPS Switch"
    description="FLT: LE FLAPS Switch - LOCK"
    label="LE FLAPS" 
    type="switch">
    <control
      id="fltleflapsswitchlock"
      description="FLT: LE FLAPS Switch - LOCK"
      label="LOCK"
      type="switch"
      role="none"/>
    <control
      id="fltleflapsswitchauto"
      description="FLT: LE FLAPS Switch - AUTO"
      label="AUTO"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'FltLeFlapsSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
