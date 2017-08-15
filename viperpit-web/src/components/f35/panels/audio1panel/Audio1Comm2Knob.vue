<template>
  <button-group
    id="AUDIO1: COMM 2 Knob"
    description="AUDIO1: COMM 2 Knob - Volume Incr."
    label="COMM 2" 
    type="button">
    <control
      id="audio1comm2knobvolumeincr"
      description="AUDIO1: COMM 2 Knob - Volume Incr."
      label="Volume Incr."
      type="button"
      role="up"/>
    <control
      id="audio1comm2knobvolumedecr"
      description="AUDIO1: COMM 2 Knob - Volume Decr."
      label="Volume Decr."
      type="button"
      role="down"/>
    <control
      id="audio1comm2knobpoweron"
      description="AUDIO1: COMM 2 Knob - Power On"
      label="Power On"
      type="button"
      role="on"/>
    <control
      id="audio1comm2knobpoweroff"
      description="AUDIO1: COMM 2 Knob - Power Off"
      label="Power Off"
      type="button"
      role="off"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'Audio1Comm2Knob',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
