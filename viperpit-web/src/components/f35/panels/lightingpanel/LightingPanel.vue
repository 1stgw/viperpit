<template>
  <div class="panel panel-default">
    <div class="panel-heading">LIGHTING PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <light-inst-pnl-knob-primary />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <light-ded-knob-primary />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <light-consoles-knob-flood />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import LightInstPnlKnobPrimary from "./LightInstPnlKnobPrimary";
import LightDedKnobPrimary from "./LightDedKnobPrimary";
import LightConsolesKnobFlood from "./LightConsolesKnobFlood";

export default {
  name: "LightingPanel",
  components: {
    LightInstPnlKnobPrimary,
    LightDedKnobPrimary,
    LightConsolesKnobFlood
  }
};
</script>
