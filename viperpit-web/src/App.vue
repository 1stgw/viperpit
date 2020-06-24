<template>
  <v-app dark>
    <v-app-bar dense flat short color="black">
      <div v-if="isConnected">
        {{ getAgent }}
      </div>
      <v-spacer />
      <v-tabs align-with-title show-arrows>
        <v-tab
          :to="{
            name: 'Cockpit',
            params: { cockpitId: 'f16' }
          }"
        >
          F-16
        </v-tab>
        <v-tab
          :to="{
            name: 'Cockpit',
            params: { cockpitId: 'f35' }
          }"
        >
          F-35
        </v-tab>
        <v-divider vertical />
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
      <v-spacer />
      <v-btn icon @click="resetStates()">
        <v-icon>mdi-sync</v-icon>
      </v-btn>
    </v-app-bar>
    <v-main dark>
      <router-view />
    </v-main>
    <v-overlay :value="!isConnected">
      <v-row justify="center">
        <v-dialog :value="!isConnected" persistent max-width="290">
          <v-card>
            <v-card-title class="headline">
              No Joy...
            </v-card-title>
            <v-card-text>Currently there is no flight Airborne...</v-card-text>
          </v-card>
        </v-dialog>
      </v-row>
    </v-overlay>
  </v-app>
</template>

<script>
import { mapActions, mapGetters } from "vuex";

export default {
  name: "App",
  data() {
    return {
      tab: null
    };
  },
  computed: {
    ...mapGetters(["getAgent", "getConfiguration", "isConnected"])
  },
  methods: {
    ...mapActions(["resetStates"])
  }
};
</script>

<style>
#app {
  text-align: center;
}
</style>
