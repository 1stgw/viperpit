<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <instr-mode-panel />
  </div>
  <div class="col-sm-6">
    <main-instrument />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <left-eyebrow />
  </div>
  <div class="col-sm-6">
    <misc-panel />
  </div>
  </div>
</div>
</template>

<script>
import InstrModePanel from '../panels/instrmodepanel/InstrModePanel'
import MainInstrument from '../panels/maininstrument/MainInstrument'
import LeftEyebrow from '../panels/lefteyebrow/LeftEyebrow'
import MiscPanel from '../panels/miscpanel/MiscPanel'

export default {
  name: 'CenterConsole',
  components: {
    InstrModePanel,
    MainInstrument,
    LeftEyebrow,
    MiscPanel
  }
}
</script>
