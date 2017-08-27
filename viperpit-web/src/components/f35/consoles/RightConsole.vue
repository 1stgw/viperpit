<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <hud-panel />
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
import HudPanel from '../panels/hudpanel/HudPanel'
import AirCondPanel from '../panels/aircondpanel/AirCondPanel'
import ZeroizePanel from '../panels/zeroizepanel/ZeroizePanel'
import AvionicPowerPanel from '../panels/avionicpowerpanel/AvionicPowerPanel'
import OxygenPanel from '../panels/oxygenpanel/OxygenPanel'

export default {
  name: 'RightConsole',
  components: {
    HudPanel,
    AirCondPanel,
    ZeroizePanel,
    AvionicPowerPanel,
    OxygenPanel
  }
}
</script>
