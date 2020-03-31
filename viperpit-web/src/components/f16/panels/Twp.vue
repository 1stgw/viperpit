<template>
  <v-card outlined>
    <v-card-title>TWP</v-card-title>
    <v-container>
      <v-row>
        <v-col>
          <button-group
            id="TWP: HANDOFF"
            description="TWP: HANDOFF - Push"
            label="HANDOFF"
            type="button"
          >
            <control
              id="twpHandoffPush"
              description="TWP: HANDOFF - Push"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="TWP: MISSILE LAUNCH"
            description="TWP: MISSILE LAUNCH - Push"
            label="MISSILE LAUNCH"
            type="button"
          >
            <control
              id="twpMissileLaunchPush"
              description="TWP: MISSILE LAUNCH - Push"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="TWP: SYS TEST"
            description="TWP: SYS TEST - Push"
            label="SYS TEST"
            type="button"
          >
            <control
              id="twpSysTestPush"
              description="TWP: SYS TEST - Push"
              label="PUSH"
              type="button"
              role="none"
            />
          </button-group>
        </v-col>
        <v-col>
          <button-group
            id="TWP: TGT SEP"
            description="TWP: TGT SEP - Push"
            label="TGT SEP"
            type="button"
          >
            <control
              id="twpTgtSepPush"
              description="TWP: TGT SEP - Push"
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
  name: "Twp",
  components: {
    Control,
    ButtonGroup
  }
};
</script>
