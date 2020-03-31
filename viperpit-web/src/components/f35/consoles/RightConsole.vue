<template>
  <v-container>
    <v-row>
      <v-col>
        <snsr-pwr-panel />
      </v-col>
      <v-col>
        <hud-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <lighting-panel />
      </v-col>
      <v-col>
        <air-cond-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <zeroize-panel />
      </v-col>
      <v-col>
        <avionic-power-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <oxygen-panel />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SnsrPwrPanel from "@/components/f35/panels/SnsrPwrPanel";
import HudPanel from "@/components/f35/panels/HudPanel";
import LightingPanel from "@/components/f35/panels/LightingPanel";
import AirCondPanel from "@/components/f35/panels/AirCondPanel";
import ZeroizePanel from "@/components/f35/panels/ZeroizePanel";
import AvionicPowerPanel from "@/components/f35/panels/AvionicPowerPanel";
import OxygenPanel from "@/components/f35/panels/OxygenPanel";

export default {
  name: "RightConsole",
  components: {
    SnsrPwrPanel,
    HudPanel,
    LightingPanel,
    AirCondPanel,
    ZeroizePanel,
    AvionicPowerPanel,
    OxygenPanel
  }
};
</script>
