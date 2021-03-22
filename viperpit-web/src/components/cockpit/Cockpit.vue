<template>
  <v-container fluid>
    <v-row>
      <v-col class="col-2">
        <v-navigation-drawer permanent>
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
      </v-col>
      <v-col class="col-10">
        <v-container fluid>
          <panel :panel-configuration="getPanel(consoleId, panelId)" />
        </v-container>
      </v-col>
    </v-row>
    <v-bottom-navigation v-model="selectedConsoleId" fixed>
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

<script>
import Panel from "@/components/cockpit/Panel";
import { mapGetters } from "vuex";

export default {
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
    //   getConsole: function () {
    //     if (this.consoleId) {
    //       console.log(this.$store.getters.getConsole(this.consoleId));
    //       return this.$store.getters.getConsole(this.consoleId);
    //     } else {
    //       console.log(this.$store.getters.getConsoles());
    //       return this.$store.getters.getConsoles()[0];
    //     }
    //   },
    //   getPanel: function () {
    //     if (this.consoleId) {
    //       console.log(this.$store.getters.getPanel(this.panelId));
    //       return this.$store.getters.getPanel(this.panelId);
    //     } else {
    //       console.log(this.getConsole.panelConfigurations[0]);
    //       return this.getConsole().panelConfigurations[0];
    //     }
    //   },
    //   getPanels: function () {
    //     return this.getConsole().panelConfigurations;
    //   }
    ...mapGetters(["getConfiguration", "getConsole", "getConsoles", "getPanel", "getPanels", "isConnected"])
  }
};
</script>
