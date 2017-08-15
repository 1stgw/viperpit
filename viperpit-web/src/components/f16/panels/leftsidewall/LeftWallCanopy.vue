<template>
  <button-group
    id="LEFT WALL: CANOPY"
    description="LEFT WALL: CANOPY - Open"
    label="CANOPY" 
    type="button">
    <control
      id="leftwallcanopyopen"
      description="LEFT WALL: CANOPY - Open"
      label="Open"
      type="button"
      role="none"/>
    <control
      id="leftwallcanopyclose"
      description="LEFT WALL: CANOPY - Close"
      label="Close"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'LeftWallCanopy',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
