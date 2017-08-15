<template>
  <button-group
    id="MISC: ADV MODE"
    description="MISC: ADV MODE - Toggle TFR On / Off"
    type="button">
    <control
      id="miscadvmodetoggletfronoff"
      description="MISC: ADV MODE - Toggle TFR On / Off"
      label="ADV MODE"
      type="button"
      role="off"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'MiscAdvMode',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
