<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <lighting-panel />
  </div>
  <div class="col-sm-6">
    <ext-lighting-panel />
  </div>
  </div>
</div>
</template>

<script>
import LightingPanel from '../panels/lightingpanel/LightingPanel'
import ExtLightingPanel from '../panels/extlightingpanel/ExtLightingPanel'

export default {
  name: 'Lights',
  components: {
    LightingPanel,
    ExtLightingPanel
  }
}
</script>
