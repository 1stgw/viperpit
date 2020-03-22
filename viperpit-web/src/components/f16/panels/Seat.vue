<template>
  <div class="card card-default">
    <div class="card-heading">SEAT</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
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
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="SEAT: EJECT Handle"
              description="SEAT: EJECT Handle - Hold For Eject"
              type="button"
            >
              <control
                id="seatEjectHandleHoldForEject"
                description="SEAT: EJECT Handle - Hold For Eject"
                label="EJECT"
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
  name: "Seat",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
