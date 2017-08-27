<template>
  <div class="panel panel-default">
    <div class="panel-heading">GENERAL RADIO OPTIONS</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-awacs-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-wingman-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-element-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-flight-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-atc-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-tanker-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-send-message-tanker />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-next-menu-tanker />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-previous-menu-tanker />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RadioAwacsMenu from './RadioAwacsMenu'
import RadioWingmanMenu from './RadioWingmanMenu'
import RadioElementMenu from './RadioElementMenu'
import RadioFlightMenu from './RadioFlightMenu'
import RadioAtcMenu from './RadioAtcMenu'
import RadioTankerMenu from './RadioTankerMenu'
import RadioSendMessageTanker from './RadioSendMessageTanker'
import RadioNextMenuTanker from './RadioNextMenuTanker'
import RadioPreviousMenuTanker from './RadioPreviousMenuTanker'

export default {
  name: 'GeneralRadioOptions',
  components: {
    RadioAwacsMenu,
    RadioWingmanMenu,
    RadioElementMenu,
    RadioFlightMenu,
    RadioAtcMenu,
    RadioTankerMenu,
    RadioSendMessageTanker,
    RadioNextMenuTanker,
    RadioPreviousMenuTanker
  }
}
</script>
