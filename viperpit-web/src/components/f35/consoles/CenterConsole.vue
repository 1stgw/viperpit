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
import MiscPanel from "../panels/miscpanel/MiscPanel";
import LeftEyebrow from "../panels/lefteyebrow/LeftEyebrow";
import Twp from "../panels/twp/Twp";
import Rwr from "../panels/rwr/Rwr";
import MainInstrument from "../panels/maininstrument/MainInstrument";
import InstrModePanel from "../panels/instrmodepanel/InstrModePanel";
import FuelQtyPanel from "../panels/fuelqtypanel/FuelQtyPanel";

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
