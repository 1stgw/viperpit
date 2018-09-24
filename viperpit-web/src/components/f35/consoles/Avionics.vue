<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <avionic-power-panel />
  </div>
  <div class="col-sm-6">
    <hud-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <hmcs-panel />
  </div>
  </div>
</div>
</template>

<script>
import AvionicPowerPanel from '../panels/avionicpowerpanel/AvionicPowerPanel'
import HudPanel from '../panels/hudpanel/HudPanel'
import HmcsPanel from '../panels/hmcspanel/HmcsPanel'

export default {
  name: 'Avionics',
  components: {
    AvionicPowerPanel,
    HudPanel,
    HmcsPanel
  }
}
</script>
