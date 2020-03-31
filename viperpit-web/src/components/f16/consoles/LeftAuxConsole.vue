<template>
  <v-container>
    <v-row>
      <v-col>
        <alt-gear-control />
      </v-col>
      <v-col>
        <twa-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <hmcs-panel />
      </v-col>
      <v-col>
        <cmds-panel />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <gear-panel />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import AltGearControl from "@/components/f16/panels/AltGearControl";
import TwaPanel from "@/components/f16/panels/TwaPanel";
import HmcsPanel from "@/components/f16/panels/HmcsPanel";
import CmdsPanel from "@/components/f16/panels/CmdsPanel";
import GearPanel from "@/components/f16/panels/GearPanel";

export default {
  name: "LeftAuxConsole",
  components: {
    AltGearControl,
    TwaPanel,
    HmcsPanel,
    CmdsPanel,
    GearPanel
  }
};
</script>
