<template>
  <div class="panel panel-default">
    <div class="panel-heading">SIMULATION & HARDWARE</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <sim-toggle-exit-sim-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <sim-chat />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <sim-time-acceleration />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SimToggleExitSimMenu from './SimToggleExitSimMenu'
import SimChat from './SimChat'
import SimTimeAcceleration from './SimTimeAcceleration'

export default {
  name: 'SimulationHardware',
  components: {
    SimToggleExitSimMenu,
    SimChat,
    SimTimeAcceleration
  }
}
</script>
