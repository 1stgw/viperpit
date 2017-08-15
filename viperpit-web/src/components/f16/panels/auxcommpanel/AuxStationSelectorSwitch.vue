<template>
  <switch-group
    id="AUX: STATION SELECTOR Switch"
    description="AUX: STATION SELECTOR Switch - T/R"
    label="STATION SELECTOR" 
    type="switch">
    <control
      id="auxstationselectorswitchtr"
      description="AUX: STATION SELECTOR Switch - T/R"
      label="T/R"
      type="switch"
      role="none"/>
    <control
      id="auxstationselectorswitchaatr"
      description="AUX: STATION SELECTOR Switch - A/A TR"
      label="A/A TR"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'AuxStationSelectorSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
