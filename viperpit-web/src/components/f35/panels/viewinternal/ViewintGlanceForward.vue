<template>
  <button-group
    id="VIEWINT: Glance Forward"
    description="VIEWINT: Glance Forward"
    type="button">
    <control
      id="viewintglanceforward"
      description="VIEWINT: Glance Forward"
      label="Glance Forward"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'ViewintGlanceForward',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
