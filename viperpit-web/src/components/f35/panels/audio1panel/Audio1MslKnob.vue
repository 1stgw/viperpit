<template>
  <button-group
    id="AUDIO1: MSL Knob"
    description="AUDIO1: MSL Knob - Volume Incr."
    label="MSL" 
    type="button">
    <control
      id="audio1mslknobvolumeincr"
      description="AUDIO1: MSL Knob - Volume Incr."
      label="Volume Incr."
      type="button"
      role="up"/>
    <control
      id="audio1mslknobvolumedecr"
      description="AUDIO1: MSL Knob - Volume Decr."
      label="Volume Decr."
      type="button"
      role="down"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'Audio1MslKnob',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
