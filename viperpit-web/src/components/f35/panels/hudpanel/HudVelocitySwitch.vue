<template>
  <switch-group
    id="HUD: Velocity Switch"
    description="HUD: Velocity Switch - CAS"
    label="Velocity" 
    type="switch">
    <control
      id="hudvelocityswitchcas"
      description="HUD: Velocity Switch - CAS"
      label="CAS"
      type="switch"
      role="none"/>
    <control
      id="hudvelocityswitchtas"
      description="HUD: Velocity Switch - TAS"
      label="TAS"
      type="switch"
      role="none"/>
    <control
      id="hudvelocityswitchgndspd"
      description="HUD: Velocity Switch - GND SPD"
      label="GND SPD"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'HudVelocitySwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
