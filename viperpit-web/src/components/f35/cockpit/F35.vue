<template>
  <v-container>
    <v-app-bar dense>
      <v-tabs align-with-title>
        <v-tab :to="{ name: 'LeftConsoleForF35' }">Left Console</v-tab>
        <v-tab :to="{ name: 'LeftAuxConsoleForF35' }">Left Aux Console</v-tab>
        <v-tab :to="{ name: 'CenterConsoleForF35' }">Center Console</v-tab>
        <v-tab :to="{ name: 'RightConsoleForF35' }">Right Console</v-tab>
        <v-tab :to="{ name: 'MiscellaneousForF35' }">Miscellaneous</v-tab>
        <v-tab :to="{ name: 'ViewsForF35' }">Views</v-tab>
        <v-tab :to="{ name: 'RadioCommsForF35' }">Radio Comms</v-tab>
      </v-tabs>
    </v-app-bar>
    <router-view></router-view>
  </v-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "F35",
  computed: {
    ...mapGetters(["isConnected"])
  }
};
</script>
