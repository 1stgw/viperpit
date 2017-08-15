<template>
  <switch-group
    id="UHF: MODE Knob"
    description="UHF: MODE Knob - MNL"
    label="MODE" 
    type="switch">
    <control
      id="uhfmodeknobmnl"
      description="UHF: MODE Knob - MNL"
      label="MNL"
      type="switch"
      role="none"/>
    <control
      id="uhfmodeknobpreset"
      description="UHF: MODE Knob - PRESET"
      label="PRESET"
      type="switch"
      role="none"/>
    <control
      id="uhfmodeknobgrd"
      description="UHF: MODE Knob - GRD"
      label="GRD"
      type="switch"
      role="none"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'UhfModeKnob',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
