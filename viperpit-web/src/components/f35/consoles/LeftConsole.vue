<template>
  <v-container>
    <v-row>
      <v-col>
        <test-panel />
      </v-col>
      <v-col>
        <flt-control-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <manual-trim-panel />
      </v-col>
      <v-col>
        <fuel-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <aux-comm-panel />
      </v-col>
      <v-col>
        <ext-lighting-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <epu-panel />
      </v-col>
      <v-col>
        <elec-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <avtr-panel />
      </v-col>
      <v-col>
        <ecm-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <eng-jet-start-panel />
      </v-col>
      <v-col>
        <audio2-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <audio1-panel />
      </v-col>
      <v-col>
        <mpo-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <uhf-panel />
      </v-col>
      <v-col>
        <left-side-wall />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <seat />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import TestPanel from "@/components/f35/panels/TestPanel";
import FltControlPanel from "@/components/f35/panels/FltControlPanel";
import ManualTrimPanel from "@/components/f35/panels/ManualTrimPanel";
import FuelPanel from "@/components/f35/panels/FuelPanel";
import AuxCommPanel from "@/components/f35/panels/AuxCommPanel";
import ExtLightingPanel from "@/components/f35/panels/ExtLightingPanel";
import EpuPanel from "@/components/f35/panels/EpuPanel";
import ElecPanel from "@/components/f35/panels/ElecPanel";
import AvtrPanel from "@/components/f35/panels/AvtrPanel";
import EcmPanel from "@/components/f35/panels/EcmPanel";
import EngJetStartPanel from "@/components/f35/panels/EngJetStartPanel";
import Audio2Panel from "@/components/f35/panels/Audio2Panel";
import Audio1Panel from "@/components/f35/panels/Audio1Panel";
import MpoPanel from "@/components/f35/panels/MpoPanel";
import UhfPanel from "@/components/f35/panels/UhfPanel";
import LeftSideWall from "@/components/f35/panels/LeftSideWall";
import Seat from "@/components/f35/panels/Seat";

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
