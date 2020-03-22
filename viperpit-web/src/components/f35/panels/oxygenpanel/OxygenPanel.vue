<template>
  <div class="card card-default">
    <div class="card-heading">OXYGEN PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="OXY: Setting 2"
              description="OXY: Setting 2 - ON (Pilot breathing)"
              label="Setting 2"
              type="button"
            >
              <control
                id="oxySetting2OnPilotBreathing"
                description="OXY: Setting 2 - ON (Pilot breathing)"
                label="ON (Pilot breathing)"
                type="button"
                role="none"
              />
              <control
                id="oxySetting2OffPilotBreathing"
                description="OXY: Setting 2 - OFF (Pilot breathing)"
                label="OFF (Pilot breathing)"
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
  name: "OxygenPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
