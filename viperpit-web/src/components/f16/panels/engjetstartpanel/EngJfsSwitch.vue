<template>
  <switch-group
    id="ENG: JFS Switch"
    description="ENG: JFS Switch - OFF"
    label="JFS" 
    type="switch">
    <control
      id="engjfsswitchoff"
      description="ENG: JFS Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
    <control
      id="engjfsswitchstart2"
      description="ENG: JFS Switch - START 2"
      label="START 2"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'EngJfsSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
