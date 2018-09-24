<template>
  <div class="panel panel-default">
    <div class="panel-heading">MISC PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-rf-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-laser-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-master-arm-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-adv-mode />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-roll-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-pitch-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MiscRfSwitch from './MiscRfSwitch'
import MiscLaserSwitch from './MiscLaserSwitch'
import MiscMasterArmSwitch from './MiscMasterArmSwitch'
import MiscAdvMode from './MiscAdvMode'
import MiscRollSwitch from './MiscRollSwitch'
import MiscPitchSwitch from './MiscPitchSwitch'

export default {
  name: 'MiscPanel',
  components: {
    MiscRfSwitch,
    MiscLaserSwitch,
    MiscMasterArmSwitch,
    MiscAdvMode,
    MiscRollSwitch,
    MiscPitchSwitch
  }
}
</script>
