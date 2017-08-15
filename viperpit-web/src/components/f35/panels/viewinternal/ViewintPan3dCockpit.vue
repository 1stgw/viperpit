<template>
  <button-group
    id="VIEWINT: Pan (3D) Cockpit"
    description="VIEWINT: Pan (3D) Cockpit"
    type="button">
    <control
      id="viewintpan3dcockpit"
      description="VIEWINT: Pan (3D) Cockpit"
      label="Pan (3D) Cockpit"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'ViewintPan3dCockpit',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
