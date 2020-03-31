<template>
  <v-card outlined>
    <v-card-title>CMDS PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="CMDS: RWR Switch"
            description="CMDS: RWR Switch - Power ON"
            label="RWR"
            type="switch"
          >
            <control
              id="cmdsRwrSwitchPowerOn"
              description="CMDS: RWR Switch - Power ON"
              label="Power ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsRwrSwitchPowerOff"
              description="CMDS: RWR Switch - Power OFF"
              label="Power OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: JMR Switch"
            description="CMDS: JMR Switch - Power ON"
            label="JMR"
            type="switch"
          >
            <control
              id="cmdsJmrSwitchPowerOn"
              description="CMDS: JMR Switch - Power ON"
              label="Power ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsJmrSwitchPowerOff"
              description="CMDS: JMR Switch - Power OFF"
              label="Power OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: MWS Switch"
            description="CMDS: MWS Switch - Power ON"
            label="MWS"
            type="switch"
          >
            <control
              id="cmdsMwsSwitchPowerOn"
              description="CMDS: MWS Switch - Power ON"
              label="Power ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsMwsSwitchPowerOff"
              description="CMDS: MWS Switch - Power OFF"
              label="Power OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: O1 Switch"
            description="CMDS: O1 Switch - Power ON"
            label="O1"
            type="switch"
          >
            <control
              id="cmdsO1SwitchPowerOn"
              description="CMDS: O1 Switch - Power ON"
              label="Power ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsO1SwitchPowerOff"
              description="CMDS: O1 Switch - Power OFF"
              label="Power OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: O2 Switch"
            description="CMDS: O2 Switch - Power ON"
            label="O2"
            type="switch"
          >
            <control
              id="cmdsO2SwitchPowerOn"
              description="CMDS: O2 Switch - Power ON"
              label="Power ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsO2SwitchPowerOff"
              description="CMDS: O2 Switch - Power OFF"
              label="Power OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: CH Switch"
            description="CMDS: CH Switch - Power ON"
            label="CH"
            type="switch"
          >
            <control
              id="cmdsChSwitchPowerOn"
              description="CMDS: CH Switch - Power ON"
              label="Power ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsChSwitchPowerOff"
              description="CMDS: CH Switch - Power OFF"
              label="Power OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: FL Switch"
            description="CMDS: FL Switch - Power ON"
            label="FL"
            type="switch"
          >
            <control
              id="cmdsFlSwitchPowerOn"
              description="CMDS: FL Switch - Power ON"
              label="Power ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsFlSwitchPowerOff"
              description="CMDS: FL Switch - Power OFF"
              label="Power OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: JETT Switch"
            description="CMDS: JETT Switch - ON"
            label="JETT"
            type="switch"
          >
            <control
              id="cmdsJettSwitchOn"
              description="CMDS: JETT Switch - ON"
              label="ON"
              type="switch"
              role="on"
            />
            <control
              id="cmdsJettSwitchOff"
              description="CMDS: JETT Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: PRGM Knob"
            description="CMDS: PRGM Knob - 1"
            label="PRGM"
            type="switch"
          >
            <control
              id="cmdsPrgmKnob1"
              description="CMDS: PRGM Knob - 1"
              label="1"
              type="switch"
              role="none"
            />
            <control
              id="cmdsPrgmKnob2"
              description="CMDS: PRGM Knob - 2"
              label="2"
              type="switch"
              role="none"
            />
            <control
              id="cmdsPrgmKnob3"
              description="CMDS: PRGM Knob - 3"
              label="3"
              type="switch"
              role="none"
            />
            <control
              id="cmdsPrgmKnob4"
              description="CMDS: PRGM Knob - 4"
              label="4"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="CMDS: MODE Knob"
            description="CMDS: MODE Knob - OFF"
            label="MODE"
            type="switch"
          >
            <control
              id="cmdsModeKnobOff"
              description="CMDS: MODE Knob - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
            <control
              id="cmdsModeKnobStby"
              description="CMDS: MODE Knob - STBY"
              label="STBY"
              type="switch"
              role="none"
            />
            <control
              id="cmdsModeKnobMan"
              description="CMDS: MODE Knob - MAN"
              label="MAN"
              type="switch"
              role="none"
            />
            <control
              id="cmdsModeKnobSemi"
              description="CMDS: MODE Knob - SEMI"
              label="SEMI"
              type="switch"
              role="none"
            />
            <control
              id="cmdsModeKnobAuto"
              description="CMDS: MODE Knob - AUTO"
              label="AUTO"
              type="switch"
              role="none"
            />
            <control
              id="cmdsModeKnobByp"
              description="CMDS: MODE Knob - BYP"
              label="BYP"
              type="switch"
              role="none"
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
  name: "CmdsPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
