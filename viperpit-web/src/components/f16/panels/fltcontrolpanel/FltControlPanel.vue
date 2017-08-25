<template>
  <div class="panel panel-default">
    <div class="panel-heading">FLT CONTROL PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <flt-bit-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <flt-flcs-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <flt-le-flaps-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <flt-manual-tf-flyup-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <flt-alt-flaps-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <flt-digital-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FltBitSwitch from './FltBitSwitch'
import FltFlcsSwitch from './FltFlcsSwitch'
import FltLeFlapsSwitch from './FltLeFlapsSwitch'
import FltManualTfFlyupSwitch from './FltManualTfFlyupSwitch'
import FltAltFlapsSwitch from './FltAltFlapsSwitch'
import FltDigitalSwitch from './FltDigitalSwitch'

export default {
  name: 'FltControlPanel',
  components: {
    FltBitSwitch,
    FltFlcsSwitch,
    FltLeFlapsSwitch,
    FltManualTfFlyupSwitch,
    FltAltFlapsSwitch,
    FltDigitalSwitch
  }
}
</script>
