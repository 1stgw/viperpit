<template>
  <v-card outlined>
    <v-card-title>OTHER COCKPIT CALLBACKS</v-card-title>
    <v-container>
      <v-row>
        <v-col>
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
        </v-col>
        <v-col>
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
        </v-col>
        <v-col>
          <button-group
            id="CKPIT: Wheel Brakes"
            description="CKPIT: Wheel Brakes - Hold"
            label="Wheel Brakes"
            type="button"
          >
            <control
              id="ckpitWheelBrakesHold"
              description="CKPIT: Wheel Brakes - Hold"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
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
