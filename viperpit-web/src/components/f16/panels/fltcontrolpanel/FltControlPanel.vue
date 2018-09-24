<template>
  <div class="panel panel-default">
    <div class="panel-heading">FLT CONTROL PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <flt-digital-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <flt-alt-flaps-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <flt-manual-tf-flyup-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <flt-le-flaps-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <flt-flcs-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <flt-bit-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FltDigitalSwitch from './FltDigitalSwitch'
import FltAltFlapsSwitch from './FltAltFlapsSwitch'
import FltManualTfFlyupSwitch from './FltManualTfFlyupSwitch'
import FltLeFlapsSwitch from './FltLeFlapsSwitch'
import FltFlcsSwitch from './FltFlcsSwitch'
import FltBitSwitch from './FltBitSwitch'

export default {
  name: 'FltControlPanel',
  components: {
    FltDigitalSwitch,
    FltAltFlapsSwitch,
    FltManualTfFlyupSwitch,
    FltLeFlapsSwitch,
    FltFlcsSwitch,
    FltBitSwitch
  }
}
</script>
