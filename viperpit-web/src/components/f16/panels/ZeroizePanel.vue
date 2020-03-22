<template>
  <div class="card card-default">
    <div class="card-heading">ZEROIZE PANEL</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <switch-group
              id="ZERO: VMS Switch"
              description="ZERO: VMS Switch - ON"
              label="VMS"
              type="switch"
            >
              <control
                id="zeroVmsSwitchOn"
                description="ZERO: VMS Switch - ON"
                label="ON"
                type="switch"
                role="on"
              />
              <control
                id="zeroVmsSwitchInhibit"
                description="ZERO: VMS Switch - INHIBIT"
                label="INHIBIT"
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
  name: "ZeroizePanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
