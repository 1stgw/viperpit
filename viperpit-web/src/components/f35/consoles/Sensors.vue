<template>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <snsr-pwr-panel />
      </div>
    </div>
  </div>
</template>

<script>
import SnsrPwrPanel from "../panels/snsrpwrpanel/SnsrPwrPanel";

export default {
  name: "Sensors",
  components: {
    SnsrPwrPanel
  }
};
</script>
