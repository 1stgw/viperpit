<template>
  <div class="panel panel-default">
    <div class="panel-heading">OTHER COCKPIT CALLBACKS</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <ckpit-wheel-brakes />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import CkpitWheelBrakes from './CkpitWheelBrakes'

export default {
  name: 'OtherCockpitCallbacks',
  components: {
    CkpitWheelBrakes
  }
}
</script>
