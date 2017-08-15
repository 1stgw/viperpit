<template>
  <div class="panel panel-default">
    <div class="panel-heading">EXT LIGHTING PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <ext-anti-collision-switch />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <ext-position-switch />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <ext-wing-tail-switch />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <ext-master-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ExtAntiCollisionSwitch from './ExtAntiCollisionSwitch'
import ExtPositionSwitch from './ExtPositionSwitch'
import ExtWingTailSwitch from './ExtWingTailSwitch'
import ExtMasterSwitch from './ExtMasterSwitch'

export default {
  name: 'ExtLightingPanel',
  components: {
    ExtAntiCollisionSwitch,
    ExtPositionSwitch,
    ExtWingTailSwitch,
    ExtMasterSwitch
  }
}
</script>
