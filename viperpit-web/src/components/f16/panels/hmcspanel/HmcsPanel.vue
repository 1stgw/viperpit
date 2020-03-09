<template>
  <div class="panel panel-default">
    <div class="panel-heading">HMCS PANEL</div>
    <div class="panel-body">
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
