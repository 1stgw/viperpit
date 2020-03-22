<template>
  <div class="card card-default">
    <div class="card-heading">TWA PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TWA: POWER Button"
              description="TWA: POWER Button - On"
              label="POWER"
              type="button"
            >
              <control
                id="twaPowerButtonOn"
                description="TWA: POWER Button - On"
                label="On"
                type="button"
                role="on"
              />
              <control
                id="twaPowerButtonOff"
                description="TWA: POWER Button - Off"
                label="Off"
                type="button"
                role="off"
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
  name: "TwaPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
