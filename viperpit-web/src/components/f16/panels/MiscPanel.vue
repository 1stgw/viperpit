<template>
  <div class="card card-default">
    <div class="card-heading">MISC PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="MISC: RF Switch"
              description="MISC: RF Switch - NORM"
              label="RF"
              type="switch"
            >
              <control
                id="miscRfSwitchNorm"
                description="MISC: RF Switch - NORM"
                label="NORM"
                type="switch"
                role="on"
              />
              <control
                id="miscRfSwitchQuiet"
                description="MISC: RF Switch - QUIET"
                label="QUIET"
                type="switch"
                role="none"
              />
              <control
                id="miscRfSwitchSilent"
                description="MISC: RF Switch - SILENT"
                label="SILENT"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="MISC: LASER Switch"
              description="MISC: LASER Switch - ARM"
              label="LASER"
              type="switch"
            >
              <control
                id="miscLaserSwitchArm"
                description="MISC: LASER Switch - ARM"
                label="ARM"
                type="switch"
                role="none"
              />
              <control
                id="miscLaserSwitchOff"
                description="MISC: LASER Switch - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="MISC: MASTER ARM Switch"
              description="MISC: MASTER ARM Switch - ON"
              label="MASTER ARM"
              type="switch"
            >
              <control
                id="miscMasterArmSwitchOn"
                description="MISC: MASTER ARM Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="miscMasterArmSwitchOff"
                description="MISC: MASTER ARM Switch - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="miscMasterArmSwitchSim"
                description="MISC: MASTER ARM Switch - SIM"
                label="SIM"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="MISC: ADV MODE"
              description="MISC: ADV MODE - Toggle TFR On / Off"
              type="button"
            >
              <control
                id="miscAdvModeToggleTfrOnOff"
                description="MISC: ADV MODE - Toggle TFR On / Off"
                label="ADV MODE"
                type="button"
                role="off"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="MISC: ROLL Switch"
              description="MISC: ROLL Switch - HDG SEL"
              label="ROLL"
              type="switch"
            >
              <control
                id="miscRollSwitchHdgSel"
                description="MISC: ROLL Switch - HDG SEL"
                label="HDG SEL"
                type="switch"
                role="none"
              />
              <control
                id="miscRollSwitchAttHold"
                description="MISC: ROLL Switch - ATT HOLD"
                label="ATT HOLD"
                type="switch"
                role="none"
              />
              <control
                id="miscRollSwitchStrgSel"
                description="MISC: ROLL Switch -  STRG SEL"
                label="STRG SEL"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="MISC: PITCH Switch"
              description="MISC: PITCH Switch - ALT HOLD"
              label="PITCH"
              type="switch"
            >
              <control
                id="miscPitchSwitchAltHold"
                description="MISC: PITCH Switch - ALT HOLD"
                label="ALT HOLD"
                type="switch"
                role="none"
              />
              <control
                id="miscPitchSwitchAPOff"
                description="MISC: PITCH Switch - A/P OFF"
                label="A/P OFF"
                type="switch"
                role="off"
              />
              <control
                id="miscPitchSwitchAttHold"
                description="MISC: PITCH Switch - ATT HOLD"
                label="ATT HOLD"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "MiscPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
