<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <gear-panel />
  </div>
  <div class="col-sm-6">
    <cmds-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <hmcs-panel />
  </div>
  <div class="col-sm-6">
    <twa-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <alt-gear-control />
  </div>
  </div>
</div>
</template>

<script>
import GearPanel from '../panels/gearpanel/GearPanel'
import CmdsPanel from '../panels/cmdspanel/CmdsPanel'
import HmcsPanel from '../panels/hmcspanel/HmcsPanel'
import TwaPanel from '../panels/twapanel/TwaPanel'
import AltGearControl from '../panels/altgearcontrol/AltGearControl'

export default {
  name: 'LeftAuxConsole',
  components: {
    GearPanel,
    CmdsPanel,
    HmcsPanel,
    TwaPanel,
    AltGearControl
  }
}
</script>
