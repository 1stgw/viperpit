<template>
  <v-container>
    <v-row>
      <v-col>
        <other-cockpit-callbacks />
      </v-col>
      <v-col>
        <simulation-hardware />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import OtherCockpitCallbacks from "@/components/f16/panels/OtherCockpitCallbacks";
import SimulationHardware from "@/components/f16/panels/SimulationHardware";

export default {
  name: "Miscellaneous",
  components: {
    OtherCockpitCallbacks,
    SimulationHardware
  }
};
</script>
