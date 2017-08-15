<template>
  <div class="panel panel-default">
    <div class="panel-heading">AIR COND PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <air-air-source-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AirAirSourceKnob from './AirAirSourceKnob'

export default {
  name: 'AirCondPanel',
  components: {
    AirAirSourceKnob
  }
}
</script>
