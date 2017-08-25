<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <oxygen-panel />
  </div>
  <div class="col-sm-6">
    <avionic-power-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <zeroize-panel />
  </div>
  <div class="col-sm-6">
    <air-cond-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <lighting-panel />
  </div>
  <div class="col-sm-6">
    <hud-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <snsr-pwr-panel />
  </div>
  </div>
</div>
</template>

<script>
import OxygenPanel from '../panels/oxygenpanel/OxygenPanel'
import AvionicPowerPanel from '../panels/avionicpowerpanel/AvionicPowerPanel'
import ZeroizePanel from '../panels/zeroizepanel/ZeroizePanel'
import AirCondPanel from '../panels/aircondpanel/AirCondPanel'
import LightingPanel from '../panels/lightingpanel/LightingPanel'
import HudPanel from '../panels/hudpanel/HudPanel'
import SnsrPwrPanel from '../panels/snsrpwrpanel/SnsrPwrPanel'

export default {
  name: 'RightConsole',
  components: {
    OxygenPanel,
    AvionicPowerPanel,
    ZeroizePanel,
    AirCondPanel,
    LightingPanel,
    HudPanel,
    SnsrPwrPanel
  }
}
</script>
