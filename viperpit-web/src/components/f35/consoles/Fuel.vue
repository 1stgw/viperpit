<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <fuel-panel />
  </div>
  <div class="col-sm-6">
    <fuel-qty-panel />
  </div>
  </div>
</div>
</template>

<script>
import FuelPanel from '../panels/fuelpanel/FuelPanel'
import FuelQtyPanel from '../panels/fuelqtypanel/FuelQtyPanel'

export default {
  name: 'Fuel',
  components: {
    FuelPanel,
    FuelQtyPanel
  }
}
</script>
