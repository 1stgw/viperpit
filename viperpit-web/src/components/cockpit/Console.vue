<template>
  <v-container>
    <v-row>
      <v-col
        v-for="panelConfiguration in getConsole(id).panelConfigurations"
        :key="panelConfiguration.id"
        md="6"
        sm="12"
      >
        <panel :panel-configuration="panelConfiguration" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import Panel from "@/components/cockpit/Panel";
import { mapGetters } from "vuex";

export default {
  name: "Console",
  components: {
    Panel
  },
  props: {
    id: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapGetters(["getConsole"])
  }
};
</script>
