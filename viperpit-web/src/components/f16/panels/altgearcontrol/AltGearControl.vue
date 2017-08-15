<template>
  <div class="panel panel-default">
    <div class="panel-heading">ALT GEAR CONTROL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <alt-gear-extend-gear-handle />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <alt-gear-reset-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AltGearExtendGearHandle from './AltGearExtendGearHandle'
import AltGearResetButton from './AltGearResetButton'

export default {
  name: 'AltGearControl',
  components: {
    AltGearExtendGearHandle,
    AltGearResetButton
  }
}
</script>
