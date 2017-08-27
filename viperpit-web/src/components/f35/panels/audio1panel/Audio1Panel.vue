<template>
  <div class="panel panel-default">
    <div class="panel-heading">AUDIO 1 PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <audio1-comm1-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <audio1-comm2-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <audio1-msl-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <audio1-comm1-mode-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <audio1-comm2-mode-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <audio1-threat-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Audio1Comm1Knob from './Audio1Comm1Knob'
import Audio1Comm2Knob from './Audio1Comm2Knob'
import Audio1MslKnob from './Audio1MslKnob'
import Audio1Comm1ModeKnob from './Audio1Comm1ModeKnob'
import Audio1Comm2ModeKnob from './Audio1Comm2ModeKnob'
import Audio1ThreatKnob from './Audio1ThreatKnob'

export default {
  name: 'Audio1Panel',
  components: {
    Audio1Comm1Knob,
    Audio1Comm2Knob,
    Audio1MslKnob,
    Audio1Comm1ModeKnob,
    Audio1Comm2ModeKnob,
    Audio1ThreatKnob
  }
}
</script>
