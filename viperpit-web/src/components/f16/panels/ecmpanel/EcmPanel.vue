<template>
  <div class="card card-default">
    <div class="card-heading">ECM PANEL</div>
    <div class="card-body">
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
import EcmOprSwitch from "./EcmOprSwitch";

export default {
  name: "EcmPanel",
  components: {
    EcmOprSwitch
  }
};
</script>
