<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <aux-comm-panel />
  </div>
  <div class="col-sm-6">
    <audio2-panel />
  </div>
  </div>
  <div class="row">
  <div class="col-sm-6">
    <audio1-panel />
  </div>
  <div class="col-sm-6">
    <uhf-panel />
  </div>
  </div>
</div>
</template>

<script>
import AuxCommPanel from '../panels/auxcommpanel/AuxCommPanel'
import Audio2Panel from '../panels/audio2panel/Audio2Panel'
import Audio1Panel from '../panels/audio1panel/Audio1Panel'
import UhfPanel from '../panels/uhfpanel/UhfPanel'

export default {
  name: 'Comms',
  components: {
    AuxCommPanel,
    Audio2Panel,
    Audio1Panel,
    UhfPanel
  }
}
</script>
