<template>
  <div class="panel panel-default">
    <div class="panel-heading">UHF PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-preset-channel-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-a32-t-rotary-xzzzzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zxzzzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zzxzzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zzzxzz />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-manual-frequency-zzzzxx />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-function-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-vol-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <uhf-mode-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import UhfPresetChannelKnob from './UhfPresetChannelKnob'
import UhfA32TRotaryXzzzzz from './UhfA32TRotaryXzzzzz'
import UhfManualFrequencyZxzzzz from './UhfManualFrequencyZxzzzz'
import UhfManualFrequencyZzxzzz from './UhfManualFrequencyZzxzzz'
import UhfManualFrequencyZzzxzz from './UhfManualFrequencyZzzxzz'
import UhfManualFrequencyZzzzxx from './UhfManualFrequencyZzzzxx'
import UhfFunctionKnob from './UhfFunctionKnob'
import UhfVolKnob from './UhfVolKnob'
import UhfModeKnob from './UhfModeKnob'

export default {
  name: 'UhfPanel',
  components: {
    UhfPresetChannelKnob,
    UhfA32TRotaryXzzzzz,
    UhfManualFrequencyZxzzzz,
    UhfManualFrequencyZzxzzz,
    UhfManualFrequencyZzzxzz,
    UhfManualFrequencyZzzzxx,
    UhfFunctionKnob,
    UhfVolKnob,
    UhfModeKnob
  }
}
</script>
