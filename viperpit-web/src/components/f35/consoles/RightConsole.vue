<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <air-cond-panel />
  </div>
  <div class="col-sm-6">
    <zeroize-panel />
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
import AirCondPanel from '../panels/aircondpanel/AirCondPanel'
import ZeroizePanel from '../panels/zeroizepanel/ZeroizePanel'
import OxygenPanel from '../panels/oxygenpanel/OxygenPanel'

export default {
  name: 'RightConsole',
  components: {
    AirCondPanel,
    ZeroizePanel,
    OxygenPanel
  }
}
</script>
