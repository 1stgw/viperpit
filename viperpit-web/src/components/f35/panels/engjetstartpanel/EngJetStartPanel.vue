<template>
  <div class="card card-default">
    <div class="card-heading">ENG & JET START PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <eng-jfs-switch />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <eng-eng-cont-switch />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EngJfsSwitch from "./EngJfsSwitch";
import EngEngContSwitch from "./EngEngContSwitch";

export default {
  name: "EngJetStartPanel",
  components: {
    EngJfsSwitch,
    EngEngContSwitch
  }
};
</script>
