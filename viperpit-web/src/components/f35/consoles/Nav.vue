<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <main-instrument />
  </div>
  <div class="col-sm-6">
    <instr-mode-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <ap-and-tfr-panel />
  </div>
  </div>
</div>
</template>

<script>
import MainInstrument from '../panels/maininstrument/MainInstrument'
import InstrModePanel from '../panels/instrmodepanel/InstrModePanel'
import ApAndTfrPanel from '../panels/apandtfrpanel/ApAndTfrPanel'

export default {
  name: 'Nav',
  components: {
    MainInstrument,
    InstrModePanel,
    ApAndTfrPanel
  }
}
</script>
