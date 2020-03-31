<template>
  <v-card outlined>
    <v-card-title>GENERAL RADIO OPTIONS</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="RADIO: AWACS Menu"
            description="RADIO: AWACS Menu"
            label="AWACS Menu"
            type="button"
          >
            <control
              id="radioAwacsMenu"
              description="RADIO: AWACS Menu"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="RADIO: Wingman Menu"
            description="RADIO: Wingman Menu"
            label="Wingman Menu"
            type="button"
          >
            <control
              id="radioWingmanMenu"
              description="RADIO: Wingman Menu"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="RADIO: Element Menu"
            description="RADIO: Element Menu"
            label="Element Menu"
            type="button"
          >
            <control
              id="radioElementMenu"
              description="RADIO: Element Menu"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="RADIO: Flight Menu"
            description="RADIO: Flight Menu"
            label="Flight Menu"
            type="button"
          >
            <control
              id="radioFlightMenu"
              description="RADIO: Flight Menu"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="RADIO: ATC Menu"
            description="RADIO: ATC Menu"
            label="ATC Menu"
            type="button"
          >
            <control
              id="radioAtcMenu"
              description="RADIO: ATC Menu"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="RADIO: Tanker Menu"
            description="RADIO: Tanker Menu"
            label="Tanker Menu"
            type="button"
          >
            <control
              id="radioTankerMenu"
              description="RADIO: Tanker Menu"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="Radio-Send Message Tanker"
            description="Radio-Send Message Tanker"
            label="Send Message Tanker"
            type="button"
          >
            <control
              id="radioSendMessageTanker"
              description="Radio-Send Message Tanker"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="Radio-Next Menu Tanker"
            description="Radio-Next Menu Tanker"
            label="Next Menu Tanker"
            type="button"
          >
            <control
              id="radioNextMenuTanker"
              description="Radio-Next Menu Tanker"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="Radio-Previous Menu Tanker"
            description="Radio-Previous Menu Tanker"
            label="Previous Menu Tanker"
            type="button"
          >
            <control
              id="radioPreviousMenuTanker"
              description="Radio-Previous Menu Tanker"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
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
