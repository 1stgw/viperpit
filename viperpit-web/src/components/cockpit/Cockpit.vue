<template>
  <v-container fluid>
    <v-navigation-drawer app clipped permanent width="180">
      <v-list nav dense>
        <v-list-item
          v-for="panelConfiguration in getConsole(consoleId).panelConfigurations"
          :key="panelConfiguration.id"
          link
          :to="{
            name: 'CockpitWithConsoleAndPanel',
            params: { consoleId: consoleId, panelId: panelConfiguration.id }
          }"
        >
          <v-list-item-title>{{ panelConfiguration.label }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-container fluid>
      <panel :panel-configuration="getPanel(consoleId, panelId)" />
    </v-container>
    <v-bottom-navigation v-model="selectedConsoleId" app fixed>
      <v-btn
        v-for="consoleConfiguration in getConsoles"
        :key="consoleConfiguration.id"
        :value="consoleConfiguration.id"
        link
        :to="{
          name: 'CockpitWithConsole',
          params: { consoleId: consoleConfiguration.id }
        }"
      >
        <span>{{ consoleConfiguration.label }}</span>
      </v-btn>
    </v-bottom-navigation>
  </v-container>
</template>

<script lang="ts">
import Vue from "vue";
import { mapGetters } from "vuex";
import Panel from "@/components/cockpit/Panel.vue";

export default Vue.extend({
  name: "Cockpit",
  components: {
    Panel
  },
  props: {
    cockpitId: {
      type: String,
      default: null
    },
    consoleId: {
      type: String,
      required: false,
      default: null
    },
    panelId: {
      type: String,
      required: false,
      default: null
    }
  },
  data: function () {
    return {
      selectedConsoleId: this.consoleId
    };
  },
  computed: {
    ...mapGetters(["getConfiguration", "getConsole", "getConsoles", "getPanel", "getPanels", "isConnected"])
  }
});
</script>
