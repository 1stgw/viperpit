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
        <twp />
      </div>
      <div class="col-sm-6">
        <rwr />
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
    <div class="row">
      <div class="col-sm-12">
        <fuel-qty-panel />
      </div>
    </div>
  </div>
</template>

<script>
import MiscPanel from "@/components/f16/panels/MiscPanel";
import LeftEyebrow from "@/components/f16/panels/LeftEyebrow";
import Twp from "@/components/f16/panels/Twp";
import Rwr from "@/components/f16/panels/Rwr";
import MainInstrument from "@/components/f16/panels/MainInstrument";
import InstrModePanel from "@/components/f16/panels/InstrModePanel";
import FuelQtyPanel from "@/components/f16/panels/FuelQtyPanel";

export default {
  name: "CenterConsole",
  components: {
    MiscPanel,
    LeftEyebrow,
    Twp,
    Rwr,
    MainInstrument,
    InstrModePanel,
    FuelQtyPanel
  }
};
</script>
