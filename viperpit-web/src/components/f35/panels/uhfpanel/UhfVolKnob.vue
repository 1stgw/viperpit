<template>
  <button-group
    id="UHF: VOL Knob"
    description="UHF: VOL Knob - AI vs IVC Volume Incr"
    label="VOL" 
    type="button">
    <control
      id="uhfvolknobaivsivcvolumeincr"
      description="UHF: VOL Knob - AI vs IVC Volume Incr"
      label="AI vs IVC Volume Incr"
      type="button"
      role="none"/>
    <control
      id="uhfvolknobaivsivcvolumedecr"
      description="UHF: VOL Knob - AI vs IVC Volume Decr"
      label="AI vs IVC Volume Decr"
      type="button"
      role="none"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'UhfVolKnob',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
