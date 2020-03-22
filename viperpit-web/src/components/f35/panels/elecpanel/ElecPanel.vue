<template>
  <div class="card card-default">
    <div class="card-heading">ELEC PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="ELEC: MAIN PWR Switch"
              description="ELEC: MAIN PWR Switch - MAIN"
              label="MAIN PWR"
              type="switch"
            >
              <control
                id="elecMainPwrSwitchMain"
                description="ELEC: MAIN PWR Switch - MAIN"
                label="MAIN"
                type="switch"
                role="on"
              />
              <control
                id="elecMainPwrSwitchBatt"
                description="ELEC: MAIN PWR Switch - BATT"
                label="BATT"
                type="switch"
                role="none"
              />
              <control
                id="elecMainPwrSwitchOff"
                description="ELEC: MAIN PWR Switch - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="ELEC: CAUTION RESET Button"
              description="ELEC: CAUTION RESET Button - Push"
              type="button"
            >
              <control
                id="elecCautionResetButtonPush"
                description="ELEC: CAUTION RESET Button - Push"
                label="CAUTION RESET"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Control from "@/components/controls/Control";
import ButtonGroup from "@/components/controls/ButtonGroup";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "ElecPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
