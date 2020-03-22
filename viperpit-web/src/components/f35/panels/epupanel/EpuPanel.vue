<template>
  <div class="card card-default">
    <div class="card-heading">EPU PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="EPU: EPU Switch"
              description="EPU: EPU Switch - ON"
              label="EPU"
              type="switch"
            >
              <control
                id="epuEpuSwitchOn"
                description="EPU: EPU Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="epuEpuSwitchNorm"
                description="EPU: EPU Switch - NORM"
                label="NORM"
                type="switch"
                role="on"
              />
              <control
                id="epuEpuSwitchOff"
                description="EPU: EPU Switch - OFF"
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
  name: "EpuPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
