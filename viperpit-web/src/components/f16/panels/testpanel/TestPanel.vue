<template>
  <div class="panel panel-default">
    <div class="panel-heading">TEST PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-flcs-pwr-test-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-epu-gen-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-probe-heat-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-mal-ind-lts-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-oxy-qty-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-fire-oheat-detect-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TestFlcsPwrTestSwitch from './TestFlcsPwrTestSwitch'
import TestEpuGenSwitch from './TestEpuGenSwitch'
import TestProbeHeatSwitch from './TestProbeHeatSwitch'
import TestMalIndLtsButton from './TestMalIndLtsButton'
import TestOxyQtySwitch from './TestOxyQtySwitch'
import TestFireOheatDetectButton from './TestFireOheatDetectButton'

export default {
  name: 'TestPanel',
  components: {
    TestFlcsPwrTestSwitch,
    TestEpuGenSwitch,
    TestProbeHeatSwitch,
    TestMalIndLtsButton,
    TestOxyQtySwitch,
    TestFireOheatDetectButton
  }
}
</script>
