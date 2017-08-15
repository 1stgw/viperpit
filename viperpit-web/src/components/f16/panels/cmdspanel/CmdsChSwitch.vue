<template>
  <switch-group
    id="CMDS: CH Switch"
    description="CMDS: CH Switch - Power ON"
    label="CH" 
    type="switch">
    <control
      id="cmdschswitchpoweron"
      description="CMDS: CH Switch - Power ON"
      label="Power ON"
      type="switch"
      role="on"/>
    <control
      id="cmdschswitchpoweroff"
      description="CMDS: CH Switch - Power OFF"
      label="Power OFF"
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
