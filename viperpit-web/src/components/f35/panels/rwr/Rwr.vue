<template>
  <div class="panel panel-default">
    <div class="panel-heading">RWR</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <rwr-brightness-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RwrBrightnessKnob from "./RwrBrightnessKnob";

export default {
  name: "Rwr",
  components: {
    RwrBrightnessKnob
  }
};
</script>
