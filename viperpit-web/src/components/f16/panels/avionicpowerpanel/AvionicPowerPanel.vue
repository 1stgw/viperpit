<template>
  <div class="card card-default">
    <div class="card-heading">AVIONIC POWER PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AVIONICS: INS Knob"
              description="AVIONICS: INS Knob - OFF"
              label="INS"
              type="switch"
            >
              <control
                id="avionicsInsKnobOff"
                description="AVIONICS: INS Knob - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="avionicsInsKnobNorm"
                description="AVIONICS: INS Knob - NORM"
                label="NORM"
                type="switch"
                role="on"
              />
              <control
                id="avionicsInsKnobNav"
                description="AVIONICS: INS Knob - NAV"
                label="NAV"
                type="switch"
                role="none"
              />
              <control
                id="avionicsInsKnobInFltAlign"
                description="AVIONICS: INS Knob - IN FLT ALIGN"
                label="IN FLT ALIGN"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AVIONICS: FCC Switch"
              description="AVIONICS: FCC Switch - ON"
              label="FCC"
              type="switch"
            >
              <control
                id="avionicsFccSwitchOn"
                description="AVIONICS: FCC Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="avionicsFccSwitchOff"
                description="AVIONICS: FCC Switch - OFF"
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
              id="AVIONICS: SMS Switch"
              description="AVIONICS: SMS Switch - ON"
              label="SMS"
              type="switch"
            >
              <control
                id="avionicsSmsSwitchOn"
                description="AVIONICS: SMS Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="avionicsSmsSwitchOff"
                description="AVIONICS: SMS Switch - OFF"
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
              id="AVIONICS: MFD Switch"
              description="AVIONICS: MFD Switch - ON"
              label="MFD"
              type="switch"
            >
              <control
                id="avionicsMfdSwitchOn"
                description="AVIONICS: MFD Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="avionicsMfdSwitchOff"
                description="AVIONICS: MFD Switch - OFF"
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
              id="AVIONICS: UFC Switch"
              description="AVIONICS: UFC Switch - ON"
              label="UFC"
              type="switch"
            >
              <control
                id="avionicsUfcSwitchOn"
                description="AVIONICS: UFC Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="avionicsUfcSwitchOff"
                description="AVIONICS: UFC Switch - OFF"
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
              id="AVIONICS: GPS Switch"
              description="AVIONICS: GPS Switch - ON"
              label="GPS"
              type="switch"
            >
              <control
                id="avionicsGpsSwitchOn"
                description="AVIONICS: GPS Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="avionicsGpsSwitchOff"
                description="AVIONICS: GPS Switch - OFF"
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
              id="AVIONICS: DL Switch"
              description="AVIONICS: DL Switch - ON"
              label="DL"
              type="switch"
            >
              <control
                id="avionicsDlSwitchOn"
                description="AVIONICS: DL Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="avionicsDlSwitchOff"
                description="AVIONICS: DL Switch - OFF"
                label="OFF"
                type="switch"
                role="off"
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
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "AvionicPowerPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
