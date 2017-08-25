<template>
  <div class="panel panel-default">
    <div class="panel-heading">AVIONIC POWER  PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <avionics-dl-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <avionics-gps-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <avionics-ufc-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <avionics-mfd-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <avionics-sms-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <avionics-fcc-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <avionics-ins-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AvionicsDlSwitch from './AvionicsDlSwitch'
import AvionicsGpsSwitch from './AvionicsGpsSwitch'
import AvionicsUfcSwitch from './AvionicsUfcSwitch'
import AvionicsMfdSwitch from './AvionicsMfdSwitch'
import AvionicsSmsSwitch from './AvionicsSmsSwitch'
import AvionicsFccSwitch from './AvionicsFccSwitch'
import AvionicsInsKnob from './AvionicsInsKnob'

export default {
  name: 'AvionicPowerPanel',
  components: {
    AvionicsDlSwitch,
    AvionicsGpsSwitch,
    AvionicsUfcSwitch,
    AvionicsMfdSwitch,
    AvionicsSmsSwitch,
    AvionicsFccSwitch,
    AvionicsInsKnob
  }
}
</script>
