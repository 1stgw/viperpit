<template>
  <div class="card card-default">
    <div class="card-heading">LEFT EYEBROW</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <eye-master-caution-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <eye-f-ack-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EyeMasterCautionButton from "./EyeMasterCautionButton";
import EyeFAckButton from "./EyeFAckButton";

export default {
  name: "LeftEyebrow",
  components: {
    EyeMasterCautionButton,
    EyeFAckButton
  }
};
</script>
