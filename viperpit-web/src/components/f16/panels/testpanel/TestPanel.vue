<template>
  <div class="panel panel-default">
    <div class="panel-heading">TEST PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-fire-oheat-detect-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-oxy-qty-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-mal-ind-lts-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-probe-heat-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-epu-gen-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <test-flcs-pwr-test-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TestFireOheatDetectButton from './TestFireOheatDetectButton'
import TestOxyQtySwitch from './TestOxyQtySwitch'
import TestMalIndLtsButton from './TestMalIndLtsButton'
import TestProbeHeatSwitch from './TestProbeHeatSwitch'
import TestEpuGenSwitch from './TestEpuGenSwitch'
import TestFlcsPwrTestSwitch from './TestFlcsPwrTestSwitch'

export default {
  name: 'TestPanel',
  components: {
    TestFireOheatDetectButton,
    TestOxyQtySwitch,
    TestMalIndLtsButton,
    TestProbeHeatSwitch,
    TestEpuGenSwitch,
    TestFlcsPwrTestSwitch
  }
}
</script>
