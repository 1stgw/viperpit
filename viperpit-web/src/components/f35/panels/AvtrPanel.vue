<template>
  <div class="card card-default">
    <div class="card-heading">AVTR PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="AVTR: AVTR Switch"
              description="AVTR: AVTR Switch - Toggle ON / OFF"
              label="AVTR"
              type="button"
            >
              <control
                id="avtrAvtrSwitchToggleOnOff"
                description="AVTR: AVTR Switch - Toggle ON / OFF"
                label="Toggle ON / OFF"
                type="button"
                role="off"
              />
              <control
                id="avtrAvtrSwitchOn"
                description="AVTR: AVTR Switch - ON"
                label="ON"
                type="button"
                role="on"
              />
              <control
                id="avtrAvtrSwitchAuto"
                description="AVTR: AVTR Switch - AUTO"
                label="AUTO"
                type="button"
                role="none"
              />
              <control
                id="avtrAvtrSwitchOff"
                description="AVTR: AVTR Switch - OFF"
                label="OFF"
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
  name: "AvtrPanel",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
