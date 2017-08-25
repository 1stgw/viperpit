<template>
  <div class="panel panel-default">
    <div class="panel-heading">MISC PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <misc-pitch-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <misc-roll-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <misc-adv-mode />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <misc-master-arm-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <misc-laser-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MiscPitchSwitch from './MiscPitchSwitch'
import MiscRollSwitch from './MiscRollSwitch'
import MiscAdvMode from './MiscAdvMode'
import MiscMasterArmSwitch from './MiscMasterArmSwitch'
import MiscLaserSwitch from './MiscLaserSwitch'

export default {
  name: 'MiscPanel',
  components: {
    MiscPitchSwitch,
    MiscRollSwitch,
    MiscAdvMode,
    MiscMasterArmSwitch,
    MiscLaserSwitch
  }
}
</script>
