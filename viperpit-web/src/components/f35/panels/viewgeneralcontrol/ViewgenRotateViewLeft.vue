<template>
  <button-group
    id="VIEWGEN: Rotate View Left"
    description="VIEWGEN: Rotate View Left"
    type="button">
    <control
      id="viewgenrotateviewleft"
      description="VIEWGEN: Rotate View Left"
      label="Rotate View Left"
      type="button"
      role="left"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'ViewgenRotateViewLeft',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
