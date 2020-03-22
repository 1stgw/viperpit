<template>
  <div class="card card-default">
    <div class="card-heading">TEST PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TEST: FIRE & OHEAT DETECT Button"
              description="TEST: FIRE & OHEAT DETECT Button - Hold"
              type="button"
            >
              <control
                id="testFireOheatDetectButtonHold"
                description="TEST: FIRE & OHEAT DETECT Button - Hold"
                label="FIRE & OHEAT DETECT"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TEST: OXY QTY Switch"
              description="TEST: OXY QTY Switch - Hold"
              type="button"
            >
              <control
                id="testOxyQtySwitchHold"
                description="TEST: OXY QTY Switch - Hold"
                label="OXY QTY"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TEST: MAL & IND LTS Button"
              description="TEST: MAL & IND LTS Button - Hold"
              type="button"
            >
              <control
                id="testMalIndLtsButtonHold"
                description="TEST: MAL & IND LTS Button - Hold"
                label="MAL & IND LTS"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="TEST: PROBE HEAT Switch"
              description="TEST: PROBE HEAT Switch - ON"
              label="PROBE HEAT"
              type="switch"
            >
              <control
                id="testProbeHeatSwitchOn"
                description="TEST: PROBE HEAT Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="testProbeHeatSwitchOff"
                description="TEST: PROBE HEAT Switch - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="testProbeHeatSwitchTest"
                description="TEST: PROBE HEAT Switch - TEST"
                label="TEST"
                type="switch"
                role="none"
              />
            </switch-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TEST: EPU/GEN Switch"
              description="TEST: EPU/GEN Switch - Hold"
              type="button"
            >
              <control
                id="testEpuGenSwitchHold"
                description="TEST: EPU/GEN Switch - Hold"
                label="EPU/GEN"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TEST: FLCS PWR TEST Switch"
              description="TEST: FLCS PWR TEST Switch - Hold"
              type="button"
            >
              <control
                id="testFlcsPwrTestSwitchHold"
                description="TEST: FLCS PWR TEST Switch - Hold"
                label="FLCS PWR TEST"
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
  name: "TestPanel",
  components: {
    Control,
    ButtonGroup,
    SwitchGroup
  }
};
</script>
