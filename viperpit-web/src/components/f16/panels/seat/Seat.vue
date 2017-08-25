<template>
  <div class="panel panel-default">
    <div class="panel-heading">SEAT</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <seat-eject-handle />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <seat-safety-lever />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SeatEjectHandle from './SeatEjectHandle'
import SeatSafetyLever from './SeatSafetyLever'

export default {
  name: 'Seat',
  components: {
    SeatEjectHandle,
    SeatSafetyLever
  }
}
</script>
