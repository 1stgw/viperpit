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
    <mpo-panel />
  </div>
  <div class="col-sm-6">
    <eng-jet-start-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <ecm-panel />
  </div>
  <div class="col-sm-6">
    <avtr-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <elec-panel />
  </div>
  <div class="col-sm-6">
    <epu-panel />
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
</div>
</template>

<script>
import Seat from '../panels/seat/Seat'
import LeftSideWall from '../panels/leftsidewall/LeftSideWall'
import MpoPanel from '../panels/mpopanel/MpoPanel'
import EngJetStartPanel from '../panels/engjetstartpanel/EngJetStartPanel'
import EcmPanel from '../panels/ecmpanel/EcmPanel'
import AvtrPanel from '../panels/avtrpanel/AvtrPanel'
import ElecPanel from '../panels/elecpanel/ElecPanel'
import EpuPanel from '../panels/epupanel/EpuPanel'
import ManualTrimPanel from '../panels/manualtrimpanel/ManualTrimPanel'
import FltControlPanel from '../panels/fltcontrolpanel/FltControlPanel'

export default {
  name: 'LeftConsole',
  components: {
    Seat,
    LeftSideWall,
    MpoPanel,
    EngJetStartPanel,
    EcmPanel,
    AvtrPanel,
    ElecPanel,
    EpuPanel,
    ManualTrimPanel,
    FltControlPanel
  }
}
</script>
