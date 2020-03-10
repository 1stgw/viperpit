<template>
  <div class="card card-default">
    <div class="card-heading">LEFT SIDE WALL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <left-wall-slap-switch-ecm-pgrm5 />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <left-wall-canopy />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LeftWallSlapSwitchEcmPgrm5 from "./LeftWallSlapSwitchEcmPgrm5";
import LeftWallCanopy from "./LeftWallCanopy";

export default {
  name: "LeftSideWall",
  components: {
    LeftWallSlapSwitchEcmPgrm5,
    LeftWallCanopy
  }
};
</script>
