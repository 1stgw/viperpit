<template>
  <div class="card card-default">
    <div class="card-heading">INSTR MODE PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="INSTR: MODE Knob"
              description="INSTR: MODE Knob - ILS/TCN"
              label="MODE"
              type="switch"
            >
              <control
                id="instrModeKnobIlsTcn"
                description="INSTR: MODE Knob - ILS/TCN"
                label="ILS/TCN"
                type="switch"
                role="none"
              />
              <control
                id="instrModeKnobTcn"
                description="INSTR: MODE Knob - TCN"
                label="TCN"
                type="switch"
                role="none"
              />
              <control
                id="instrModeKnobNav"
                description="INSTR: MODE Knob - NAV"
                label="NAV"
                type="switch"
                role="none"
              />
              <control
                id="instrModeKnobIlsNav"
                description="INSTR: MODE Knob - ILS/NAV"
                label="ILS/NAV"
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
  name: "InstrModePanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
