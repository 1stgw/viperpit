<template>
  <div class="card card-default">
    <div class="card-heading">EXT LIGHTING PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <ext-anti-collision-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <ext-position-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <ext-wing-tail-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <ext-master-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ExtAntiCollisionSwitch from "./ExtAntiCollisionSwitch";
import ExtPositionSwitch from "./ExtPositionSwitch";
import ExtWingTailSwitch from "./ExtWingTailSwitch";
import ExtMasterSwitch from "./ExtMasterSwitch";

export default {
  name: "ExtLightingPanel",
  components: {
    ExtAntiCollisionSwitch,
    ExtPositionSwitch,
    ExtWingTailSwitch,
    ExtMasterSwitch
  }
};
</script>
