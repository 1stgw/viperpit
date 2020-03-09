<template>
  <div class="panel panel-default">
    <div class="panel-heading">HUD PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hud-scales-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hud-fpm-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hud-ded-data-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hud-depr-ret-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hud-velocity-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hud-altitude-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hud-brightness-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HudScalesSwitch from "./HudScalesSwitch";
import HudFpmSwitch from "./HudFpmSwitch";
import HudDedDataSwitch from "./HudDedDataSwitch";
import HudDeprRetSwitch from "./HudDeprRetSwitch";
import HudVelocitySwitch from "./HudVelocitySwitch";
import HudAltitudeSwitch from "./HudAltitudeSwitch";
import HudBrightnessSwitch from "./HudBrightnessSwitch";

export default {
  name: "HudPanel",
  components: {
    HudScalesSwitch,
    HudFpmSwitch,
    HudDedDataSwitch,
    HudDeprRetSwitch,
    HudVelocitySwitch,
    HudAltitudeSwitch,
    HudBrightnessSwitch
  }
};
</script>
