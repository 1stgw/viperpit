<template>
  <div class="panel panel-default">
    <div class="panel-heading">AUDIO 2 PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <audio2-intercom-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <audio2-ils-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Audio2IntercomKnob from './Audio2IntercomKnob'
import Audio2IlsKnob from './Audio2IlsKnob'

export default {
  name: 'Audio2Panel',
  components: {
    Audio2IntercomKnob,
    Audio2IlsKnob
  }
}
</script>
