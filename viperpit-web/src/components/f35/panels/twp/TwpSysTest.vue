<template>
  <button-group
    id="TWP: SYS TEST"
    description="TWP: SYS TEST - Push"
    type="button">
    <control
      id="twpsystestpush"
      description="TWP: SYS TEST - Push"
      label="SYS TEST"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'TwpSysTest',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
