<template>
  <button-group
    id="TWA: LOW Button"
    description="TWA: LOW Button - Toggle"
    type="button">
    <control
      id="twalowbuttontoggle"
      description="TWA: LOW Button - Toggle"
      label="LOW"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'TwaLowButton',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
