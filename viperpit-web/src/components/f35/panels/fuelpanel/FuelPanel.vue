<template>
  <div class="panel panel-default">
    <div class="panel-heading">FUEL PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <fuel-master-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <fuel-eng-feed-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <fuel-air-refuel-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FuelMasterSwitch from './FuelMasterSwitch'
import FuelEngFeedKnob from './FuelEngFeedKnob'
import FuelAirRefuelSwitch from './FuelAirRefuelSwitch'

export default {
  name: 'FuelPanel',
  components: {
    FuelMasterSwitch,
    FuelEngFeedKnob,
    FuelAirRefuelSwitch
  }
}
</script>
