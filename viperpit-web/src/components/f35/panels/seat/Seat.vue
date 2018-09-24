<template>
  <div class="panel panel-default">
    <div class="panel-heading">SEAT</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <seat-safety-lever />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <seat-eject-handle />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SeatSafetyLever from './SeatSafetyLever'
import SeatEjectHandle from './SeatEjectHandle'

export default {
  name: 'Seat',
  components: {
    SeatSafetyLever,
    SeatEjectHandle
  }
}
</script>
