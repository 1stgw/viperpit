<template>
  <div class="card card-default">
    <div class="card-heading">LIGHTING PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="LIGHT: INST PNL Knob (Primary)"
              description="LIGHT: INST PNL Knob (Primary) - Step Up"
              label="INST PNL Knob (Primary)"
              type="button"
            >
              <control
                id="lightInstPnlKnobPrimaryStepUp"
                description="LIGHT: INST PNL Knob (Primary) - Step Up"
                label="Step Up"
                type="button"
                role="up"
              />
              <control
                id="lightInstPnlKnobPrimaryStepDown"
                description="LIGHT: INST PNL Knob (Primary) - Step Down"
                label="Step Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="LIGHT: DED Knob (Primary)"
              description="LIGHT: DED Knob (Primary) - Step Up"
              label="DED Knob (Primary)"
              type="button"
            >
              <control
                id="lightDedKnobPrimaryStepUp"
                description="LIGHT: DED Knob (Primary) - Step Up"
                label="Step Up"
                type="button"
                role="up"
              />
              <control
                id="lightDedKnobPrimaryStepDown"
                description="LIGHT: DED Knob (Primary) - Step Down"
                label="Step Down"
                type="button"
                role="down"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="LIGHT: CONSOLES Knob (Flood)"
              description="LIGHT: CONSOLES Knob (Flood) - Step Up"
              label="CONSOLES Knob (Flood)"
              type="button"
            >
              <control
                id="lightConsolesKnobFloodStepUp"
                description="LIGHT: CONSOLES Knob (Flood) - Step Up"
                label="Step Up"
                type="button"
                role="up"
              />
              <control
                id="lightConsolesKnobFloodStepDown"
                description="LIGHT: CONSOLES Knob (Flood) - Step Down"
                label="Step Down"
                type="button"
                role="down"
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

export default {
  name: "LightingPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
