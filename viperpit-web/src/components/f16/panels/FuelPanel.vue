<template>
  <div class="card card-default">
    <div class="card-heading">FUEL PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="FUEL: MASTER Switch"
              description="FUEL: MASTER Switch - ON"
              label="MASTER"
              type="switch"
            >
              <control
                id="fuelMasterSwitchOn"
                description="FUEL: MASTER Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="fuelMasterSwitchOff"
                description="FUEL: MASTER Switch - OFF"
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
              id="FUEL: ENG FEED Knob"
              description="FUEL: ENG FEED Knob - OFF"
              label="ENG FEED"
              type="switch"
            >
              <control
                id="fuelEngFeedKnobOff"
                description="FUEL: ENG FEED Knob - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="fuelEngFeedKnobNorm"
                description="FUEL: ENG FEED Knob - NORM"
                label="NORM"
                type="switch"
                role="on"
              />
              <control
                id="fuelEngFeedKnobAft"
                description="FUEL: ENG FEED Knob - AFT"
                label="AFT"
                type="switch"
                role="none"
              />
              <control
                id="fuelEngFeedKnobFwd"
                description="FUEL: ENG FEED Knob - FWD"
                label="FWD"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="FUEL: AIR REFUEL Switch"
              description="FUEL: AIR REFUEL Switch - OPEN"
              label="AIR REFUEL"
              type="switch"
            >
              <control
                id="fuelAirRefuelSwitchOpen"
                description="FUEL: AIR REFUEL Switch - OPEN"
                label="OPEN"
                type="switch"
                role="on"
              />
              <control
                id="fuelAirRefuelSwitchClose"
                description="FUEL: AIR REFUEL Switch - CLOSE"
                label="CLOSE"
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
  name: "FuelPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
