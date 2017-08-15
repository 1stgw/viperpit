<template>
  <switch-group
    id="HUD: DED Data Switch"
    description="HUD: DED Data Switch - DED"
    label="DED Data" 
    type="switch">
    <control
      id="huddeddataswitchded"
      description="HUD: DED Data Switch - DED"
      label="DED"
      type="switch"
      role="none"/>
    <control
      id="huddeddataswitchpfl"
      description="HUD: DED Data Switch - PFL"
      label="PFL"
      type="switch"
      role="none"/>
    <control
      id="huddeddataswitchoff"
      description="HUD: DED Data Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'HudDedDataSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
