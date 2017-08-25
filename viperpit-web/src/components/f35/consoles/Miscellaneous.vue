<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <simulation-hardware />
  </div>
  <div class="col-sm-6">
    <other-cockpit-callbacks />
  </div>
  </div>
</div>
</template>

<script>
import SimulationHardware from '../panels/simulationhardware/SimulationHardware'
import OtherCockpitCallbacks from '../panels/othercockpitcallbacks/OtherCockpitCallbacks'

export default {
  name: 'Miscellaneous',
  components: {
    SimulationHardware,
    OtherCockpitCallbacks
  }
}
</script>
