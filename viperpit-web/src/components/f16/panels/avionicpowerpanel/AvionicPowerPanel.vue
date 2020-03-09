<template>
  <div class="panel panel-default">
    <div class="panel-heading">AVIONIC POWER PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avionics-ins-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avionics-fcc-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avionics-sms-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avionics-mfd-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avionics-ufc-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avionics-gps-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avionics-dl-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AvionicsInsKnob from "./AvionicsInsKnob";
import AvionicsFccSwitch from "./AvionicsFccSwitch";
import AvionicsSmsSwitch from "./AvionicsSmsSwitch";
import AvionicsMfdSwitch from "./AvionicsMfdSwitch";
import AvionicsUfcSwitch from "./AvionicsUfcSwitch";
import AvionicsGpsSwitch from "./AvionicsGpsSwitch";
import AvionicsDlSwitch from "./AvionicsDlSwitch";

export default {
  name: "AvionicPowerPanel",
  components: {
    AvionicsInsKnob,
    AvionicsFccSwitch,
    AvionicsSmsSwitch,
    AvionicsMfdSwitch,
    AvionicsUfcSwitch,
    AvionicsGpsSwitch,
    AvionicsDlSwitch
  }
};
</script>
