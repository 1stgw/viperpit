<template>
  <v-app dark>
    <v-app-bar dense>
      <div v-if="isConnected">{{ getAgent }}</div>
      <v-spacer />
      <v-tabs align-with-title v-model="tab">
        <v-tab
          :to="{
            name: 'Cockpit',
            params: { cockpitId: 'f16' }
          }"
          >F-16
        </v-tab>
        <v-tab
          :to="{
            name: 'Cockpit',
            params: { cockpitId: 'f35' }
          }"
          >F-35
        </v-tab>
        <v-divider vertical></v-divider>
        <v-tab
          v-for="consoleConfiguration in getConfiguration.consoleConfigurations"
          :key="consoleConfiguration.id"
          :to="{
            name: 'CockpitWithConsole',
            params: { consoleId: consoleConfiguration.id }
          }"
        >
          {{ consoleConfiguration.label }}
        </v-tab>
      </v-tabs>
    </v-app-bar>
    <v-content dark>
      <router-view />
    </v-content>
    <v-overlay :value="!isConnected">
      <v-row justify="center">
        <v-dialog :value="!isConnected" persistent max-width="290">
          <v-card>
            <v-card-title class="headline">No Joy...</v-card-title>
            <v-card-text>Currently there is no flight Airborne...</v-card-text>
          </v-card>
        </v-dialog>
      </v-row>
    </v-overlay>
  </v-app>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "App",
  computed: {
    ...mapGetters(["getAgent", "getConfiguration", "isConnected"])
  },
  data() {
    return {
      tab: null
    };
  }
};
</script>

<style>
#app {
  text-align: center;
}
</style>
