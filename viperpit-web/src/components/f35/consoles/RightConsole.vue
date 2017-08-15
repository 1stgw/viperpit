<template>
<div class="container-fluid">
  <h2>Right Console</h2>
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
import SnsrPwrPanel from '../panels/snsrpwrpanel/SnsrPwrPanel'
import HudPanel from '../panels/hudpanel/HudPanel'
import LightingPanel from '../panels/lightingpanel/LightingPanel'
import AirCondPanel from '../panels/aircondpanel/AirCondPanel'
import ZeroizePanel from '../panels/zeroizepanel/ZeroizePanel'
import AvionicPowerPanel from '../panels/avionicpowerpanel/AvionicPowerPanel'
import OxygenPanel from '../panels/oxygenpanel/OxygenPanel'

export default {
  name: 'RightConsole',
  components: {
    SnsrPwrPanel,
    HudPanel,
    LightingPanel,
    AirCondPanel,
    ZeroizePanel,
    AvionicPowerPanel,
    OxygenPanel
  }
}
</script>
