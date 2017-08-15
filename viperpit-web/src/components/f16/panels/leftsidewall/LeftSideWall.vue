<template>
  <div class="panel panel-default">
    <div class="panel-heading">LEFT SIDE WALL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <left-wall-slap-switch-ecm-pgrm5 />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <left-wall-canopy />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LeftWallSlapSwitchEcmPgrm5 from './LeftWallSlapSwitchEcmPgrm5'
import LeftWallCanopy from './LeftWallCanopy'

export default {
  name: 'LeftSideWall',
  components: {
    LeftWallSlapSwitchEcmPgrm5,
    LeftWallCanopy
  }
}
</script>
