<template>
  <v-card outlined>
    <v-card-title>HUD PANEL</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <switch-group
            id="HUD: Scales Switch"
            description="HUD: Scales Switch - VV/VAH"
            label="Scales"
            type="switch"
          >
            <control
              id="hudScalesSwitchVvVah"
              description="HUD: Scales Switch - VV/VAH"
              label="VV/VAH"
              type="switch"
              role="none"
            />
            <control
              id="hudScalesSwitchVah"
              description="HUD: Scales Switch - VAH"
              label="VAH"
              type="switch"
              role="none"
            />
            <control
              id="hudScalesSwitchOff"
              description="HUD: Scales Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="HUD: FPM Switch"
            description="HUD: FPM Switch - ATT/FPM"
            label="FPM"
            type="switch"
          >
            <control
              id="hudFpmSwitchAttFpm"
              description="HUD: FPM Switch - ATT/FPM"
              label="ATT/FPM"
              type="switch"
              role="none"
            />
            <control
              id="hudFpmSwitchFpm"
              description="HUD: FPM Switch - FPM"
              label="FPM"
              type="switch"
              role="none"
            />
            <control
              id="hudFpmSwitchOff"
              description="HUD: FPM Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="HUD: DED Data Switch"
            description="HUD: DED Data Switch - DED"
            label="DED Data"
            type="switch"
          >
            <control
              id="hudDedDataSwitchDed"
              description="HUD: DED Data Switch - DED"
              label="DED"
              type="switch"
              role="none"
            />
            <control
              id="hudDedDataSwitchPfl"
              description="HUD: DED Data Switch - PFL"
              label="PFL"
              type="switch"
              role="none"
            />
            <control
              id="hudDedDataSwitchOff"
              description="HUD: DED Data Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="HUD: DEPR RET Switch"
            description="HUD: DEPR RET Switch - STBY"
            label="DEPR RET"
            type="switch"
          >
            <control
              id="hudDeprRetSwitchStby"
              description="HUD: DEPR RET Switch - STBY"
              label="STBY"
              type="switch"
              role="none"
            />
            <control
              id="hudDeprRetSwitchPri"
              description="HUD: DEPR RET Switch - PRI"
              label="PRI"
              type="switch"
              role="none"
            />
            <control
              id="hudDeprRetSwitchOff"
              description="HUD: DEPR RET Switch - OFF"
              label="OFF"
              type="switch"
              role="off"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="HUD: Velocity Switch"
            description="HUD: Velocity Switch - CAS"
            label="Velocity"
            type="switch"
          >
            <control
              id="hudVelocitySwitchCas"
              description="HUD: Velocity Switch - CAS"
              label="CAS"
              type="switch"
              role="none"
            />
            <control
              id="hudVelocitySwitchTas"
              description="HUD: Velocity Switch - TAS"
              label="TAS"
              type="switch"
              role="none"
            />
            <control
              id="hudVelocitySwitchGndSpd"
              description="HUD: Velocity Switch - GND SPD"
              label="GND SPD"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="HUD: Altitude Switch"
            description="HUD: Altitude Switch - RADAR"
            label="Altitude"
            type="switch"
          >
            <control
              id="hudAltitudeSwitchRadar"
              description="HUD: Altitude Switch - RADAR"
              label="RADAR"
              type="switch"
              role="none"
            />
            <control
              id="hudAltitudeSwitchBaro"
              description="HUD: Altitude Switch - BARO"
              label="BARO"
              type="switch"
              role="none"
            />
            <control
              id="hudAltitudeSwitchAuto"
              description="HUD: Altitude Switch - AUTO"
              label="AUTO"
              type="switch"
              role="none"
            />
          </switch-group>
        </v-col>
        <v-col>
          <switch-group
            id="HUD: Brightness Switch"
            description="HUD: Brightness Switch - DAY"
            label="Brightness"
            type="switch"
          >
            <control
              id="hudBrightnessSwitchDay"
              description="HUD: Brightness Switch - DAY"
              label="DAY"
              type="switch"
              role="none"
            />
            <control
              id="hudBrightnessSwitchAutoBrt"
              description="HUD: Brightness Switch - AUTO BRT"
              label="AUTO BRT"
              type="switch"
              role="none"
            />
            <control
              id="hudBrightnessSwitchNig"
              description="HUD: Brightness Switch - NIG"
              label="NIG"
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
  name: "HudPanel",
  components: {
    Control,
    SwitchGroup
  }
};
</script>
