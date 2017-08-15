<template>
  <switch-group
    id="EXT: ANTI COLLISION Switch"
    description="EXT: ANTI COLLISION Switch - ON"
    label="ANTI COLLISION" 
    type="switch">
    <control
      id="extanticollisionswitchon"
      description="EXT: ANTI COLLISION Switch - ON"
      label="ON"
      type="switch"
      role="on"/>
    <control
      id="extanticollisionswitchoff"
      description="EXT: ANTI COLLISION Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'ExtAntiCollisionSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
