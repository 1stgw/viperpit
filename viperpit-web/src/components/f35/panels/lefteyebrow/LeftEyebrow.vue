<template>
  <div class="panel panel-default">
    <div class="panel-heading">LEFT EYEBROW</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <eye-f-ack-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <eye-master-caution-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import EyeFAckButton from './EyeFAckButton'
import EyeMasterCautionButton from './EyeMasterCautionButton'

export default {
  name: 'LeftEyebrow',
  components: {
    EyeFAckButton,
    EyeMasterCautionButton
  }
}
</script>
