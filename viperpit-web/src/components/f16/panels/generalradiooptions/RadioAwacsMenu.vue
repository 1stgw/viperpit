<template>
  <button-group
    id="RADIO: AWACS Menu"
    description="RADIO: AWACS Menu"
    type="button">
    <control
      id="radioawacsmenu"
      description="RADIO: AWACS Menu"
      label="AWACS Menu"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'RadioAwacsMenu',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
