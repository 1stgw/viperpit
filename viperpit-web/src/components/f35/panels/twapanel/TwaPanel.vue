<template>
  <div class="panel panel-default">
    <div class="panel-heading">TWA PANEL</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twa-power-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twa-search-button />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <twa-low-button />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TwaPowerButton from './TwaPowerButton'
import TwaSearchButton from './TwaSearchButton'
import TwaLowButton from './TwaLowButton'

export default {
  name: 'TwaPanel',
  components: {
    TwaPowerButton,
    TwaSearchButton,
    TwaLowButton
  }
}
</script>
