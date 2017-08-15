<template>
  <button-group
    id="Radio-Previous Menu Tanker"
    description="Radio-Previous Menu Tanker"
    type="button">
    <control
      id="radiopreviousmenutanker"
      description="Radio-Previous Menu Tanker"
      label="Previous Menu Tanker"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'RadioPreviousMenuTanker',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
