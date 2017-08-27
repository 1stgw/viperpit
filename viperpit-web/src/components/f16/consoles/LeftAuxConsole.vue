<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <alt-gear-control />
  </div>
  <div class="col-sm-6">
    <twa-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <hmcs-panel />
  </div>
  <div class="col-sm-6">
    <cmds-panel />
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
import TwaPanel from '../panels/twapanel/TwaPanel'
import HmcsPanel from '../panels/hmcspanel/HmcsPanel'
import CmdsPanel from '../panels/cmdspanel/CmdsPanel'
import GearPanel from '../panels/gearpanel/GearPanel'

export default {
  name: 'LeftAuxConsole',
  components: {
    AltGearControl,
    TwaPanel,
    HmcsPanel,
    CmdsPanel,
    GearPanel
  }
}
</script>
