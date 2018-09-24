<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <left-eyebrow />
  </div>
  <div class="col-sm-6">
    <seat />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-12">
    <zeroize-panel />
  </div>
  </div>
</div>
</template>

<script>
import LeftEyebrow from '../panels/lefteyebrow/LeftEyebrow'
import Seat from '../panels/seat/Seat'
import ZeroizePanel from '../panels/zeroizepanel/ZeroizePanel'

export default {
  name: 'Emer',
  components: {
    LeftEyebrow,
    Seat,
    ZeroizePanel
  }
}
</script>
