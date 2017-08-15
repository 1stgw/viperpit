<template>
  <switch-group
    id="ELEC: MAIN PWR Switch"
    description="ELEC: MAIN PWR Switch - MAIN"
    label="MAIN PWR" 
    type="switch">
    <control
      id="elecmainpwrswitchmain"
      description="ELEC: MAIN PWR Switch - MAIN"
      label="MAIN"
      type="switch"
      role="on"/>
    <control
      id="elecmainpwrswitchbatt"
      description="ELEC: MAIN PWR Switch - BATT"
      label="BATT"
      type="switch"
      role="none"/>
    <control
      id="elecmainpwrswitchoff"
      description="ELEC: MAIN PWR Switch - OFF"
      label="OFF"
      type="switch"
      role="off"/>
  </switch-group>
</template>

<script>
import Control from '../../controls/Control'
import SwitchGroup from '../../controls/SwitchGroup'

export default {
  name: 'ElecMainPwrSwitch',
  components: {
    Control,
    SwitchGroup
  }
}
</script>
