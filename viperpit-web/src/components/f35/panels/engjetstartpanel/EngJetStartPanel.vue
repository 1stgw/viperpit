<template>
  <div class="panel panel-default">
    <div class="panel-heading">ENG & JET START PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <eng-jfs-switch />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <eng-eng-cont-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EngJfsSwitch from './EngJfsSwitch'
import EngEngContSwitch from './EngEngContSwitch'

export default {
  name: 'EngJetStartPanel',
  components: {
    EngJfsSwitch,
    EngEngContSwitch
  }
}
</script>
