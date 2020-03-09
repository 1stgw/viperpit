<template>
  <div class="panel panel-default">
    <div class="panel-heading">ZEROIZE PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <zero-vms-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ZeroVmsSwitch from "./ZeroVmsSwitch";

export default {
  name: "ZeroizePanel",
  components: {
    ZeroVmsSwitch
  }
};
</script>
