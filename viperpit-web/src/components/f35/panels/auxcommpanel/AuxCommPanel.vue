<template>
  <div class="card card-default">
    <div class="card-heading">AUX COMM PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AUX: MASTER Knob"
              description="AUX: MASTER Knob - OFF"
              label="MASTER"
              type="switch"
            >
              <control
                id="auxMasterKnobOff"
                description="AUX: MASTER Knob - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="auxMasterKnobStby"
                description="AUX: MASTER Knob - STBY"
                label="STBY"
                type="switch"
                role="none"
              />
              <control
                id="auxMasterKnobLow"
                description="AUX: MASTER Knob - LOW"
                label="LOW"
                type="switch"
                role="none"
              />
              <control
                id="auxMasterKnobNorm"
                description="AUX: MASTER Knob - NORM"
                label="NORM"
                type="switch"
                role="on"
              />
              <control
                id="auxMasterKnobEmer"
                description="AUX: MASTER Knob - EMER"
                label="EMER"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AUX: M-4 CODE Switch"
              description="AUX: M-4 CODE Switch - ZERO"
              label="M-4 CODE"
              type="switch"
            >
              <control
                id="auxM4CodeSwitchZero"
                description="AUX: M-4 CODE Switch - ZERO"
                label="ZERO"
                type="switch"
                role="none"
              />
              <control
                id="auxM4CodeSwitchHold"
                description="AUX: M-4 CODE Switch - HOLD"
                label="HOLD"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AUX: CNI Knob Switch"
              description="AUX: CNI Knob Switch - BACKUP"
              label="CNI Knob"
              type="switch"
            >
              <control
                id="auxCniKnobSwitchBackup"
                description="AUX: CNI Knob Switch - BACKUP"
                label="BACKUP"
                type="switch"
                role="none"
              />
              <control
                id="auxCniKnobSwitchUfc"
                description="AUX: CNI Knob Switch - UFC"
                label="UFC"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AUX: REPLY Switch"
              description="AUX: REPLY Switch - B"
              label="REPLY"
              type="switch"
            >
              <control
                id="auxReplySwitchB"
                description="AUX: REPLY Switch - B"
                label="B"
                type="switch"
                role="none"
              />
              <control
                id="auxReplySwitchA"
                description="AUX: REPLY Switch - A"
                label="A"
                type="switch"
                role="none"
              />
              <control
                id="auxReplySwitchOut"
                description="AUX: REPLY Switch - OUT"
                label="OUT"
                type="switch"
                role="off"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AUX: MONITOR Switch"
              description="AUX: MONITOR Switch - AUDIO"
              label="MONITOR"
              type="switch"
            >
              <control
                id="auxMonitorSwitchAudio"
                description="AUX: MONITOR Switch - AUDIO"
                label="AUDIO"
                type="switch"
                role="none"
              />
              <control
                id="auxMonitorSwitchOut"
                description="AUX: MONITOR Switch - OUT"
                label="OUT"
                type="switch"
                role="off"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="AUX: CHANNEL"
              description="AUX: CHANNEL - Cycle Up Left Digit"
              label="CHANNEL"
              type="button"
            >
              <control
                id="auxChannelCycleUpLeftDigit"
                description="AUX: CHANNEL - Cycle Up Left Digit"
                label="Cycle Up Left Digit"
                type="button"
                role="none"
              />
              <control
                id="auxChannelCycleDownLeftDigit"
                description="AUX: CHANNEL - Cycle Down Left Digit"
                label="Cycle Down Left Digit"
                type="button"
                role="none"
              />
              <control
                id="auxChannelCycleUpCenterDigit"
                description="AUX: CHANNEL - Cycle Up Center Digit"
                label="Cycle Up Center Digit"
                type="button"
                role="none"
              />
              <control
                id="auxChannelCycleDownCenterDig"
                description="AUX: CHANNEL - Cycle Down Center Dig."
                label="Cycle Down Center Dig."
                type="button"
                role="none"
              />
              <control
                id="auxChannelCycleUpRightDigit"
                description="AUX: CHANNEL - Cycle Up Right Digit"
                label="Cycle Up Right Digit"
                type="button"
                role="none"
              />
              <control
                id="auxChannelCycleDownRightDigit"
                description="AUX: CHANNEL - Cycle Down Right Digit"
                label="Cycle Down Right Digit"
                type="button"
                role="none"
              />
              <control
                id="auxChannelToggleBandX"
                description="AUX: CHANNEL - Toggle Band X"
                label="Toggle Band X"
                type="button"
                role="none"
              />
              <control
                id="auxChannelToggleBandY"
                description="AUX: CHANNEL - Toggle Band Y"
                label="Toggle Band Y"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AUX: STATION SELECTOR Switch"
              description="AUX: STATION SELECTOR Switch - T/R"
              label="STATION SELECTOR"
              type="switch"
            >
              <control
                id="auxStationSelectorSwitchTR"
                description="AUX: STATION SELECTOR Switch - T/R"
                label="T/R"
                type="switch"
                role="none"
              />
              <control
                id="auxStationSelectorSwitchAATr"
                description="AUX: STATION SELECTOR Switch - A/A TR"
                label="A/A TR"
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
  name: "AuxCommPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
