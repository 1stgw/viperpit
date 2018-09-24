<template>
  <div class="panel panel-default">
    <div class="panel-heading">AUX COMM PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-cni-knob-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-channel />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-station-selector-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AuxCniKnobSwitch from './AuxCniKnobSwitch'
import AuxChannel from './AuxChannel'
import AuxStationSelectorSwitch from './AuxStationSelectorSwitch'

export default {
  name: 'AuxCommPanel',
  components: {
    AuxCniKnobSwitch,
    AuxChannel,
    AuxStationSelectorSwitch
  }
}
</script>
