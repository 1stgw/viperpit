<template>
  <div class="card card-default">
    <div class="card-heading">INSTR MODE PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <instr-mode-knob />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import InstrModeKnob from "./InstrModeKnob";

export default {
  name: "InstrModePanel",
  components: {
    InstrModeKnob
  }
};
</script>
