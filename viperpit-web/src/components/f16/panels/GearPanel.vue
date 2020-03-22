<template>
  <div class="card card-default">
    <div class="card-heading">GEAR PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="GEAR: EMER STORES JETTISON Button"
              description="GEAR: EMER STORES JETTISON Button - Hold"
              type="button"
            >
              <control
                id="gearEmerStoresJettisonButtonHold"
                description="GEAR: EMER STORES JETTISON Button - Hold"
                label="EMER STORES JETTISON"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="GEAR: HOOK Switch"
              description="GEAR: HOOK Switch - UP"
              label="HOOK"
              type="switch"
            >
              <control
                id="gearHookSwitchUp"
                description="GEAR: HOOK Switch - UP"
                label="UP"
                type="switch"
                role="up"
              />
              <control
                id="gearHookSwitchDn"
                description="GEAR: HOOK Switch - DN"
                label="DN"
                type="switch"
                role="down"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="GEAR: GND JETT Switch"
              description="GEAR: GND JETT Switch - ENABLE"
              label="GND JETT"
              type="switch"
            >
              <control
                id="gearGndJettSwitchEnable"
                description="GEAR: GND JETT Switch - ENABLE"
                label="ENABLE"
                type="switch"
                role="on"
              />
              <control
                id="gearGndJettSwitchOff"
                description="GEAR: GND JETT Switch - OFF"
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
              id="GEAR: PARKING BREAK Switch"
              description="GEAR: PARKING BREAK Switch - ON"
              label="PARKING BREAK"
              type="switch"
            >
              <control
                id="gearParkingBreakSwitchOn"
                description="GEAR: PARKING BREAK Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="gearParkingBreakSwitchOff"
                description="GEAR: PARKING BREAK Switch - OFF"
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
              id="GEAR: LG Handle"
              description="GEAR: LG Handle - UP"
              label="LG"
              type="switch"
            >
              <control
                id="gearLgHandleUp"
                description="GEAR: LG Handle - UP"
                label="UP"
                type="switch"
                role="up"
              />
              <control
                id="gearLgHandleDn"
                description="GEAR: LG Handle - DN"
                label="DN"
                type="switch"
                role="down"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="GEAR: STORES CONFIG Switch"
              description="GEAR: STORES CONFIG Switch - CAT I"
              label="STORES CONFIG"
              type="switch"
            >
              <control
                id="gearStoresConfigSwitchCatI"
                description="GEAR: STORES CONFIG Switch - CAT I"
                label="CAT I"
                type="switch"
                role="none"
              />
              <control
                id="gearStoresConfigSwitchCatIii"
                description="GEAR: STORES CONFIG Switch - CAT III"
                label="CAT III"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="GEAR: HORN SILENCER Button"
              description="GEAR: HORN SILENCER Button - Push"
              type="button"
            >
              <control
                id="gearHornSilencerButtonPush"
                description="GEAR: HORN SILENCER Button - Push"
                label="HORN SILENCER"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="GEAR: LIGHTS Switch"
              description="GEAR: LIGHTS Switch - LANDING"
              label="LIGHTS"
              type="switch"
            >
              <control
                id="gearLightsSwitchLanding"
                description="GEAR: LIGHTS Switch - LANDING"
                label="LANDING"
                type="switch"
                role="none"
              />
              <control
                id="gearLightsSwitchOff"
                description="GEAR: LIGHTS Switch - OFF"
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
import ButtonGroup from "@/components/controls/ButtonGroup";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "GearPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
