<template>
  <v-container>
    <v-app-bar dense>
      <v-tabs align-with-title>
        <v-tab :to="{ name: 'LeftConsoleForF16' }">Left Console</v-tab>
        <v-tab :to="{ name: 'LeftAuxConsoleForF16' }">Left Aux Console</v-tab>
        <v-tab :to="{ name: 'CenterConsoleForF16' }">Center Console</v-tab>
        <v-tab :to="{ name: 'RightConsoleForF16' }">Right Console</v-tab>
        <v-tab :to="{ name: 'MiscellaneousForF16' }">Miscellaneous</v-tab>
        <v-tab :to="{ name: 'ViewsForF16' }">Views</v-tab>
        <v-tab :to="{ name: 'RadioCommsForF16' }">Radio Comms</v-tab>
      </v-tabs>
    </v-app-bar>
    <router-view></router-view>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "F16",
  computed: {
    ...mapGetters(["isConnected"])
  }
};
</script>
