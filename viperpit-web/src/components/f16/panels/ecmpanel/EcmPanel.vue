<template>
  <div class="panel panel-default">
    <div class="panel-heading">ECM PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <ecm-opr-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EcmOprSwitch from './EcmOprSwitch'

export default {
  name: 'EcmPanel',
  components: {
    EcmOprSwitch
  }
}
</script>
