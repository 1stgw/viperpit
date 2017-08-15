<template>
  <button-group
    id="VIEWINT: Padlock"
    description="VIEWINT: Padlock"
    type="button">
    <control
      id="viewintpadlock"
      description="VIEWINT: Padlock"
      label="Padlock"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'ViewintPadlock',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
