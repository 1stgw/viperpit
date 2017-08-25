<template>
  <button-group
    id="TWA: SEARCH Button"
    description="TWA: SEARCH Button - Toggle"
    type="button">
    <control
      id="twasearchbuttontoggle"
      description="TWA: SEARCH Button - Toggle"
      label="SEARCH"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'TwaSearchButton',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
