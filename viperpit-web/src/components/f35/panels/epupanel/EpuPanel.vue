<template>
  <div class="panel panel-default">
    <div class="panel-heading">EPU PANEL</div>
    <div class="panel-body">
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
import EpuEpuSwitch from './EpuEpuSwitch'

export default {
  name: 'EpuPanel',
  components: {
    EpuEpuSwitch
  }
}
</script>
