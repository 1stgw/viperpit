<template>
  <switch-group
    id="FLT: MANUAL TF FLYUP Switch"
    description="FLT: MANUAL TF FLYUP Switch - DISABLE"
    label="MANUAL TF FLYUP" 
    type="switch">
    <control
      id="fltmanualtfflyupswitchdisable"
      description="FLT: MANUAL TF FLYUP Switch - DISABLE"
      label="DISABLE"
      type="switch"
      role="off"/>
    <control
      id="fltmanualtfflyupswitchenable"
      description="FLT: MANUAL TF FLYUP Switch - ENABLE"
      label="ENABLE"
      type="switch"
      role="on"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'FltManualTfFlyupSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
