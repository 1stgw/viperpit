<template>
  <div class="card card-default">
    <div class="card-heading">EPU PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <epu-epu-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EpuEpuSwitch from "./EpuEpuSwitch";

export default {
  name: "EpuPanel",
  components: {
    EpuEpuSwitch
  }
};
</script>
