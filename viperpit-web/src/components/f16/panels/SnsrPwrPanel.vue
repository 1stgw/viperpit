<template>
  <v-card outlined>
    <v-card-title>SNSR PWR PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="SNSR: LEFT HDPT Switch"
            description="SNSR: LEFT HDPT Switch - ON"
            label="LEFT HDPT"
            type="switch"
          >
            <control
              id="snsrLeftHdptSwitchOn"
              description="SNSR: LEFT HDPT Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="snsrLeftHdptSwitchOff"
              description="SNSR: LEFT HDPT Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="SNSR: RIGHT HDPT Switch"
            description="SNSR: RIGHT HDPT Switch - ON"
            label="RIGHT HDPT"
            type="switch"
          >
            <control
              id="snsrRightHdptSwitchOn"
              description="SNSR: RIGHT HDPT Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="snsrRightHdptSwitchOff"
              description="SNSR: RIGHT HDPT Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="SNSR: FCR Switch"
            description="SNSR: FCR Switch - ON"
            label="FCR"
            type="switch"
          >
            <control
              id="snsrFcrSwitchOn"
              description="SNSR: FCR Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="snsrFcrSwitchOff"
              description="SNSR: FCR Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="SNSR: RDR ALT Switch"
            description="SNSR: RDR ALT Switch - ON"
            label="RDR ALT"
            type="switch"
          >
            <control
              id="snsrRdrAltSwitchOn"
              description="SNSR: RDR ALT Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="snsrRdrAltSwitchStdby"
              description="SNSR: RDR ALT Switch - STDBY"
              label="STDBY"
              type="switch"
              role="none"
            />
            <control
              id="snsrRdrAltSwitchOff"
              description="SNSR: RDR ALT Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import Control from "@/components/controls/Control";
import SwitchGroup from "@/components/controls/SwitchGroup";

export default {
  name: "SnsrPwrPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
