<template>
  <button-group
    id="GEAR: EMER STORES JETTISON Button"
    description="GEAR: EMER STORES JETTISON Button - Hold"
    type="button">
    <control
      id="gearemerstoresjettisonbuttonhold"
      description="GEAR: EMER STORES JETTISON Button - Hold"
      label="EMER STORES JETTISON"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'GearEmerStoresJettisonButton',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
