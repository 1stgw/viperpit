<template>
  <button-group
    id="HMCS: HMSC Knob"
    description="HMCS: HMSC Knob - Brightness Incr."
    label="HMSC" 
    type="button">
    <control
      id="hmcshmscknobbrightnessincr"
      description="HMCS: HMSC Knob - Brightness Incr."
      label="Brightness Incr."
      type="button"
      role="up"/>
    <control
      id="hmcshmscknobbrightnessdecr"
      description="HMCS: HMSC Knob - Brightness Decr."
      label="Brightness Decr."
      type="button"
      role="down"/>
    <control
      id="hmcshmscknobon"
      description="HMCS: HMSC Knob - ON"
      label="ON"
      type="button"
      role="on"/>
    <control
      id="hmcshmscknoboff"
      description="HMCS: HMSC Knob - OFF"
      label="OFF"
      type="button"
      role="off"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'HmcsHmscKnob',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
