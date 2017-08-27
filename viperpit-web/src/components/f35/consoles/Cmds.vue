<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <cmds-panel />
  </div>
  <div class="col-sm-6">
    <twa-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <twp />
  </div>
  <div class="col-sm-6">
    <rwr />
  </div>
  </div>
</div>
</template>

<script>
import CmdsPanel from '../panels/cmdspanel/CmdsPanel'
import TwaPanel from '../panels/twapanel/TwaPanel'
import Twp from '../panels/twp/Twp'
import Rwr from '../panels/rwr/Rwr'

export default {
  name: 'Cmds',
  components: {
    CmdsPanel,
    TwaPanel,
    Twp,
    Rwr
  }
}
</script>
