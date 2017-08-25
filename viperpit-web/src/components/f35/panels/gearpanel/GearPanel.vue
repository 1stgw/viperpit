<template>
  <div class="panel panel-default">
    <div class="panel-heading">GEAR PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-lights-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-horn-silencer-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-stores-config-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-lg-handle />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-parking-break-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-gnd-jett-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-hook-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <gear-emer-stores-jettison-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GearLightsSwitch from './GearLightsSwitch'
import GearHornSilencerButton from './GearHornSilencerButton'
import GearStoresConfigSwitch from './GearStoresConfigSwitch'
import GearLgHandle from './GearLgHandle'
import GearParkingBreakSwitch from './GearParkingBreakSwitch'
import GearGndJettSwitch from './GearGndJettSwitch'
import GearHookSwitch from './GearHookSwitch'
import GearEmerStoresJettisonButton from './GearEmerStoresJettisonButton'

export default {
  name: 'GearPanel',
  components: {
    GearLightsSwitch,
    GearHornSilencerButton,
    GearStoresConfigSwitch,
    GearLgHandle,
    GearParkingBreakSwitch,
    GearGndJettSwitch,
    GearHookSwitch,
    GearEmerStoresJettisonButton
  }
}
</script>
