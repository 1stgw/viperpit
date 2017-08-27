<template>
  <div class="panel panel-default">
    <div class="panel-heading">MAIN INSTRUMENT</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <main-hsi-hdg-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <main-hsi-crs-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <main-altimeter-pressure-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MainHsiHdgKnob from './MainHsiHdgKnob'
import MainHsiCrsKnob from './MainHsiCrsKnob'
import MainAltimeterPressureKnob from './MainAltimeterPressureKnob'

export default {
  name: 'MainInstrument',
  components: {
    MainHsiHdgKnob,
    MainHsiCrsKnob,
    MainAltimeterPressureKnob
  }
}
</script>
