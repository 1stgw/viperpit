<template>
  <div class="card card-default">
    <div class="card-heading">MPO PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="MPO: MANUAL PITCH Switch"
              description="MPO: MANUAL PITCH Switch - Hold"
              type="button"
            >
              <control
                id="mpoManualPitchSwitchHold"
                description="MPO: MANUAL PITCH Switch - Hold"
                label="MANUAL PITCH"
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

export default {
  name: "MpoPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
