<template>
  <div class="panel panel-default">
    <div class="panel-heading">GENERAL RADIO OPTIONS</div>
    <div class="panel-body">
      <div class="row">
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-previous-menu-tanker />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-next-menu-tanker />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-send-message-tanker />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-tanker-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-atc-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-flight-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-element-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-wingman-menu />
          </div>
        </div>
        <div class="col-xs-6 col-sm-4">
          <div align="center" style="padding: 0px;">
            <radio-awacs-menu />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RadioPreviousMenuTanker from './RadioPreviousMenuTanker'
import RadioNextMenuTanker from './RadioNextMenuTanker'
import RadioSendMessageTanker from './RadioSendMessageTanker'
import RadioTankerMenu from './RadioTankerMenu'
import RadioAtcMenu from './RadioAtcMenu'
import RadioFlightMenu from './RadioFlightMenu'
import RadioElementMenu from './RadioElementMenu'
import RadioWingmanMenu from './RadioWingmanMenu'
import RadioAwacsMenu from './RadioAwacsMenu'

export default {
  name: 'GeneralRadioOptions',
  components: {
    RadioPreviousMenuTanker,
    RadioNextMenuTanker,
    RadioSendMessageTanker,
    RadioTankerMenu,
    RadioAtcMenu,
    RadioFlightMenu,
    RadioElementMenu,
    RadioWingmanMenu,
    RadioAwacsMenu
  }
}
</script>
