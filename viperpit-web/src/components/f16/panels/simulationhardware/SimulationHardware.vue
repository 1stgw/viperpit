<template>
  <div class="panel panel-default">
    <div class="panel-heading">SIMULATION & HARDWARE</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <sim-time-acceleration />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <sim-chat />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <sim-toggle-exit-sim-menu />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SimTimeAcceleration from './SimTimeAcceleration'
import SimChat from './SimChat'
import SimToggleExitSimMenu from './SimToggleExitSimMenu'

export default {
  name: 'SimulationHardware',
  components: {
    SimTimeAcceleration,
    SimChat,
    SimToggleExitSimMenu
  }
}
</script>
