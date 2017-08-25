<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <rwr />
  </div>
  <div class="col-sm-6">
    <twp />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <twa-panel />
  </div>
  <div class="col-sm-6">
    <cmds-panel />
  </div>
  </div>
</div>
</template>

<script>
import Rwr from '../panels/rwr/Rwr'
import Twp from '../panels/twp/Twp'
import TwaPanel from '../panels/twapanel/TwaPanel'
import CmdsPanel from '../panels/cmdspanel/CmdsPanel'

export default {
  name: 'Cmds',
  components: {
    Rwr,
    Twp,
    TwaPanel,
    CmdsPanel
  }
}
</script>
