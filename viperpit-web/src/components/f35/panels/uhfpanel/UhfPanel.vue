<template>
  <div class="card card-default">
    <div class="card-heading">UHF PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="UHF: PRESET CHANNEL Knob"
              description="UHF: PRESET CHANNEL Knob - Cycle Up"
              label="PRESET CHANNEL"
              type="button"
            >
              <control
                id="uhfPresetChannelKnobCycleUp"
                description="UHF: PRESET CHANNEL Knob - Cycle Up"
                label="Cycle Up"
                type="button"
                role="up"
              />
              <control
                id="uhfPresetChannelKnobCycleDown"
                description="UHF: PRESET CHANNEL Knob - Cycle Down"
                label="Cycle Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="UHF: A-3-2-T Rotary X__.___"
              description="UHF: A-3-2-T Rotary X__.___ - Step Up"
              label="A-3-2-T Rotary X__.___"
              type="button"
            >
              <control
                id="uhfA32TRotaryXzzzzzStepUp"
                description="UHF: A-3-2-T Rotary X__.___ - Step Up"
                label="Step Up"
                type="button"
                role="up"
              />
              <control
                id="uhfA32TRotaryXzzzzzStepDown"
                description="UHF: A-3-2-T Rotary X__.___ - Step Down"
                label="Step Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="UHF: Manual Frequency _X_.___"
              description="UHF: Manual Frequency _X_.___ - Cycle Up"
              label="Manual Frequency _X_.___"
              type="button"
            >
              <control
                id="uhfManualFrequencyZxzzzzCycleUp"
                description="UHF: Manual Frequency _X_.___ - Cycle Up"
                label="Cycle Up"
                type="button"
                role="up"
              />
              <control
                id="uhfManualFrequencyZxzzzzCycleDown"
                description="UHF: Manual Frequency _X_.___ - Cycle Down"
                label="Cycle Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="UHF: Manual Frequency __X.___"
              description="UHF: Manual Frequency __X.___ - Cycle Up"
              label="Manual Frequency __X.___"
              type="button"
            >
              <control
                id="uhfManualFrequencyZzxzzzCycleUp"
                description="UHF: Manual Frequency __X.___ - Cycle Up"
                label="Cycle Up"
                type="button"
                role="up"
              />
              <control
                id="uhfManualFrequencyZzxzzzCycleDown"
                description="UHF: Manual Frequency __X.___ - Cycle Down"
                label="Cycle Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="UHF: Manual Frequency ___.X__"
              description="UHF: Manual Frequency ___.X__ - Cycle Up"
              label="Manual Frequency ___.X__"
              type="button"
            >
              <control
                id="uhfManualFrequencyZzzxzzCycleUp"
                description="UHF: Manual Frequency ___.X__ - Cycle Up"
                label="Cycle Up"
                type="button"
                role="up"
              />
              <control
                id="uhfManualFrequencyZzzxzzCycleDown"
                description="UHF: Manual Frequency ___.X__ - Cycle Down"
                label="Cycle Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="UHF: Manual Frequency ___._XX"
              description="UHF: Manual Frequency ___._XX - Cycle Up"
              label="Manual Frequency ___._XX"
              type="button"
            >
              <control
                id="uhfManualFrequencyZzzzxxCycleUp"
                description="UHF: Manual Frequency ___._XX - Cycle Up"
                label="Cycle Up"
                type="button"
                role="up"
              />
              <control
                id="uhfManualFrequencyZzzzxxCycleDown"
                description="UHF: Manual Frequency ___._XX - Cycle Down"
                label="Cycle Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="UHF: FUNCTION Knob"
              description="UHF: FUNCTION Knob - OFF"
              label="FUNCTION"
              type="switch"
            >
              <control
                id="uhfFunctionKnobOff"
                description="UHF: FUNCTION Knob - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="uhfFunctionKnobMain"
                description="UHF: FUNCTION Knob - MAIN"
                label="MAIN"
                type="switch"
                role="on"
              />
              <control
                id="uhfFunctionKnobBoth"
                description="UHF: FUNCTION Knob - BOTH"
                label="BOTH"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="UHF: VOL Knob"
              description="UHF: VOL Knob - AI vs IVC Volume Incr"
              label="VOL"
              type="button"
            >
              <control
                id="uhfVolKnobAiVsIvcVolumeIncr"
                description="UHF: VOL Knob - AI vs IVC Volume Incr"
                label="AI vs IVC Volume Incr"
                type="button"
                role="up"
              />
              <control
                id="uhfVolKnobAiVsIvcVolumeDecr"
                description="UHF: VOL Knob - AI vs IVC Volume Decr"
                label="AI vs IVC Volume Decr"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="UHF: MODE Knob"
              description="UHF: MODE Knob - MNL"
              label="MODE"
              type="switch"
            >
              <control
                id="uhfModeKnobMnl"
                description="UHF: MODE Knob - MNL"
                label="MNL"
                type="switch"
                role="none"
              />
              <control
                id="uhfModeKnobPreset"
                description="UHF: MODE Knob - PRESET"
                label="PRESET"
                type="switch"
                role="none"
              />
              <control
                id="uhfModeKnobGrd"
                description="UHF: MODE Knob - GRD"
                label="GRD"
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
  name: "UhfPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
