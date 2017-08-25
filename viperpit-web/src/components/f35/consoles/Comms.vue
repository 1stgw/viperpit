<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <uhf-panel />
  </div>
  <div class="col-sm-6">
    <audio1-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <audio2-panel />
  </div>
  <div class="col-sm-6">
    <aux-comm-panel />
  </div>
  </div>
</div>
</template>

<script>
import UhfPanel from '../panels/uhfpanel/UhfPanel'
import Audio1Panel from '../panels/audio1panel/Audio1Panel'
import Audio2Panel from '../panels/audio2panel/Audio2Panel'
import AuxCommPanel from '../panels/auxcommpanel/AuxCommPanel'

export default {
  name: 'Comms',
  components: {
    UhfPanel,
    Audio1Panel,
    Audio2Panel,
    AuxCommPanel
  }
}
</script>
