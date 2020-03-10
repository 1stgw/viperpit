<template>
  <div class="card card-default">
    <div class="card-heading">FUEL QTY PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <qty-fuel-qty-sel-knob />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <qty-ext-fuel-trans-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QtyFuelQtySelKnob from "./QtyFuelQtySelKnob";
import QtyExtFuelTransSwitch from "./QtyExtFuelTransSwitch";

export default {
  name: "FuelQtyPanel",
  components: {
    QtyFuelQtySelKnob,
    QtyExtFuelTransSwitch
  }
};
</script>
