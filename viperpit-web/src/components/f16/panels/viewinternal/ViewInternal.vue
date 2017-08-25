<template>
  <div class="panel panel-default">
    <div class="panel-heading">VIEW INTERNAL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewint-glance-backward />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewint-glance-forward />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewint-pan3d-cockpit />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewint-snap3d-cockpit />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewint-hud-only />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewint-padlock />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ViewintGlanceBackward from './ViewintGlanceBackward'
import ViewintGlanceForward from './ViewintGlanceForward'
import ViewintPan3dCockpit from './ViewintPan3dCockpit'
import ViewintSnap3dCockpit from './ViewintSnap3dCockpit'
import ViewintHudOnly from './ViewintHudOnly'
import ViewintPadlock from './ViewintPadlock'

export default {
  name: 'ViewInternal',
  components: {
    ViewintGlanceBackward,
    ViewintGlanceForward,
    ViewintPan3dCockpit,
    ViewintSnap3dCockpit,
    ViewintHudOnly,
    ViewintPadlock
  }
}
</script>
