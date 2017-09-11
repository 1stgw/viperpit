<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <flt-control-panel />
  </div>
  <div class="col-sm-6">
    <manual-trim-panel />
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
    <eng-jet-start-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <mpo-panel />
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
import FltControlPanel from '../panels/fltcontrolpanel/FltControlPanel'
import ManualTrimPanel from '../panels/manualtrimpanel/ManualTrimPanel'
import EpuPanel from '../panels/epupanel/EpuPanel'
import ElecPanel from '../panels/elecpanel/ElecPanel'
import AvtrPanel from '../panels/avtrpanel/AvtrPanel'
import EngJetStartPanel from '../panels/engjetstartpanel/EngJetStartPanel'
import MpoPanel from '../panels/mpopanel/MpoPanel'
import LeftSideWall from '../panels/leftsidewall/LeftSideWall'
import Seat from '../panels/seat/Seat'

export default {
  name: 'LeftConsole',
  components: {
    FltControlPanel,
    ManualTrimPanel,
    EpuPanel,
    ElecPanel,
    AvtrPanel,
    EngJetStartPanel,
    MpoPanel,
    LeftSideWall,
    Seat
  }
}
</script>
