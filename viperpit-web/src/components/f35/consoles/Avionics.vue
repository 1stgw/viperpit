<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-12">
    <avionic-power-panel />
  </div>
  </div>
</div>
</template>

<script>
import AvionicPowerPanel from '../panels/avionicpowerpanel/AvionicPowerPanel'

export default {
  name: 'Avionics',
  components: {
    AvionicPowerPanel
  }
}
</script>
