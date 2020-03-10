<template>
  <div class="card card-default">
    <div class="card-heading">CMDS PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-rwr-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-jmr-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-mws-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-o1-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-o2-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-ch-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-fl-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-jett-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-prgm-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <cmds-mode-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CmdsRwrSwitch from "./CmdsRwrSwitch";
import CmdsJmrSwitch from "./CmdsJmrSwitch";
import CmdsMwsSwitch from "./CmdsMwsSwitch";
import CmdsO1Switch from "./CmdsO1Switch";
import CmdsO2Switch from "./CmdsO2Switch";
import CmdsChSwitch from "./CmdsChSwitch";
import CmdsFlSwitch from "./CmdsFlSwitch";
import CmdsJettSwitch from "./CmdsJettSwitch";
import CmdsPrgmKnob from "./CmdsPrgmKnob";
import CmdsModeKnob from "./CmdsModeKnob";

export default {
  name: "CmdsPanel",
  components: {
    CmdsRwrSwitch,
    CmdsJmrSwitch,
    CmdsMwsSwitch,
    CmdsO1Switch,
    CmdsO2Switch,
    CmdsChSwitch,
    CmdsFlSwitch,
    CmdsJettSwitch,
    CmdsPrgmKnob,
    CmdsModeKnob
  }
};
</script>
