<template>
  <button-group
    id="RADIO: Tanker Menu"
    description="RADIO: Tanker Menu"
    type="button">
    <control
      id="radiotankermenu"
      description="RADIO: Tanker Menu"
      label="Tanker Menu"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'RadioTankerMenu',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
