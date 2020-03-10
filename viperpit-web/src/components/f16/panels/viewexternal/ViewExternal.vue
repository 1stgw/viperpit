<template>
  <div class="card card-default">
    <div class="card-heading">VIEW EXTERNAL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <viewext-orbit-camera />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <viewext-satellite-camera />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <viewext-flyby-camera />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <viewext-chase-camera />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ViewextOrbitCamera from "./ViewextOrbitCamera";
import ViewextSatelliteCamera from "./ViewextSatelliteCamera";
import ViewextFlybyCamera from "./ViewextFlybyCamera";
import ViewextChaseCamera from "./ViewextChaseCamera";

export default {
  name: "ViewExternal",
  components: {
    ViewextOrbitCamera,
    ViewextSatelliteCamera,
    ViewextFlybyCamera,
    ViewextChaseCamera
  }
};
</script>
