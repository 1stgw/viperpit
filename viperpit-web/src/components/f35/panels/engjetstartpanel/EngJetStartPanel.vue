<template>
  <div class="panel panel-default">
    <div class="panel-heading">ENG & JET START PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <eng-eng-cont-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <eng-jfs-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EngEngContSwitch from './EngEngContSwitch'
import EngJfsSwitch from './EngJfsSwitch'

export default {
  name: 'EngJetStartPanel',
  components: {
    EngEngContSwitch,
    EngJfsSwitch
  }
}
</script>
