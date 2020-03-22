<template>
  <div class="card card-default">
    <div class="card-heading">RWR</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="RWR: Brightness Knob"
              description="RWR: Brightness Knob - Increase"
              label="Brightness"
              type="button"
            >
              <control
                id="rwrBrightnessKnobIncrease"
                description="RWR: Brightness Knob - Increase"
                label="Increase"
                type="button"
                role="up"
              />
              <control
                id="rwrBrightnessKnobDecrease"
                description="RWR: Brightness Knob - Decrease"
                label="Decrease"
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
  name: "Rwr",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
