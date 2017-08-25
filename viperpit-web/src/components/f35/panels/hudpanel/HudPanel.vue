<template>
  <div class="panel panel-default">
    <div class="panel-heading">HUD  PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <hud-brightness-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <hud-altitude-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <hud-velocity-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <hud-depr-ret-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <hud-ded-data-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <hud-fpm-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <hud-scales-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HudBrightnessSwitch from './HudBrightnessSwitch'
import HudAltitudeSwitch from './HudAltitudeSwitch'
import HudVelocitySwitch from './HudVelocitySwitch'
import HudDeprRetSwitch from './HudDeprRetSwitch'
import HudDedDataSwitch from './HudDedDataSwitch'
import HudFpmSwitch from './HudFpmSwitch'
import HudScalesSwitch from './HudScalesSwitch'

export default {
  name: 'HudPanel',
  components: {
    HudBrightnessSwitch,
    HudAltitudeSwitch,
    HudVelocitySwitch,
    HudDeprRetSwitch,
    HudDedDataSwitch,
    HudFpmSwitch,
    HudScalesSwitch
  }
}
</script>
