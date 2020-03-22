<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6">
        <snsr-pwr-panel />
      </div>
      <div class="col-sm-6">
        <hud-panel />
      </div>
    </div>
    <div class="row">
      <div class="col-sm-6">
        <lighting-panel />
      </div>
      <div class="col-sm-6">
        <air-cond-panel />
      </div>
    </div>
    <div class="row">
      <div class="col-sm-6">
        <zeroize-panel />
      </div>
      <div class="col-sm-6">
        <avionic-power-panel />
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12">
        <oxygen-panel />
      </div>
    </div>
  </div>
</template>

<script>
import SnsrPwrPanel from "@/components/f16/panels/SnsrPwrPanel";
import HudPanel from "@/components/f16/panels/HudPanel";
import LightingPanel from "@/components/f16/panels/LightingPanel";
import AirCondPanel from "@/components/f16/panels/AirCondPanel";
import ZeroizePanel from "@/components/f16/panels/ZeroizePanel";
import AvionicPowerPanel from "@/components/f16/panels/AvionicPowerPanel";
import OxygenPanel from "@/components/f16/panels/OxygenPanel";

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
