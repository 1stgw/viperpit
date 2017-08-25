<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <seat />
  </div>
  <div class="col-sm-6">
    <left-side-wall />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <uhf-panel />
  </div>
  <div class="col-sm-6">
    <mpo-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <audio1-panel />
  </div>
  <div class="col-sm-6">
    <audio2-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <eng-jet-start-panel />
  </div>
  <div class="col-sm-6">
    <ecm-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <avtr-panel />
  </div>
  <div class="col-sm-6">
    <elec-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <epu-panel />
  </div>
  <div class="col-sm-6">
    <ext-lighting-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <aux-comm-panel />
  </div>
  <div class="col-sm-6">
    <fuel-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <manual-trim-panel />
  </div>
  <div class="col-sm-6">
    <flt-control-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <test-panel />
  </div>
  </div>
</div>
</template>

<script>
import Seat from '../panels/seat/Seat'
import LeftSideWall from '../panels/leftsidewall/LeftSideWall'
import UhfPanel from '../panels/uhfpanel/UhfPanel'
import MpoPanel from '../panels/mpopanel/MpoPanel'
import Audio1Panel from '../panels/audio1panel/Audio1Panel'
import Audio2Panel from '../panels/audio2panel/Audio2Panel'
import EngJetStartPanel from '../panels/engjetstartpanel/EngJetStartPanel'
import EcmPanel from '../panels/ecmpanel/EcmPanel'
import AvtrPanel from '../panels/avtrpanel/AvtrPanel'
import ElecPanel from '../panels/elecpanel/ElecPanel'
import EpuPanel from '../panels/epupanel/EpuPanel'
import ExtLightingPanel from '../panels/extlightingpanel/ExtLightingPanel'
import AuxCommPanel from '../panels/auxcommpanel/AuxCommPanel'
import FuelPanel from '../panels/fuelpanel/FuelPanel'
import ManualTrimPanel from '../panels/manualtrimpanel/ManualTrimPanel'
import FltControlPanel from '../panels/fltcontrolpanel/FltControlPanel'
import TestPanel from '../panels/testpanel/TestPanel'

export default {
  name: 'LeftConsole',
  components: {
    Seat,
    LeftSideWall,
    UhfPanel,
    MpoPanel,
    Audio1Panel,
    Audio2Panel,
    EngJetStartPanel,
    EcmPanel,
    AvtrPanel,
    ElecPanel,
    EpuPanel,
    ExtLightingPanel,
    AuxCommPanel,
    FuelPanel,
    ManualTrimPanel,
    FltControlPanel,
    TestPanel
  }
}
</script>
