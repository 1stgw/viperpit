<template>
  <div class="card card-default">
    <div class="card-heading">HMCS PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <hmcs-hmsc-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import HmcsHmscKnob from "./HmcsHmscKnob";

export default {
  name: "HmcsPanel",
  components: {
    HmcsHmscKnob
  }
};
</script>
