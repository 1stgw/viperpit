<template>
  <div class="card card-default">
    <div class="card-heading">FLT CONTROL PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="FLT: DIGITAL Switch"
              description="FLT: DIGITAL Switch - BACKUP"
              label="DIGITAL"
              type="switch"
            >
              <control
                id="fltDigitalSwitchBackup"
                description="FLT: DIGITAL Switch - BACKUP"
                label="BACKUP"
                type="switch"
                role="none"
              />
              <control
                id="fltDigitalSwitchOff"
                description="FLT: DIGITAL Switch - OFF"
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
              id="FLT: ALT FLAPS Switch"
              description="FLT: ALT FLAPS Switch - EXTEND"
              label="ALT FLAPS"
              type="switch"
            >
              <control
                id="fltAltFlapsSwitchExtend"
                description="FLT: ALT FLAPS Switch - EXTEND"
                label="EXTEND"
                type="switch"
                role="none"
              />
              <control
                id="fltAltFlapsSwitchNorm"
                description="FLT: ALT FLAPS Switch - NORM"
                label="NORM"
                type="switch"
                role="on"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="FLT: MANUAL TF FLYUP Switch"
              description="FLT: MANUAL TF FLYUP Switch - DISABLE"
              label="MANUAL TF FLYUP"
              type="switch"
            >
              <control
                id="fltManualTfFlyupSwitchDisable"
                description="FLT: MANUAL TF FLYUP Switch - DISABLE"
                label="DISABLE"
                type="switch"
                role="off"
              />
              <control
                id="fltManualTfFlyupSwitchEnable"
                description="FLT: MANUAL TF FLYUP Switch - ENABLE"
                label="ENABLE"
                type="switch"
                role="on"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="FLT: LE FLAPS Switch"
              description="FLT: LE FLAPS Switch - LOCK"
              label="LE FLAPS"
              type="switch"
            >
              <control
                id="fltLeFlapsSwitchLock"
                description="FLT: LE FLAPS Switch - LOCK"
                label="LOCK"
                type="switch"
                role="none"
              />
              <control
                id="fltLeFlapsSwitchAuto"
                description="FLT: LE FLAPS Switch - AUTO"
                label="AUTO"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="FLT: FLCS Switch"
              description="FLT: FLCS Switch - Hold"
              type="button"
            >
              <control
                id="fltFlcsSwitchHold"
                description="FLT: FLCS Switch - Hold"
                label="FLCS"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="FLT: BIT Switch"
              description="FLT: BIT Switch - Push"
              type="button"
            >
              <control
                id="fltBitSwitchPush"
                description="FLT: BIT Switch - Push"
                label="BIT"
                type="button"
                role="none"
              />
            </button-group>
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
  name: "FltControlPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
