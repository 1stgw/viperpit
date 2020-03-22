<template>
  <div class="card card-default">
    <div class="card-heading">ENG & JET START PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="ENG: JFS Switch"
              description="ENG: JFS Switch - OFF"
              label="JFS"
              type="switch"
            >
              <control
                id="engJfsSwitchOff"
                description="ENG: JFS Switch - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="engJfsSwitchStart2"
                description="ENG: JFS Switch - START 2"
                label="START 2"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="ENG: ENG CONT Switch"
              description="ENG: ENG CONT Switch - PRI"
              label="ENG CONT"
              type="switch"
            >
              <control
                id="engEngContSwitchPri"
                description="ENG: ENG CONT Switch - PRI"
                label="PRI"
                type="switch"
                role="none"
              />
              <control
                id="engEngContSwitchSec"
                description="ENG: ENG CONT Switch - SEC"
                label="SEC"
                type="switch"
                role="none"
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
  name: "EngJetStartPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
