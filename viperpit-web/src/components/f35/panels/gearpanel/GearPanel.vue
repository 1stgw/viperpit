<template>
  <div class="panel panel-default">
    <div class="panel-heading">GEAR PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <gear-hook-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <gear-gnd-jett-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <gear-parking-break-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <gear-lg-handle />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <gear-horn-silencer-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <gear-lights-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <alt-gear-extend-alt-gear />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <alt-gear-reset-alt-gear />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GearHookSwitch from './GearHookSwitch'
import GearGndJettSwitch from './GearGndJettSwitch'
import GearParkingBreakSwitch from './GearParkingBreakSwitch'
import GearLgHandle from './GearLgHandle'
import GearHornSilencerButton from './GearHornSilencerButton'
import GearLightsSwitch from './GearLightsSwitch'
import AltGearExtendAltGear from './AltGearExtendAltGear'
import AltGearResetAltGear from './AltGearResetAltGear'

export default {
  name: 'GearPanel',
  components: {
    GearHookSwitch,
    GearGndJettSwitch,
    GearParkingBreakSwitch,
    GearLgHandle,
    GearHornSilencerButton,
    GearLightsSwitch,
    AltGearExtendAltGear,
    AltGearResetAltGear
  }
}
</script>
