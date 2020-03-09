<template>
  <div class="panel panel-default">
    <div class="panel-heading">AP AND TFR PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-adv-mode />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-roll-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <misc-pitch-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import MiscAdvMode from "./MiscAdvMode";
import MiscRollSwitch from "./MiscRollSwitch";
import MiscPitchSwitch from "./MiscPitchSwitch";

export default {
  name: "ApAndTfrPanel",
  components: {
    MiscAdvMode,
    MiscRollSwitch,
    MiscPitchSwitch
  }
};
</script>
