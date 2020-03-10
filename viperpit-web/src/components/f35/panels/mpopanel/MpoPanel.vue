<template>
  <div class="card card-default">
    <div class="card-heading">MPO PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <mpo-manual-pitch-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MpoManualPitchSwitch from "./MpoManualPitchSwitch";

export default {
  name: "MpoPanel",
  components: {
    MpoManualPitchSwitch
  }
};
</script>
