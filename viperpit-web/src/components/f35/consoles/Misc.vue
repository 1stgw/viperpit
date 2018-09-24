<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <other-cockpit-callbacks />
  </div>
  <div class="col-sm-6">
    <simulation-hardware />
  </div>
  </div>
</div>
</template>

<script>
import OtherCockpitCallbacks from '../panels/othercockpitcallbacks/OtherCockpitCallbacks'
import SimulationHardware from '../panels/simulationhardware/SimulationHardware'

export default {
  name: 'Misc',
  components: {
    OtherCockpitCallbacks,
    SimulationHardware
  }
}
</script>
