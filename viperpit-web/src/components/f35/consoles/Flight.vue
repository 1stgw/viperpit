<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <gear-panel />
  </div>
  <div class="col-sm-6">
    <alt-gear-control />
  </div>
  </div>
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
  <div class="col-sm-6">
    <air-cond-panel />
  </div>
  <div class="col-sm-6">
    <oxygen-panel />
  </div>
  </div>
</div>
</template>

<script>
import GearPanel from '../panels/gearpanel/GearPanel'
import AltGearControl from '../panels/altgearcontrol/AltGearControl'
import FltControlPanel from '../panels/fltcontrolpanel/FltControlPanel'
import ManualTrimPanel from '../panels/manualtrimpanel/ManualTrimPanel'
import EpuPanel from '../panels/epupanel/EpuPanel'
import ElecPanel from '../panels/elecpanel/ElecPanel'
import AvtrPanel from '../panels/avtrpanel/AvtrPanel'
import EngJetStartPanel from '../panels/engjetstartpanel/EngJetStartPanel'
import MpoPanel from '../panels/mpopanel/MpoPanel'
import LeftSideWall from '../panels/leftsidewall/LeftSideWall'
import AirCondPanel from '../panels/aircondpanel/AirCondPanel'
import OxygenPanel from '../panels/oxygenpanel/OxygenPanel'

export default {
  name: 'Flight',
  components: {
    GearPanel,
    AltGearControl,
    FltControlPanel,
    ManualTrimPanel,
    EpuPanel,
    ElecPanel,
    AvtrPanel,
    EngJetStartPanel,
    MpoPanel,
    LeftSideWall,
    AirCondPanel,
    OxygenPanel
  }
}
</script>
