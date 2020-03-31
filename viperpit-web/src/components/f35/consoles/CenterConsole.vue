<template>
  <v-container>
    <v-row>
      <v-col>
        <misc-panel />
      </v-col>
      <v-col>
        <left-eyebrow />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <twp />
      </v-col>
      <v-col>
        <rwr />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <main-instrument />
      </v-col>
      <v-col>
        <instr-mode-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <fuel-qty-panel />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import MiscPanel from "@/components/f35/panels/MiscPanel";
import LeftEyebrow from "@/components/f35/panels/LeftEyebrow";
import Twp from "@/components/f35/panels/Twp";
import Rwr from "@/components/f35/panels/Rwr";
import MainInstrument from "@/components/f35/panels/MainInstrument";
import InstrModePanel from "@/components/f35/panels/InstrModePanel";
import FuelQtyPanel from "@/components/f35/panels/FuelQtyPanel";

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
