<template>
  <div class="panel panel-default">
    <div class="panel-heading">LEFT SIDE WALL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <left-wall-canopy />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <left-wall-slap-switch-ecm-pgrm5 />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LeftWallCanopy from './LeftWallCanopy'
import LeftWallSlapSwitchEcmPgrm5 from './LeftWallSlapSwitchEcmPgrm5'

export default {
  name: 'LeftSideWall',
  components: {
    LeftWallCanopy,
    LeftWallSlapSwitchEcmPgrm5
  }
}
</script>
