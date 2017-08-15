<template>
  <button-group
    id="TWA: POWER Button"
    description="TWA: POWER Button - On"
    label="POWER" 
    type="button">
    <control
      id="twapowerbuttonon"
      description="TWA: POWER Button - On"
      label="On"
      type="button"
      role="on"/>
    <control
      id="twapowerbuttonoff"
      description="TWA: POWER Button - Off"
      label="Off"
      type="button"
      role="off"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'TwaPowerButton',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
