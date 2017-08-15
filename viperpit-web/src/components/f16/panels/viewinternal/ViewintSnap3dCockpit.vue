<template>
  <button-group
    id="VIEWINT: Snap (3D) Cockpit"
    description="VIEWINT: Snap (3D) Cockpit"
    type="button">
    <control
      id="viewintsnap3dcockpit"
      description="VIEWINT: Snap (3D) Cockpit"
      label="Snap (3D) Cockpit"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'ViewintSnap3dCockpit',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
