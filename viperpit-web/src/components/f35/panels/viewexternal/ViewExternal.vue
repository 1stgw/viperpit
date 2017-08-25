<template>
  <div class="panel panel-default">
    <div class="panel-heading">VIEW EXTERNAL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewext-chase-camera />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewext-flyby-camera />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewext-satellite-camera />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <viewext-orbit-camera />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ViewextChaseCamera from './ViewextChaseCamera'
import ViewextFlybyCamera from './ViewextFlybyCamera'
import ViewextSatelliteCamera from './ViewextSatelliteCamera'
import ViewextOrbitCamera from './ViewextOrbitCamera'

export default {
  name: 'ViewExternal',
  components: {
    ViewextChaseCamera,
    ViewextFlybyCamera,
    ViewextSatelliteCamera,
    ViewextOrbitCamera
  }
}
</script>
