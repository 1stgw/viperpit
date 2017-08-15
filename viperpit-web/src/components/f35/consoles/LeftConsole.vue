<template>
<div class="container-fluid">
  <h2>Left Console</h2>
  <div class="row">
  <div class="col-sm-6">
    <test-panel />
  </div>
  <div class="col-sm-6">
    <flt-control-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <manual-trim-panel />
  </div>
  <div class="col-sm-6">
    <fuel-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <aux-comm-panel />
  </div>
  <div class="col-sm-6">
    <ext-lighting-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <epu-panel />
  </div>
  <div class="col-sm-6">
    <elec-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <avtr-panel />
  </div>
  <div class="col-sm-6">
    <ecm-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <eng-jet-start-panel />
  </div>
  <div class="col-sm-6">
    <audio2-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <audio1-panel />
  </div>
  <div class="col-sm-6">
    <mpo-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <uhf-panel />
  </div>
  <div class="col-sm-6">
    <left-side-wall />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <seat />
  </div>
  </div>
</div>
</template>

<script>
import TestPanel from '../panels/testpanel/TestPanel'
import FltControlPanel from '../panels/fltcontrolpanel/FltControlPanel'
import ManualTrimPanel from '../panels/manualtrimpanel/ManualTrimPanel'
import FuelPanel from '../panels/fuelpanel/FuelPanel'
import AuxCommPanel from '../panels/auxcommpanel/AuxCommPanel'
import ExtLightingPanel from '../panels/extlightingpanel/ExtLightingPanel'
import EpuPanel from '../panels/epupanel/EpuPanel'
import ElecPanel from '../panels/elecpanel/ElecPanel'
import AvtrPanel from '../panels/avtrpanel/AvtrPanel'
import EcmPanel from '../panels/ecmpanel/EcmPanel'
import EngJetStartPanel from '../panels/engjetstartpanel/EngJetStartPanel'
import Audio2Panel from '../panels/audio2panel/Audio2Panel'
import Audio1Panel from '../panels/audio1panel/Audio1Panel'
import MpoPanel from '../panels/mpopanel/MpoPanel'
import UhfPanel from '../panels/uhfpanel/UhfPanel'
import LeftSideWall from '../panels/leftsidewall/LeftSideWall'
import Seat from '../panels/seat/Seat'

export default {
  name: 'LeftConsole',
  components: {
    TestPanel,
    FltControlPanel,
    ManualTrimPanel,
    FuelPanel,
    AuxCommPanel,
    ExtLightingPanel,
    EpuPanel,
    ElecPanel,
    AvtrPanel,
    EcmPanel,
    EngJetStartPanel,
    Audio2Panel,
    Audio1Panel,
    MpoPanel,
    UhfPanel,
    LeftSideWall,
    Seat
  }
}
</script>
