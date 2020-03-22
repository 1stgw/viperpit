<template>
  <div class="card card-default">
    <div class="card-heading">TWP</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TWP: HANDOFF"
              description="TWP: HANDOFF - Push"
              type="button"
            >
              <control
                id="twpHandoffPush"
                description="TWP: HANDOFF - Push"
                label="HANDOFF"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TWP: MISSILE LAUNCH"
              description="TWP: MISSILE LAUNCH - Push"
              type="button"
            >
              <control
                id="twpMissileLaunchPush"
                description="TWP: MISSILE LAUNCH - Push"
                label="MISSILE LAUNCH"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TWP: SYS TEST"
              description="TWP: SYS TEST - Push"
              type="button"
            >
              <control
                id="twpSysTestPush"
                description="TWP: SYS TEST - Push"
                label="SYS TEST"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="TWP: TGT SEP"
              description="TWP: TGT SEP - Push"
              type="button"
            >
              <control
                id="twpTgtSepPush"
                description="TWP: TGT SEP - Push"
                label="TGT SEP"
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
  name: "Twp",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
