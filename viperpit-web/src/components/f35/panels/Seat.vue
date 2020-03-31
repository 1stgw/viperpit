<template>
  <v-card outlined>
    <v-card-title>SEAT</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="SEAT: Safety Lever"
            description="SEAT: Safety Lever - Armed"
            label="Safety Lever"
            type="button"
          >
            <control
              id="seatSafetyLeverArmed"
              description="SEAT: Safety Lever - Armed"
              label="Armed"
              type="button"
              role="none"
            />
            <control
              id="seatSafetyLeverLocked"
              description="SEAT: Safety Lever - Locked"
              label="Locked"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="SEAT: EJECT Handle"
            description="SEAT: EJECT Handle - Hold For Eject"
            label="EJECT"
            type="button"
          >
            <control
              id="seatEjectHandleHoldForEject"
              description="SEAT: EJECT Handle - Hold For Eject"
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
  name: "Seat",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
