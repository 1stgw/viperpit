<template>
  <div class="container-fluid">
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
import TestPanel from "@/components/f16/panels/TestPanel";
import FltControlPanel from "@/components/f16/panels/FltControlPanel";
import ManualTrimPanel from "@/components/f16/panels/ManualTrimPanel";
import FuelPanel from "@/components/f16/panels/FuelPanel";
import AuxCommPanel from "@/components/f16/panels/AuxCommPanel";
import ExtLightingPanel from "@/components/f16/panels/ExtLightingPanel";
import EpuPanel from "@/components/f16/panels/EpuPanel";
import ElecPanel from "@/components/f16/panels/ElecPanel";
import AvtrPanel from "@/components/f16/panels/AvtrPanel";
import EcmPanel from "@/components/f16/panels/EcmPanel";
import EngJetStartPanel from "@/components/f16/panels/EngJetStartPanel";
import Audio2Panel from "@/components/f16/panels/Audio2Panel";
import Audio1Panel from "@/components/f16/panels/Audio1Panel";
import MpoPanel from "@/components/f16/panels/MpoPanel";
import UhfPanel from "@/components/f16/panels/UhfPanel";
import LeftSideWall from "@/components/f16/panels/LeftSideWall";
import Seat from "@/components/f16/panels/Seat";

export default {
  name: "LeftConsole",
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
};
</script>
