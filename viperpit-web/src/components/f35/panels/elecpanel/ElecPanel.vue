<template>
  <div class="panel panel-default">
    <div class="panel-heading">ELEC PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <elec-caution-reset-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <elec-main-pwr-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ElecCautionResetButton from './ElecCautionResetButton'
import ElecMainPwrSwitch from './ElecMainPwrSwitch'

export default {
  name: 'ElecPanel',
  components: {
    ElecCautionResetButton,
    ElecMainPwrSwitch
  }
}
</script>
