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
</div>
</template>

<script>
import AvionicPowerPanel from '../panels/avionicpowerpanel/AvionicPowerPanel'
import HudPanel from '../panels/hudpanel/HudPanel'

export default {
  name: 'Avionics',
  components: {
    AvionicPowerPanel,
    HudPanel
  }
}
</script>
