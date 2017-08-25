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
  <div class="col-sm-12">
    <hud-panel />
  </div>
  </div>
</div>
</template>

<script>
import OxygenPanel from '../panels/oxygenpanel/OxygenPanel'
import AvionicPowerPanel from '../panels/avionicpowerpanel/AvionicPowerPanel'
import ZeroizePanel from '../panels/zeroizepanel/ZeroizePanel'
import AirCondPanel from '../panels/aircondpanel/AirCondPanel'
import HudPanel from '../panels/hudpanel/HudPanel'

export default {
  name: 'RightConsole',
  components: {
    OxygenPanel,
    AvionicPowerPanel,
    ZeroizePanel,
    AirCondPanel,
    HudPanel
  }
}
</script>
