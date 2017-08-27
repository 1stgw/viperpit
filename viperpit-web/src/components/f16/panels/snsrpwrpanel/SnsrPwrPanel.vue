<template>
  <div class="panel panel-default">
    <div class="panel-heading">SNSR PWR PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <snsr-left-hdpt-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <snsr-right-hdpt-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <snsr-fcr-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <snsr-rdr-alt-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SnsrLeftHdptSwitch from './SnsrLeftHdptSwitch'
import SnsrRightHdptSwitch from './SnsrRightHdptSwitch'
import SnsrFcrSwitch from './SnsrFcrSwitch'
import SnsrRdrAltSwitch from './SnsrRdrAltSwitch'

export default {
  name: 'SnsrPwrPanel',
  components: {
    SnsrLeftHdptSwitch,
    SnsrRightHdptSwitch,
    SnsrFcrSwitch,
    SnsrRdrAltSwitch
  }
}
</script>
