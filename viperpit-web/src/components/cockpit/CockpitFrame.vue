<template>
  <div>
    <v-app-bar app dense flat short clipped-left>
      <v-toolbar-title v-if="isConnected">
        {{ getAgent }}
      </v-toolbar-title>
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
      </v-tabs>
      <v-spacer />
      <v-btn icon @click="reload()">
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
            <v-card-title class="headline"> No Joy... </v-card-title>
            <v-card-text>Please start the agent...</v-card-text>
          </v-card>
        </v-dialog>
      </v-row>
    </v-overlay>
  </div>
</template>

<script lang="ts">
import Vue from "vue";
import { mapActions, mapGetters } from "vuex";

export default Vue.extend({
  name: "CockpitFrame",
  data() {
    return {
      tab: null
    };
  },
  computed: {
    ...mapGetters(["getAgent", "getConfiguration", "getConsoles", "isConnected"])
  },
  methods: {
    reload: () => location.reload(),
  }
});
</script>

<style>
#app {
  text-align: center;
}
</style>
