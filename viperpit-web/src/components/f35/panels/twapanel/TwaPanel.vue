<template>
  <div class="panel panel-default">
    <div class="panel-heading">TWA PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-sm-6 col-md-4">
          <div align="center" style="padding: 0px;">
            <twa-power-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TwaPowerButton from './TwaPowerButton'

export default {
  name: 'TwaPanel',
  components: {
    TwaPowerButton
  }
}
</script>
