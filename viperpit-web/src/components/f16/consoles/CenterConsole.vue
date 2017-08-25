<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <fuel-qty-panel />
  </div>
  <div class="col-sm-6">
    <instr-mode-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <main-instrument />
  </div>
  <div class="col-sm-6">
    <rwr />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <twp />
  </div>
  <div class="col-sm-6">
    <left-eyebrow />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <misc-panel />
  </div>
  </div>
</div>
</template>

<script>
import FuelQtyPanel from '../panels/fuelqtypanel/FuelQtyPanel'
import InstrModePanel from '../panels/instrmodepanel/InstrModePanel'
import MainInstrument from '../panels/maininstrument/MainInstrument'
import Rwr from '../panels/rwr/Rwr'
import Twp from '../panels/twp/Twp'
import LeftEyebrow from '../panels/lefteyebrow/LeftEyebrow'
import MiscPanel from '../panels/miscpanel/MiscPanel'

export default {
  name: 'CenterConsole',
  components: {
    FuelQtyPanel,
    InstrModePanel,
    MainInstrument,
    Rwr,
    Twp,
    LeftEyebrow,
    MiscPanel
  }
}
</script>
