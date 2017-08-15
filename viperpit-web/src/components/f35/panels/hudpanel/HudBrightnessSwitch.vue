<template>
  <switch-group
    id="HUD: Brightness Switch"
    description="HUD: Brightness Switch - DAY"
    label="Brightness" 
    type="switch">
    <control
      id="hudbrightnessswitchday"
      description="HUD: Brightness Switch - DAY"
      label="DAY"
      type="switch"
      role="none"/>
    <control
      id="hudbrightnessswitchautobrt"
      description="HUD: Brightness Switch - AUTO BRT"
      label="AUTO BRT"
      type="switch"
      role="none"/>
    <control
      id="hudbrightnessswitchnig"
      description="HUD: Brightness Switch - NIG"
      label="NIG"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'HudBrightnessSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
