<template>
  <div class="card card-default">
    <div class="card-heading">LEFT EYEBROW</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="EYE: MASTER CAUTION Button"
              description="EYE: MASTER CAUTION Button - Push"
              type="button"
            >
              <control
                id="eyeMasterCautionButtonPush"
                description="EYE: MASTER CAUTION Button - Push"
                label="MASTER CAUTION"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="EYE: F ACK Button"
              description="EYE: F ACK Button - Push"
              type="button"
            >
              <control
                id="eyeFAckButtonPush"
                description="EYE: F ACK Button - Push"
                label="F ACK"
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
  name: "LeftEyebrow",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
