<template>
  <div class="panel panel-default">
    <div class="panel-heading">MANUAL TRIM PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <trim-pitch-trim-wheel />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <trim-yaw-trim-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <trim-trim-ap-disc-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <trim-roll-trim-wheel />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TrimPitchTrimWheel from './TrimPitchTrimWheel'
import TrimYawTrimKnob from './TrimYawTrimKnob'
import TrimTrimApDiscSwitch from './TrimTrimApDiscSwitch'
import TrimRollTrimWheel from './TrimRollTrimWheel'

export default {
  name: 'ManualTrimPanel',
  components: {
    TrimPitchTrimWheel,
    TrimYawTrimKnob,
    TrimTrimApDiscSwitch,
    TrimRollTrimWheel
  }
}
</script>
