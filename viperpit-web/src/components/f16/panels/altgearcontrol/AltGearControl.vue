<template>
  <div class="card card-default">
    <div class="card-heading">ALT GEAR CONTROL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="ALT GEAR: Extend Gear Handle"
              description="ALT GEAR: Extend Gear Handle - Push"
              type="button"
            >
              <control
                id="altGearExtendGearHandlePush"
                description="ALT GEAR: Extend Gear Handle - Push"
                label="Extend Gear"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="ALT GEAR: Reset Button"
              description="ALT GEAR: Reset Button - Push"
              type="button"
            >
              <control
                id="altGearResetButtonPush"
                description="ALT GEAR: Reset Button - Push"
                label="Reset"
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
  name: "AltGearControl",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
