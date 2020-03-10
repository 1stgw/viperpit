<template>
  <div class="card card-default">
    <div class="card-heading">ELEC PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <elec-main-pwr-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <elec-caution-reset-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ElecMainPwrSwitch from "./ElecMainPwrSwitch";
import ElecCautionResetButton from "./ElecCautionResetButton";

export default {
  name: "ElecPanel",
  components: {
    ElecMainPwrSwitch,
    ElecCautionResetButton
  }
};
</script>
