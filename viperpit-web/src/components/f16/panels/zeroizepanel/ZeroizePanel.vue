<template>
  <div class="panel panel-default">
    <div class="panel-heading">ZEROIZE PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <zero-vms-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ZeroVmsSwitch from './ZeroVmsSwitch'

export default {
  name: 'ZeroizePanel',
  components: {
    ZeroVmsSwitch
  }
}
</script>
