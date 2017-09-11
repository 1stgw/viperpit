<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <misc-panel />
  </div>
  <div class="col-sm-6">
    <left-eyebrow />
  </div>
  </div>
</div>
</template>

<script>
import MiscPanel from '../panels/miscpanel/MiscPanel'
import LeftEyebrow from '../panels/lefteyebrow/LeftEyebrow'

export default {
  name: 'CenterConsole',
  components: {
    MiscPanel,
    LeftEyebrow
  }
}
</script>
