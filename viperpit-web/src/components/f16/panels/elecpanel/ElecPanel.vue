<template>
  <div class="panel panel-default">
    <div class="panel-heading">ELEC PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <elec-main-pwr-switch />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <elec-caution-reset-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ElecMainPwrSwitch from './ElecMainPwrSwitch'
import ElecCautionResetButton from './ElecCautionResetButton'

export default {
  name: 'ElecPanel',
  components: {
    ElecMainPwrSwitch,
    ElecCautionResetButton
  }
}
</script>
