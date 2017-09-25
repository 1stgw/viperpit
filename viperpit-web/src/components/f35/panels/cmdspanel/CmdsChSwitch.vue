<template>
  <switch-group
    id="CMDS: CH Switch"
    description="CMDS: CH Switch - ON"
    label="CH" 
    type="switch">
    <control
      id="cmdschswitchon"
      description="CMDS: CH Switch - ON"
      label="ON"
      type="switch"
      role="on"/>
    <control
      id="cmdschswitchoff"
      description="CMDS: CH Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'CmdsChSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
