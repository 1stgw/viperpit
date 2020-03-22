<template>
  <div class="card card-default">
    <div class="card-heading">ECM PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="ECM: OPR Switch"
              description="ECM: OPR Switch - OPR"
              label="OPR"
              type="switch"
            >
              <control
                id="ecmOprSwitchOpr"
                description="ECM: OPR Switch - OPR"
                label="OPR"
                type="switch"
                role="on"
              />
              <control
                id="ecmOprSwitchOff"
                description="ECM: OPR Switch - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
            </switch-group>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "EcmPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
