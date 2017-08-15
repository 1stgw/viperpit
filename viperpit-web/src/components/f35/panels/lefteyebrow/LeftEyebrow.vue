<template>
  <div class="panel panel-default">
    <div class="panel-heading">LEFT EYEBROW</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <eye-master-caution-button />
          </div>
        </div>
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <eye-f-ack-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EyeMasterCautionButton from './EyeMasterCautionButton'
import EyeFAckButton from './EyeFAckButton'

export default {
  name: 'LeftEyebrow',
  components: {
    EyeMasterCautionButton,
    EyeFAckButton
  }
}
</script>
