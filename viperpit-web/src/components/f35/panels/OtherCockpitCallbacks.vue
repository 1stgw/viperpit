<template>
  <div class="card card-default">
    <div class="card-heading">OTHER COCKPIT CALLBACKS</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="CKPIT: Nightvision"
              description="CKPIT: Nightvision - On"
              label="Nightvision"
              type="button"
            >
              <control
                id="ckpitNightvisionOn"
                description="CKPIT: Nightvision - On"
                label="On"
                type="button"
                role="on"
              />
              <control
                id="ckpitNightvisionOff"
                description="CKPIT: Nightvision - Off"
                label="Off"
                type="button"
                role="off"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="CKPIT: Smoke"
              description="CKPIT: Smoke - On"
              label="Smoke"
              type="button"
            >
              <control
                id="ckpitSmokeOn"
                description="CKPIT: Smoke - On"
                label="On"
                type="button"
                role="on"
              />
              <control
                id="ckpitSmokeOff"
                description="CKPIT: Smoke - Off"
                label="Off"
                type="button"
                role="off"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="CKPIT: Wheel Brakes"
              description="CKPIT: Wheel Brakes - Hold"
              type="button"
            >
              <control
                id="ckpitWheelBrakesHold"
                description="CKPIT: Wheel Brakes - Hold"
                label="Wheel Brakes"
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

export default {
  name: "OtherCockpitCallbacks",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
