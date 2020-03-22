<template>
  <div class="card card-default">
    <div class="card-heading">GENERAL RADIO OPTIONS</div>
    <div class="card-body">
      <div class="row">
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="RADIO: AWACS Menu"
              description="RADIO: AWACS Menu"
              type="button"
            >
              <control
                id="radioAwacsMenu"
                description="RADIO: AWACS Menu"
                label="AWACS Menu"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="RADIO: Wingman Menu"
              description="RADIO: Wingman Menu"
              type="button"
            >
              <control
                id="radioWingmanMenu"
                description="RADIO: Wingman Menu"
                label="Wingman Menu"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="RADIO: Element Menu"
              description="RADIO: Element Menu"
              type="button"
            >
              <control
                id="radioElementMenu"
                description="RADIO: Element Menu"
                label="Element Menu"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="RADIO: Flight Menu"
              description="RADIO: Flight Menu"
              type="button"
            >
              <control
                id="radioFlightMenu"
                description="RADIO: Flight Menu"
                label="Flight Menu"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="RADIO: ATC Menu"
              description="RADIO: ATC Menu"
              type="button"
            >
              <control
                id="radioAtcMenu"
                description="RADIO: ATC Menu"
                label="ATC Menu"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="RADIO: Tanker Menu"
              description="RADIO: Tanker Menu"
              type="button"
            >
              <control
                id="radioTankerMenu"
                description="RADIO: Tanker Menu"
                label="Tanker Menu"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="Radio-Send Message Tanker"
              description="Radio-Send Message Tanker"
              type="button"
            >
              <control
                id="radioSendMessageTanker"
                description="Radio-Send Message Tanker"
                label="Send Message Tanker"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="Radio-Next Menu Tanker"
              description="Radio-Next Menu Tanker"
              type="button"
            >
              <control
                id="radioNextMenuTanker"
                description="Radio-Next Menu Tanker"
                label="Next Menu Tanker"
                type="button"
                role="none"
              />
            </button-group>
          </div>
        </div>
        <div class="col-xs-6 col-sm-6">
          <div align="center" style="padding: 0px;">
            <button-group
              id="Radio-Previous Menu Tanker"
              description="Radio-Previous Menu Tanker"
              type="button"
            >
              <control
                id="radioPreviousMenuTanker"
                description="Radio-Previous Menu Tanker"
                label="Previous Menu Tanker"
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
  name: "GeneralRadioOptions",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
