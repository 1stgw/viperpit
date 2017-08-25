<template>
  <div class="panel panel-default">
    <div class="panel-heading">UHF PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-mode-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-vol-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-function-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zzzzxx />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zzzxzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zzxzzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zxzzzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-a32-t-rotary-xzzzzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <uhf-preset-channel-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import UhfModeKnob from './UhfModeKnob'
import UhfVolKnob from './UhfVolKnob'
import UhfFunctionKnob from './UhfFunctionKnob'
import UhfManualFrequencyZzzzxx from './UhfManualFrequencyZzzzxx'
import UhfManualFrequencyZzzxzz from './UhfManualFrequencyZzzxzz'
import UhfManualFrequencyZzxzzz from './UhfManualFrequencyZzxzzz'
import UhfManualFrequencyZxzzzz from './UhfManualFrequencyZxzzzz'
import UhfA32TRotaryXzzzzz from './UhfA32TRotaryXzzzzz'
import UhfPresetChannelKnob from './UhfPresetChannelKnob'

export default {
  name: 'UhfPanel',
  components: {
    UhfModeKnob,
    UhfVolKnob,
    UhfFunctionKnob,
    UhfManualFrequencyZzzzxx,
    UhfManualFrequencyZzzxzz,
    UhfManualFrequencyZzxzzz,
    UhfManualFrequencyZxzzzz,
    UhfA32TRotaryXzzzzz,
    UhfPresetChannelKnob
  }
}
</script>
