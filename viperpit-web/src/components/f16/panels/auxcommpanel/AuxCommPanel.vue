<template>
  <div class="card card-default">
    <div class="card-heading">AUX COMM PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-master-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-m4-code-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-cni-knob-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-reply-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-monitor-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-channel />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <aux-station-selector-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AuxMasterKnob from "./AuxMasterKnob";
import AuxM4CodeSwitch from "./AuxM4CodeSwitch";
import AuxCniKnobSwitch from "./AuxCniKnobSwitch";
import AuxReplySwitch from "./AuxReplySwitch";
import AuxMonitorSwitch from "./AuxMonitorSwitch";
import AuxChannel from "./AuxChannel";
import AuxStationSelectorSwitch from "./AuxStationSelectorSwitch";

export default {
  name: "AuxCommPanel",
  components: {
    AuxMasterKnob,
    AuxM4CodeSwitch,
    AuxCniKnobSwitch,
    AuxReplySwitch,
    AuxMonitorSwitch,
    AuxChannel,
    AuxStationSelectorSwitch
  }
};
</script>
