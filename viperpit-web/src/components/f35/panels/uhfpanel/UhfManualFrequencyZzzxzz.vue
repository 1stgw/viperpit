<template>
  <button-group
    id="UHF: Manual Frequency ___.X__"
    description="UHF: Manual Frequency ___.X__ - Cycle Up"
    label="Manual Frequency ___.X__" 
    type="button">
    <control
      id="uhfmanualfrequencyxcycleup"
      description="UHF: Manual Frequency ___.X__ - Cycle Up"
      label="Cycle Up"
      type="button"
      role="up"/>
    <control
      id="uhfmanualfrequencyxcycledown"
      description="UHF: Manual Frequency ___.X__ - Cycle Down"
      label="Cycle Down"
      type="button"
      role="down"/>
  </button-group>
</template>

<script>
import Control from '../../controls/Control'
import ButtonGroup from '../../controls/ButtonGroup'

export default {
  name: 'UhfManualFrequencyZzzxzz',
  components: {
    Control,
    ButtonGroup
  }
}
</script>
