<template>
  <div class="panel panel-default">
    <div class="panel-heading">CMDS PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-mode-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-prgm-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-jett-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-fl-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-ch-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-o2-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-o1-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-mws-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-jmr-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <cmds-rwr-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CmdsModeKnob from './CmdsModeKnob'
import CmdsPrgmKnob from './CmdsPrgmKnob'
import CmdsJettSwitch from './CmdsJettSwitch'
import CmdsFlSwitch from './CmdsFlSwitch'
import CmdsChSwitch from './CmdsChSwitch'
import CmdsO2Switch from './CmdsO2Switch'
import CmdsO1Switch from './CmdsO1Switch'
import CmdsMwsSwitch from './CmdsMwsSwitch'
import CmdsJmrSwitch from './CmdsJmrSwitch'
import CmdsRwrSwitch from './CmdsRwrSwitch'

export default {
  name: 'CmdsPanel',
  components: {
    CmdsModeKnob,
    CmdsPrgmKnob,
    CmdsJettSwitch,
    CmdsFlSwitch,
    CmdsChSwitch,
    CmdsO2Switch,
    CmdsO1Switch,
    CmdsMwsSwitch,
    CmdsJmrSwitch,
    CmdsRwrSwitch
  }
}
</script>
