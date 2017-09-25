<template>
  <switch-group
    id="CMDS: JMR Switch"
    description="CMDS: JMR Switch - ON"
    label="JMR" 
    type="switch">
    <control
      id="cmdsjmrswitchon"
      description="CMDS: JMR Switch - ON"
      label="ON"
      type="switch"
      role="on"/>
    <control
      id="cmdsjmrswitchoff"
      description="CMDS: JMR Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'CmdsJmrSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
