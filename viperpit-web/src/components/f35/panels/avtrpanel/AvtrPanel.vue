<template>
  <div class="card card-default">
    <div class="card-heading">AVTR PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <avtr-avtr-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AvtrAvtrSwitch from "./AvtrAvtrSwitch";

export default {
  name: "AvtrPanel",
  components: {
    AvtrAvtrSwitch
  }
};
</script>
