<template>
  <div class="panel panel-default">
    <div class="panel-heading">VIEW EXTERNAL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewext-orbit-camera />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewext-satellite-camera />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewext-flyby-camera />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <viewext-chase-camera />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ViewextOrbitCamera from './ViewextOrbitCamera'
import ViewextSatelliteCamera from './ViewextSatelliteCamera'
import ViewextFlybyCamera from './ViewextFlybyCamera'
import ViewextChaseCamera from './ViewextChaseCamera'

export default {
  name: 'ViewExternal',
  components: {
    ViewextOrbitCamera,
    ViewextSatelliteCamera,
    ViewextFlybyCamera,
    ViewextChaseCamera
  }
}
</script>
