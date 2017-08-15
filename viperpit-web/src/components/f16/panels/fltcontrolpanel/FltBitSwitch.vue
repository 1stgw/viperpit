<template>
  <button-group
    id="FLT: BIT Switch"
    description="FLT: BIT Switch - Push"
    type="button">
    <control
      id="fltbitswitchpush"
      description="FLT: BIT Switch - Push"
      label="BIT"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'FltBitSwitch',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
