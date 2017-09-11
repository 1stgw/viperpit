<template>
  <div class="panel panel-default">
    <div class="panel-heading">MISC PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <misc-laser-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <misc-master-arm-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MiscLaserSwitch from './MiscLaserSwitch'
import MiscMasterArmSwitch from './MiscMasterArmSwitch'

export default {
  name: 'MiscPanel',
  components: {
    MiscLaserSwitch,
    MiscMasterArmSwitch
  }
}
</script>
