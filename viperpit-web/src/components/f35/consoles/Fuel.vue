<template>
<div class="container-fluid">
  <div class="row">
  <div class="col-sm-6">
    <fuel-qty-panel />
  </div>
  <div class="col-sm-6">
    <fuel-panel />
  </div>
  </div>
</div>
</template>

<script>
import FuelQtyPanel from '../panels/fuelqtypanel/FuelQtyPanel'
import FuelPanel from '../panels/fuelpanel/FuelPanel'

export default {
  name: 'Fuel',
  components: {
    FuelQtyPanel,
    FuelPanel
  }
}
</script>
