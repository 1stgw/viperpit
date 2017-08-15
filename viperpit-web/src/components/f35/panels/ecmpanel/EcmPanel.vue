<template>
  <div class="panel panel-default">
    <div class="panel-heading">ECM PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
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
