<template>
  <v-container>
    <v-app-bar dense>
      <v-tabs align-with-title>
        <!-- eslint-disable-next-line -->
        <v-tab to="/cockpits/f16/consoles/leftconsole">Left Console</v-tab>
        <!-- eslint-disable-next-line -->
        <v-tab to="/cockpits/f16/consoles/leftauxconsole">Left Aux Console</v-tab>
        <!-- eslint-disable-next-line -->
        <v-tab to="/cockpits/f16/consoles/centerconsole">Center Console</v-tab>
        <!-- eslint-disable-next-line -->
        <v-tab to="/cockpits/f16/consoles/rightconsole">Right Console</v-tab>
        <!-- eslint-disable-next-line -->
        <v-tab to="/cockpits/f16/consoles/miscellaneous">Miscellaneous</v-tab>
        <!-- eslint-disable-next-line -->
        <v-tab to="/cockpits/f16/consoles/views">Views</v-tab>
        <!-- eslint-disable-next-line -->
        <v-tab to="/cockpits/f16/consoles/radiocomms">Radio Comms</v-tab>
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
