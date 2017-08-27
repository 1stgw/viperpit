<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <alt-gear-control />
  </div>
  <div class="col-sm-6">
    <hmcs-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <gear-panel />
  </div>
  </div>
</div>
</template>

<script>
import AltGearControl from '../panels/altgearcontrol/AltGearControl'
import HmcsPanel from '../panels/hmcspanel/HmcsPanel'
import GearPanel from '../panels/gearpanel/GearPanel'

export default {
  name: 'LeftAuxConsole',
  components: {
    AltGearControl,
    HmcsPanel,
    GearPanel
  }
}
</script>
