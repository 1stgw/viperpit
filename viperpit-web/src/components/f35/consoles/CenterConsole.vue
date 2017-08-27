<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <misc-panel />
  </div>
  <div class="col-sm-6">
    <left-eyebrow />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <main-instrument />
  </div>
  <div class="col-sm-6">
    <instr-mode-panel />
  </div>
  </div>
</div>
</template>

<script>
import MiscPanel from '../panels/miscpanel/MiscPanel'
import LeftEyebrow from '../panels/lefteyebrow/LeftEyebrow'
import MainInstrument from '../panels/maininstrument/MainInstrument'
import InstrModePanel from '../panels/instrmodepanel/InstrModePanel'

export default {
  name: 'CenterConsole',
  components: {
    MiscPanel,
    LeftEyebrow,
    MainInstrument,
    InstrModePanel
  }
}
</script>
