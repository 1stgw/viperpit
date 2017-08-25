<template>
  <div class="panel panel-default">
    <div class="panel-heading">EXT LIGHTING PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <ext-master-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <ext-wing-tail-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <ext-position-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <ext-anti-collision-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ExtMasterSwitch from './ExtMasterSwitch'
import ExtWingTailSwitch from './ExtWingTailSwitch'
import ExtPositionSwitch from './ExtPositionSwitch'
import ExtAntiCollisionSwitch from './ExtAntiCollisionSwitch'

export default {
  name: 'ExtLightingPanel',
  components: {
    ExtMasterSwitch,
    ExtWingTailSwitch,
    ExtPositionSwitch,
    ExtAntiCollisionSwitch
  }
}
</script>
