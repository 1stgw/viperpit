<template>
  <switch-group
    id="EPU: EPU Switch"
    description="EPU: EPU Switch - ON"
    label="EPU" 
    type="switch">
    <control
      id="epuepuswitchon"
      description="EPU: EPU Switch - ON"
      label="ON"
      type="switch"
      role="on"/>
    <control
      id="epuepuswitchnorm"
      description="EPU: EPU Switch - NORM"
      label="NORM"
      type="switch"
      role="on"/>
    <control
      id="epuepuswitchoff"
      description="EPU: EPU Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'EpuEpuSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
