<template>
  <div class="card card-default">
    <div class="card-heading">ALT GEAR CONTROL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <alt-gear-extend-gear-handle />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <alt-gear-reset-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AltGearExtendGearHandle from "./AltGearExtendGearHandle";
import AltGearResetButton from "./AltGearResetButton";

export default {
  name: "AltGearControl",
  components: {
    AltGearExtendGearHandle,
    AltGearResetButton
  }
};
</script>
