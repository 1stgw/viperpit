<template>
  <div class="card card-default">
    <div class="card-heading">AIR COND PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="AIR: AIR SOURCE Knob"
              description="AIR: AIR SOURCE Knob - OFF"
              label="AIR SOURCE"
              type="switch"
            >
              <control
                id="airAirSourceKnobOff"
                description="AIR: AIR SOURCE Knob - OFF"
                label="OFF"
                type="switch"
                role="off"
              />
              <control
                id="airAirSourceKnobNorm"
                description="AIR: AIR SOURCE Knob - NORM"
                label="NORM"
                type="switch"
                role="on"
              />
              <control
                id="airAirSourceKnobDump"
                description="AIR: AIR SOURCE Knob - DUMP"
                label="DUMP"
                type="switch"
                role="none"
              />
              <control
                id="airAirSourceKnobRam"
                description="AIR: AIR SOURCE Knob - RAM"
                label="RAM"
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
  name: "AirCondPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
